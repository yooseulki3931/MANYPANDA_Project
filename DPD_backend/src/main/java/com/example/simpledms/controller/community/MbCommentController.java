package com.example.simpledms.controller.community;

import com.example.simpledms.model.community.MbComment;
import com.example.simpledms.service.community.MbCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * packageName : com.example.simpledms.controller.community
 * fileName : MbCommentController
 * author : ds
 * date : 2022-12-19
 * description : 모임게시판 댓글 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class MbCommentController {

    @Autowired
    MbCommentService mbCommentService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

    // frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
    // frontend url(파라메터방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable

    // 댓글 조회
    @GetMapping("/mbcomment/{mno}")
    public ResponseEntity<Object> findCommentAll(@PathVariable int mno) {

        try {
            List<MbComment> list = Collections.emptyList(); // null 대신 초기화

            list = mbCommentService.findCommentAll(mno);

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

    // 댓글 등록
    @PostMapping("/mbcomment")
    public ResponseEntity<Object> createComment(@RequestBody MbComment mbComment) {

        try {
            MbComment mbComment2 = mbCommentService.save(mbComment);

            return new ResponseEntity<>(mbComment2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 댓글 삭제 함수
    @DeleteMapping("/mbcomment/deletion/{commentId}")
    public ResponseEntity<Object> deleteComment(@PathVariable int commentId) {

        try {
            boolean bSuccess = mbCommentService.removeById(commentId);

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










