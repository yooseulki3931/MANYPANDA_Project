package com.example.simpledms.controller;

import com.example.simpledms.model.Todo;
import com.example.simpledms.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.controller
 * fileName : TodoController
 * author : ds
 * date : 2022-10-21
 * description : TODOLIST 컨트롤러
 * 요약 :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-21         ds          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    TodoService todoService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

//    frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
//    frontend url(파라메터방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable

    // TODOLIST 목록 조회 함수
    @GetMapping("/todo/all/{id}")
    public ResponseEntity<Object> getTodoAll(@PathVariable Long id) {

        try {
            List<Todo> list = Collections.emptyList(); // null 대신 초기화

                list = todoService.findByUserId(id);

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

    // 전체 삭제 함수
    @DeleteMapping("/todo/all")
    public ResponseEntity<Object> removeAll() {

        try {
            todoService.removeAll();

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 수정 함수
    @PostMapping("/todo")
    public ResponseEntity<Object> createTodo(@RequestBody Todo todo) {

        try {
            Todo todo2 = todoService.save(todo);

            return new ResponseEntity<>(todo2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 번호(tno)로 TODOLIST 조회 함수
    @GetMapping("/todo/{tno}")
    public ResponseEntity<Object> getTodoId(@PathVariable int tno) {

        try {
            Optional<Todo> optionalTodo = todoService.findByTno(tno);

            if (optionalTodo.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalTodo.get(), HttpStatus.OK);
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

    // 번호(tno)로 TODOLIST 수정 함수
    @PutMapping("/todo/{tno}")
    public ResponseEntity<Object> updateTodo(@PathVariable int tno,
                                              @RequestBody Todo todo) {

        try {
            Todo todo2 = todoService.save(todo);

            return new ResponseEntity<>(todo2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 번호(tno)로 TODOLIST 삭제 함수
    @DeleteMapping ("/todo/deletion/{tno}")
    public ResponseEntity<Object> deleteTodo(@PathVariable int tno) {

        try {
            boolean bSuccess = todoService.removeById(tno);

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










