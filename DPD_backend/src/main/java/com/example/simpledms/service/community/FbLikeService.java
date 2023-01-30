package com.example.simpledms.service.community;

import com.example.simpledms.dto.community.FbLikeDto;
import com.example.simpledms.model.community.FbLike;
import com.example.simpledms.repository.community.FbLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/**
 * packageName : com.example.simpledms.service.community
 * fileName : FbLikeService
 * author : ds
 * date : 2022-12-19
 * description : 자유게시판 좋아요 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Transactional
@RequiredArgsConstructor
@Service

public class FbLikeService {
    @Autowired
    FbLikeRepository fbLikeRepository;

    // 좋아요 클릭 메서드
    public FbLike save(FbLike fbLike) {
        FbLike fbLike2 = fbLikeRepository.save(fbLike);

        return fbLike2;
    }

    // 좋아요 1회로 제한하는 메서드
    public Optional<FbLike> findLike(int fno, Long userId) {
        Optional<FbLike> optionalFbLike = fbLikeRepository.findLike(fno, userId);

        return optionalFbLike;
    }

    public Optional<FbLikeDto> CountLike(int fno) {
        Optional<FbLikeDto> optionalFbLikeDtot = fbLikeRepository.CountLike(fno);

        return optionalFbLikeDtot;
    }

    //    삭제
    public boolean removeById(Long fbLikeId) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(fbLikeRepository.existsById(fbLikeId) == true) {
            fbLikeRepository.deleteById(fbLikeId);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }
}
