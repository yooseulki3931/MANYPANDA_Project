package com.example.simpledms.controller;

import com.example.simpledms.model.Diary;
import com.example.simpledms.service.DiaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.simpledms.controller
 * fileName : DiaryController
 * author : ds
 * date : 2022-12-19
 * description : 다이어리 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class DiaryController {

    @Autowired
    DiaryService diaryService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

    // frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
    // frontend url(파라메터방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable

    // 마이페이지 다이어리 id 로 리스트 조회
    @GetMapping("/diary/all/{id}")
    public ResponseEntity<Object> getDiaryAll(@PathVariable Long id) {

        try {
            List<Diary> list = Collections.emptyList(); // null 대신 초기화

                list = diaryService.findByUserId(id);

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

    // 마이페이지 다이어리 전체 삭제
    @DeleteMapping("/diary/all")
    public ResponseEntity<Object> removeAll() {

        try {
            diaryService.removeAll();

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 마이페이지 다이어리 등록
    @PostMapping("/diary")
    public ResponseEntity<Object> createDiary(@RequestBody Diary diary) {

        try {
            Diary diary2 = diaryService.save(diary);

            return new ResponseEntity<>(diary2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 마이페이지 다이어리 번호(dno) 로 조회
    @GetMapping("/diary/{dno}")
    public ResponseEntity<Object> getDiaryId(@PathVariable int dno) {

        try {
            Optional<Diary> optionalDiary = diaryService.findById(dno);

            if (optionalDiary.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalDiary.get(), HttpStatus.OK);
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

    // 마이페이지 다이어리 번호(dno) 로 수정
    @PutMapping("/diary/{dno}")
    public ResponseEntity<Object> updateDiary(@PathVariable int dno,
                                              @RequestBody Diary diary) {

        try {
            Diary diary2 = diaryService.save(diary);

            return new ResponseEntity<>(diary2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 마이페이지 다이어리 번호(dno) 로 삭제
    @DeleteMapping ("/diary/deletion/{dno}")
    public ResponseEntity<Object> deleteDiary(@PathVariable int dno) {

        try {
            boolean bSuccess = diaryService.removeById(dno);

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










