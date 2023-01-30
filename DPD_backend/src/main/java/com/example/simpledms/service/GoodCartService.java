package com.example.simpledms.service;

import com.example.simpledms.model.GoodCart;
import com.example.simpledms.model.community.FbLike;
import com.example.simpledms.repository.GoodCartRepository;
import com.example.simpledms.repository.community.FbLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/**
 * packageName : com.example.simpledms.service
 * fileName : GoodCartService
 * author : ds
 * date : 2022-10-20
 * description : 상품 좋아요 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Transactional
@RequiredArgsConstructor
@Service

public class GoodCartService {
    @Autowired
    GoodCartRepository goodCartRepository;

    // 좋아요 클릭 메서드
    public GoodCart save(GoodCart goodCart) {
        GoodCart goodCart2 = goodCartRepository.save(goodCart);

        return goodCart2;
    }

    // 좋아요 1회로 제한하는 메서드
    public Optional<GoodCart> findCart(int goodsId, Long userId) {
        Optional<GoodCart> optionalGoodCart = goodCartRepository.findCart(goodsId, userId);

        return optionalGoodCart;
    }

//    삭제
    public boolean removeById(int cartId) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(goodCartRepository.existsById(cartId) == true) {
            goodCartRepository.deleteById(cartId);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

}
