package com.example.simpledms.controller.community;

import com.example.simpledms.model.community.FbReply;
import com.example.simpledms.service.community.FbReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * packageName : com.example.simpledms.controller.community
 * fileName : FbReplyController
 * author : ds
 * date : 2022-12-19
 * description : 자유게시판 대댓글 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class FbReplyController {

    @Autowired
    FbReplyService fbReplyService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

    // frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
    // frontend url(파라메터방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable

    // 대댓글 조회
    @GetMapping("/fbreply/{fno}")
    public ResponseEntity<Object> findCommentAll(@PathVariable int fno) {

        try {
            List<FbReply> list = Collections.emptyList(); // null 대신 초기화

            list = fbReplyService.findReplyAll(fno);

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

    // 대댓글 등록
    @PostMapping("/fbreply")
    public ResponseEntity<Object> createReply(@RequestBody FbReply fbReply) {

        try {
            FbReply fbReply2 = fbReplyService.save(fbReply);

            return new ResponseEntity<>(fbReply2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 대댓글 삭제 함수
    @DeleteMapping("/fbreply/deletion/{replyId}")
    public ResponseEntity<Object> deleteReply(@PathVariable int replyId) {

        try {
            boolean bSuccess = fbReplyService.removeById(replyId);

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










