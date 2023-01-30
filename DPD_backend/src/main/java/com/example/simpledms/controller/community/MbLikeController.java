package com.example.simpledms.controller.community;

import com.example.simpledms.dto.community.MbLikeDto;
import com.example.simpledms.model.community.MbLike;
import com.example.simpledms.service.community.MbLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * packageName : com.example.simpledms.controller.community
 * fileName : MbLikeController
 * author : ds
 * date : 2022-12-19
 * description : 모임게시판 좋아요 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class MbLikeController {
    @Autowired
    MbLikeService mbLikeService;

    // 좋아요 클릭 함수
    @PostMapping("/mblike")
    public ResponseEntity<MbLike> addLike(@RequestBody MbLike mbLike) {
        try {
            MbLike mbLike2 = mbLikeService.save(mbLike);

            return new ResponseEntity<>(mbLike2, HttpStatus.OK);
        } catch(Exception e) {
                log.debug(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 좋아요 등록
    @GetMapping("/mblike/{mno}/{userId}")
    public ResponseEntity<Object> findMbByMno(@PathVariable int mno, @PathVariable Long userId) {

        try {
            Optional<MbLike> optionalMbLike = mbLikeService.findLike(mno, userId);

            if (optionalMbLike.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalMbLike.get(), HttpStatus.OK);
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
    @GetMapping("/mblike/{mno}")
    public ResponseEntity<Object> findMbLike(@PathVariable int mno) {

        try {
            Optional<MbLikeDto> optionalMbLikeDto = mbLikeService.CountLike(mno);

            if (optionalMbLikeDto.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalMbLikeDto.get(), HttpStatus.OK);
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
    @DeleteMapping ("/mblike/deletion/{mno}")
    public ResponseEntity<Object> deleteMbLike(@PathVariable Long mno) {

        try {
            boolean bSuccess = mbLikeService.removeById(mno);

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
