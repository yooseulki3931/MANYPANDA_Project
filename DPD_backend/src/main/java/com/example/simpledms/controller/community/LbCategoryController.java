package com.example.simpledms.controller.community;

import com.example.simpledms.model.community.LbCategory;
import com.example.simpledms.service.community.LbCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName : com.example.simpledms.controller.community.community
 * fileName : LbCategoryController
 * author : ds
 * date : 2022-12-19
 * description : 분실게시판 카테고리 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class LbCategoryController {

    @Autowired
    LbCategoryService lbCategoryService;

    // 분실게시판 카테고리 등록
    @PostMapping("/lbCategory")
    public ResponseEntity<Object> createCode(@RequestBody LbCategory lbCategory) {
        log.info("lbCategory {}", lbCategory);

        try {
            boolean bResult = lbCategoryService.createLbCategory(lbCategory);
            if (bResult) {
                return new ResponseEntity<Object>(HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Object>(HttpStatus.CONFLICT);
            }

        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 분실게시판 카테고리 목록 조회 (내림차순 - 카테고리명 검색 - 페이징)
    @GetMapping("/lbCategory")
    public ResponseEntity<Object> findAllPageDesc(@RequestParam(required = false) String searchKeyword,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size
    ) {

        try {

//            페이지 변수 저장
            Pageable pageable = PageRequest.of(page, size);

            Page<LbCategory> lbCategoryPage;

//          카테고리 명 (CTitle) 이 없으면 전체 검색 실행
            lbCategoryPage = lbCategoryService.findAllLbCtitleDesc(searchKeyword, pageable);

            Map<String, Object> response = new HashMap<>();
            response.put("lbCategory", lbCategoryPage.getContent());
            response.put("currentPage", lbCategoryPage.getNumber());
            response.put("totalItems", lbCategoryPage.getTotalElements());
            response.put("totalPages", lbCategoryPage.getTotalPages());

            if (lbCategoryPage.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 분실게시판 카테고리 전체 조회
    @GetMapping("/lbCategory/all")
    public ResponseEntity<Object> findAll() {

        try {
            List<LbCategory> lbCategoryList = lbCategoryService.findAll();

            if (lbCategoryList.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(lbCategoryList, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 분실게시판 카테고리 아이디(lbCid)로 삭제
    @DeleteMapping("/lbCategory/{lbCid}")
    public ResponseEntity<Object> deleteId(@PathVariable String lbCid) {

//        프론트엔드 쪽으로 상태정보를 보내줌
        try {
            boolean bSuccess = lbCategoryService.removeById(lbCid);

            if (bSuccess == true) {
//                delete 문이 성공했을 경우
                return new ResponseEntity<>(HttpStatus.OK);
            }
//            delete 실패했을 경우( 0건 삭제가 될경우 )
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
//            DB 에러가 날경우
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
