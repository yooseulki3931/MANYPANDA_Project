package com.example.simpledms.controller;

import com.example.simpledms.model.GoodCart;
import com.example.simpledms.service.GoodCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * packageName : com.example.simpledms.controller
 * fileName : GoodCartController
 * author : ds
 * date : 2022-12-19
 * description : 좋아요 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class GoodCartController {
    @Autowired
    GoodCartService goodCartService;

    // 좋아요 클릭 함수
    @PostMapping("/goodcart")
    public ResponseEntity<GoodCart> addCart(@RequestBody GoodCart goodCart) {
        try {
            GoodCart goodCart2 = goodCartService.save(goodCart);

            return new ResponseEntity<>(goodCart2, HttpStatus.OK);
        } catch(Exception e) {
                log.debug(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 좋아요 상세페이지 - 유저아이디로 조회 함수
    @GetMapping("/goodcart/{goodsId}/{userId}")
    public ResponseEntity<Object> findGoodsByGoodsId(@PathVariable int goodsId, @PathVariable Long userId) {

        try {
            Optional<GoodCart> optionalGoodCart = goodCartService.findCart(goodsId, userId);

            if (optionalGoodCart.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalGoodCart.get(), HttpStatus.OK);
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

    // 좋아요 cartId 로 삭제 함수
    @DeleteMapping ("/goodcart/deletion/{cartId}")
    public ResponseEntity<Object> delteGoodCart(@PathVariable int cartId) {

        try {
            boolean bSuccess = goodCartService.removeById(cartId);

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
