package com.example.simpledms.controller;

import com.example.simpledms.dto.ResponseMessageDto;
import com.example.simpledms.dto.filedb.ResponseFileDto;
import com.example.simpledms.model.FileDb;
import com.example.simpledms.model.ProfileImage;
import com.example.simpledms.service.FileDbService;
import com.example.simpledms.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName : com.example.simpledms.controller
 * fileName : ProfileController
 * author : ds
 * date : 2022-12-16
 * description : 프로필 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-16         정도훈          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    //  Model to Dto 자동변환, Dto to Model 자동변환 외부 라이브러리
    ModelMapper modelMapper = new ModelMapper();


    //    모든 이미지 정보 가져오기 함수
    @GetMapping("profile/detail/{userId}")
    public ResponseEntity<Object> getProfileImage(@PathVariable Long userId) {
        ProfileImage profileImage = profileService.getProfile(userId).get();

        String fileDownloadUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/profile/detail/")
                .path(profileImage.getUserId().toString())
                .toUriString();


        return new ResponseEntity<>(fileDownloadUri, HttpStatus.OK);
    }

    // userId 로 프로필 조회 함수
    @GetMapping("/profile/{userId}")
    public ResponseEntity<byte[]> getProfile(@PathVariable Long userId) {
        ProfileImage profileImage = profileService.getProfile(userId).get();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + profileImage.getFileName() + "\"")
                .body(profileImage.getFileData());


    }

    // 이미지 업로드 컨트롤러 함수
    @PostMapping("/profile/upload")
    public ResponseEntity<Object> ProfileUpload(
            @RequestParam("userId") Long userId,
            @RequestParam("profile") MultipartFile fileDb
    ) {

        String message = ""; // front-end 전송할 메세지

        log.debug("fileDb :" + fileDb);

        try {
//            db 저장 함수 호출
            profileService.store(userId, fileDb);

            message = "Upload the file successfully: " + fileDb.getOriginalFilename();

            return new ResponseEntity<>(new ResponseMessageDto(message), HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            message = "Could not upload the file : " + fileDb.getOriginalFilename();
            return new ResponseEntity<>(new ResponseMessageDto(message),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 번호(pid) 로 프로필 수정 함수
    @PutMapping("/profile/update/{pid}")
    public ResponseEntity<Object> profileUpdate(
            @PathVariable int pid,
            @RequestParam("userId") Long userId,
            @RequestParam("profile") MultipartFile fileDb
    ) {

        String message = ""; // front-end 전송할 메세지

        log.debug("fileDb :" + fileDb);

        try {
//            db 저장 함수 호출
            profileService.store(pid, userId, fileDb);

            message = "Upload the file successfully: " + fileDb.getOriginalFilename();

            return new ResponseEntity<>(new ResponseMessageDto(message), HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            message = "Could not upload the file : " + fileDb.getOriginalFilename();
            return new ResponseEntity<>(new ResponseMessageDto(message),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 번호(pid) 프로필 삭제 함수
    @DeleteMapping("/profile/deletion/{pid}")
    public ResponseEntity<Object> deleteProfile(@PathVariable int pid) {

        try {
            boolean bSuccess = profileService.removeById(pid);

            if (bSuccess == true) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //  profile userid로 뽑아오기
    @GetMapping("/profile")
    public ResponseEntity<Object> getProfile(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "3") int size
    ) {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

//          Upload 이미지 정보를 가져오는 함수
            Page<ResponseFileDto> filePage = profileService
                    .findAllFiles(pageable)
                    .map(dbFile -> {
//                      자동적으로 반복문이 실행됨 : .map()
//                      1) 다운로드 URL 만들기
//          ServletUriComponentsBuilder : URL 만들어 주는 클래스
                        String fileDownloadUri = ServletUriComponentsBuilder
//                                (변경)
//                               .fromCurrentRequest() -> .fromCurrentContextPath()
                                .fromCurrentContextPath() // 이미지 파일 경로
                                .path("/api/profile/")
                                .path(dbFile.getUserId().toString()) // "/api/fileDb/1"
                                .toUriString(); // 마지막에 호출( URL 완성됨 )

//                      modelMapper 로 dbFile == fileDB -> ResponseFileDto 변환
//                      modelMapper.map(소스모델, 타겟DTO.class)
                        ResponseFileDto fileDto = modelMapper.map(dbFile, ResponseFileDto.class);

//                      DTO 에 2개 남은 속성 처리 : setter 이용 가공된 데이터 저장
                        fileDto.setFileSize(dbFile.getFileData().length);
                        fileDto.setFileUrl(fileDownloadUri);

                        return fileDto;
                    });

//            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("fileDb", filePage.getContent());
            response.put("currentPage", filePage.getNumber());
            response.put("totalItems", filePage.getTotalElements());
            response.put("totalPages", filePage.getTotalPages());

            if (filePage.isEmpty() == false) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}










