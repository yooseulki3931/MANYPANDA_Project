package com.example.simpledms.controller.community;

import com.example.simpledms.dto.community.FbLikeDto;
import com.example.simpledms.model.community.FbLike;
import com.example.simpledms.service.community.FbLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * packageName : com.example.simpledms.controller.community
 * fileName : FbLikeController
 * author : ds
 * date : 2022-12-19
 * description : 자유게시판 좋아요 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class FbLikeController {
    @Autowired
    FbLikeService fbLikeService;

    // 좋아요 클릭 함수
    @PostMapping("/fblike")
    public ResponseEntity<FbLike> addLike(@RequestBody FbLike fbLike) {
        try {
            FbLike fbLike2 = fbLikeService.save(fbLike);

            return new ResponseEntity<>(fbLike2, HttpStatus.OK);
        } catch(Exception e) {
                log.debug(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 좋아요 등록
    @GetMapping("/fblike/{fno}/{userId}")
    public ResponseEntity<Object> findFbByFno(@PathVariable int fno, @PathVariable Long userId) {

        try {
            Optional<FbLike> optionalFbLike = fbLikeService.findLike(fno, userId);

            if (optionalFbLike.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalFbLike.get(), HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // 좋아요 count
    @GetMapping("/fblike/{fno}")
    public ResponseEntity<Object> findFbLike(@PathVariable int fno) {

        try {
            Optional<FbLikeDto> optionalFbLikeDto = fbLikeService.CountLike(fno);

            if (optionalFbLikeDto.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalFbLikeDto.get(), HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 좋아요 삭제
    @DeleteMapping ("/fblike/deletion/{fbLikeId}")
    public ResponseEntity<Object> deleteFbLike(@PathVariable Long fbLikeId) {

        try {
            boolean bSuccess = fbLikeService.removeById(fbLikeId);

            if (bSuccess == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
