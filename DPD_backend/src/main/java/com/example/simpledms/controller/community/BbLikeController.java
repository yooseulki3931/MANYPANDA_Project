package com.example.simpledms.controller.community;

import com.example.simpledms.dto.community.BbLikeDto;
import com.example.simpledms.model.community.BbLike;
import com.example.simpledms.service.community.BbLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * packageName : com.example.simpledms.controller.community
 * fileName : BbLikeController
 * author : ds
 * date : 2022-12-19
 * description : 추천게시판 좋아요 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class BbLikeController {
    @Autowired
    BbLikeService bbLikeService;

    // 좋아요 클릭 함수
    @PostMapping("/bblike")
    public ResponseEntity<BbLike> addLike(@RequestBody BbLike bbLike) {
        try {
            BbLike bbLike2 = bbLikeService.save(bbLike);

            return new ResponseEntity<>(bbLike2, HttpStatus.OK);
        } catch(Exception e) {
                log.debug(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 좋아요 등록
    @GetMapping("/bblike/{bno}/{userId}")
    public ResponseEntity<Object> findBbByBno(@PathVariable int bno, @PathVariable Long userId) {

        try {
            Optional<BbLike> optionalBbLike = bbLikeService.findLike(bno, userId);

            if (optionalBbLike.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalBbLike.get(), HttpStatus.OK);
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
    @GetMapping("/bblike/{bno}")
    public ResponseEntity<Object> findBbLike(@PathVariable int bno) {

        try {
            Optional<BbLikeDto> optionalBbLike = bbLikeService.CountLike(bno);

            if (optionalBbLike.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalBbLike.get(), HttpStatus.OK);
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
    @DeleteMapping ("/bblike/deletion/{bno}")
    public ResponseEntity<Object> deleteBblike(@PathVariable Long bno) {

        try {
            boolean bSuccess = bbLikeService.removeById(bno);

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
