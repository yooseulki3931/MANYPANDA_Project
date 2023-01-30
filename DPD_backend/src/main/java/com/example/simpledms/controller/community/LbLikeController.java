package com.example.simpledms.controller.community;

import com.example.simpledms.dto.community.LbLikeDto;
import com.example.simpledms.model.community.LbLike;
import com.example.simpledms.service.community.LbLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * packageName : com.example.simpledms.controller.community
 * fileName : LbLikeController
 * author : ds
 * date : 2022-12-19
 * description : 분실게시판 좋아요 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class LbLikeController {
    @Autowired
    LbLikeService lbLikeService;

    // 좋아요 클릭 함수
    @PostMapping("/lblike")
    public ResponseEntity<LbLike> addLike(@RequestBody LbLike lbLike) {
        try {
            LbLike lbLike2 = lbLikeService.save(lbLike);

            return new ResponseEntity<>(lbLike2, HttpStatus.OK);
        } catch(Exception e) {
                log.debug(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 좋아요 등록
    @GetMapping("/lblike/{lno}/{userId}")
    public ResponseEntity<Object> findLbByLno(@PathVariable int lno, @PathVariable Long userId) {

        try {
            Optional<LbLike> optionalLbLike = lbLikeService.findLike(lno, userId);

            if (optionalLbLike.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalLbLike.get(), HttpStatus.OK);
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
    @GetMapping("/lblike/{lno}")
    public ResponseEntity<Object> findLbLike(@PathVariable int lno) {

        try {
            Optional<LbLikeDto> optionalLbLikeDto = lbLikeService.CountLike(lno);

            if (optionalLbLikeDto.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalLbLikeDto.get(), HttpStatus.OK);
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
    @DeleteMapping ("/lblike/deletion/{lno}")
    public ResponseEntity<Object> deleteLbLike(@PathVariable Long lno) {

        try {
            boolean bSuccess = lbLikeService.removeById(lno);

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
