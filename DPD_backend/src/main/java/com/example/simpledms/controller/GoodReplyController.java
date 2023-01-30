package com.example.simpledms.controller;

import com.example.simpledms.model.GoodReply;
import com.example.simpledms.service.GoodReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * packageName : com.example.simpledms.controller
 * fileName : GoodReplyController
 * author : ds
 * date : 2022-12-19
 * description : 상품페이지 대댓글 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class GoodReplyController {

    @Autowired
    GoodReplyService goodReplyService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

//    frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
//    frontend url(파라메터방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable

    // 대댓글 조회 함수
    @GetMapping("/goodreply/{goodsId}")
    public ResponseEntity<Object> findCommentAll(@PathVariable int goodsId) {

        try {
//            1) title 이 null 경우 : 전체 검색
//            2) title 에 값이 있을 경우 : 부서명 like 검색
            List<GoodReply> list = Collections.emptyList(); // null 대신 초기화

            list = goodReplyService.findReplyAll(goodsId);

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
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

    // 대댓글 수정 함수
    @PostMapping("/goodreply")
    public ResponseEntity<Object> createReply(@RequestBody GoodReply GoodReply) {

        try {
            GoodReply GoodReply2 = goodReplyService.save(GoodReply);

            return new ResponseEntity<>(GoodReply2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 대댓글 삭제 함수
    @DeleteMapping("/goodreply/deletion/{replyId}")
    public ResponseEntity<Object> deleteReply(@PathVariable int replyId) {

        try {
            boolean bSuccess = goodReplyService.removeById(replyId);

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










