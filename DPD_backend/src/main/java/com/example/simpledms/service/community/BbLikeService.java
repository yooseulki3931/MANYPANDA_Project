package com.example.simpledms.service.community;

import com.example.simpledms.dto.community.BbLikeDto;
import com.example.simpledms.model.community.BbLike;
import com.example.simpledms.repository.community.BbLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/**
 * packageName : com.example.simpledms.service.community
 * fileName : BbLikeService
 * author : ds
 * date : 2022-12-19
 * description : 추천게시판 좋아요 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Transactional
@RequiredArgsConstructor
@Service

public class BbLikeService {
    @Autowired
    BbLikeRepository bbLikeRepository;

    // 좋아요 클릭 메서드
    public BbLike save(BbLike bbLike) {
        BbLike bbLike2 = bbLikeRepository.save(bbLike);

        return bbLike2;
    }

    // 좋아요 1회로 제한하는 메서드
    public Optional<BbLike> findLike(int bno, Long userId) {
        Optional<BbLike> optionalBbLike = bbLikeRepository.findLike(bno, userId);

        return optionalBbLike;
    }


    public Optional<BbLikeDto> CountLike(int bno) {
        Optional<BbLikeDto> optionalBbLike = bbLikeRepository.CountLike(bno);

        return optionalBbLike;
    }

    //    삭제
    public boolean removeById(Long bno) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(bbLikeRepository.existsById(bno) == true) {
            bbLikeRepository.deleteById(bno);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

}
