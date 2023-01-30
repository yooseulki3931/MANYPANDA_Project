package com.example.simpledms.controller;

import com.example.simpledms.dto.ResponseMessageDto;
import com.example.simpledms.dto.filedb.ResponseFileDto;
import com.example.simpledms.model.FileDb;
import com.example.simpledms.service.FileDbService;
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
 * fileName : FileDbController
 * author : ds
 * date : 2022-12-19
 * description : 첨부파일 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class FileDbController {

    @Autowired
    FileDbService fileDbService;

    //  Model to Dto 자동변환, Dto to Model 자동변환 외부 라이브러리
    ModelMapper modelMapper = new ModelMapper();


    // 모든 이미지 정보 가져오기 함수
    @GetMapping("/fileDb")
    public ResponseEntity<Object> getListFiles(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "3") int size
    ) {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

//          Upload 이미지 정보를 가져오는 함수
            Page<ResponseFileDto> filePage = fileDbService
                    .findAllFiles(pageable)
                    .map(dbFile -> {
//                      자동적으로 반복문이 실행됨 : .map()
//                      1) 다운로드 URL 만들기
//          ServletUriComponentsBuilder : URL 만들어 주는 클래스
                        String fileDownloadUri = ServletUriComponentsBuilder
//                                (변경)
//                               .fromCurrentRequest() -> .fromCurrentContextPath()
                                .fromCurrentContextPath() // 이미지 파일 경로
                                .path("/api/fileDb/")
                                .path(dbFile.getFid().toString()) // "/api/fileDb/1"
                                .toUriString(); // 마지막에 호출( URL 완성됨 )

//                      modelMapper 로 dbFile == fileDB -> ResponseFileDto 변환
//                        modelMapper.map(소스모델, 타겟DTO.class)
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

    // Carousel 함수
    @GetMapping("/fileDb/carousel")
    public ResponseEntity<Object> getCarousel(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "3") int size
    ) {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

//          Upload 이미지 정보를 가져오는 함수
            Page<ResponseFileDto> filePage = fileDbService
                    .findCarousel(pageable)
                    .map(dbFile -> {
//                      자동적으로 반복문이 실행됨 : .map()
//                      1) 다운로드 URL 만들기
//          ServletUriComponentsBuilder : URL 만들어 주는 클래스
                        String fileDownloadUri = ServletUriComponentsBuilder
//                                (변경)
//                               .fromCurrentRequest() -> .fromCurrentContextPath()
                                .fromCurrentContextPath() // 이미지 파일 경로
                                .path("/api/fileDb/")
                                .path(dbFile.getFid().toString()) // "/api/fileDb/1"
                                .toUriString(); // 마지막에 호출( URL 완성됨 )

//                      modelMapper 로 dbFile == fileDB -> ResponseFileDto 변환
//                        modelMapper.map(소스모델, 타겟DTO.class)
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

    // 이미지 fid 로 상세조회 컨트롤러 함수
    @GetMapping("fileDb/detail/{fid}")
    public ResponseEntity<Object> getFileDetail(@PathVariable int fid) {
        FileDb fileDb = fileDbService.getFile(fid).get();

        String fileDownloadUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/fileDb/detail/")
                .path(fileDb.getFid().toString())
                .toUriString();


        return new ResponseEntity<>(fileDownloadUri, HttpStatus.OK);
    }

    // 이미지 fid 로 조회 컨트롤러 함수
    @GetMapping("/fileDb/{fid}")
    public ResponseEntity<byte[]> getFile(@PathVariable int fid) {
        FileDb fileDb = fileDbService.getFile(fid).get();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDb.getFileName() + "\"")
                .body(fileDb.getFileData());
    }

    // 이미지 업로드 컨트롤러 함수
    @PostMapping("/fileDb/upload")
    public ResponseEntity<Object> fileDbUploadFile(@RequestParam("fileDb") MultipartFile fileDb
    ) {

        String message = ""; // front-end 전송할 메세지

        log.debug("fileDb :" + fileDb);

        try {
//            db 저장 함수 호출
            fileDbService.store(fileDb);

            message = "Upload the file successfully: " + fileDb.getOriginalFilename();

            return new ResponseEntity<>(new ResponseMessageDto(message), HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            message = "Could not upload the file : " + fileDb.getOriginalFilename();
            return new ResponseEntity<>(new ResponseMessageDto(message),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이미지 fid 로 수정 컨트롤러 함수
    @PutMapping("/fileDb/update/{fid}")
    public ResponseEntity<Object> fileDbUpdateFile(
            @PathVariable int fid,
            @RequestParam("fileDb") MultipartFile fileDb
    ) {

        String message = ""; // front-end 전송할 메세지

        log.debug("fileDb :" + fileDb);

        try {
//            db 저장 함수 호출
            fileDbService.store(fid, fileDb);

            message = "Upload the file successfully: " + fileDb.getOriginalFilename();

            return new ResponseEntity<>(new ResponseMessageDto(message), HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            message = "Could not upload the file : " + fileDb.getOriginalFilename();
            return new ResponseEntity<>(new ResponseMessageDto(message),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이미지 fid 로 삭제 컨트롤러 함수
    @DeleteMapping("/fileDb/deletion/{fid}")
    public ResponseEntity<Object> deleteFileDb(@PathVariable int fid) {

        try {
            boolean bSuccess = fileDbService.removeById(fid);

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
}










