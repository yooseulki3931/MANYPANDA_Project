package com.example.simpledms.service.community;

import com.example.simpledms.dto.community.LbLikeDto;
import com.example.simpledms.model.community.LbLike;
import com.example.simpledms.repository.community.LbLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/**
 * packageName : com.example.simpledms.service.community
 * fileName : LbLikeService
 * author : ds
 * date : 2022-12-19
 * description : 분실게시판 좋아요 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Transactional
@RequiredArgsConstructor
@Service

public class LbLikeService {
    @Autowired
    LbLikeRepository lbLikeRepository;

    // 좋아요 클릭 메서드
    public LbLike save(LbLike lbLike) {
        LbLike lbLike2 = lbLikeRepository.save(lbLike);

        return lbLike2;
    }

    // 좋아요 1회로 제한하는 메서드
    public Optional<LbLike> findLike(int lno, Long userId) {
        Optional<LbLike> optionalLbLike = lbLikeRepository.findLike(lno, userId);

        return optionalLbLike;
    }

    public Optional<LbLikeDto> CountLike(int lno) {
        Optional<LbLikeDto> optionalLbLikeDto = lbLikeRepository.CountLike(lno);

        return optionalLbLikeDto;
    }

    //    삭제
    public boolean removeById(Long lno) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(lbLikeRepository.existsById(lno) == true) {
            lbLikeRepository.deleteById(lno);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

}
