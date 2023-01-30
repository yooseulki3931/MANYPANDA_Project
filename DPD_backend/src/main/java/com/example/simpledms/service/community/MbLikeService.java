package com.example.simpledms.service.community;

import com.example.simpledms.dto.community.MbLikeDto;
import com.example.simpledms.model.community.MbLike;
import com.example.simpledms.repository.community.MbLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/**
 * packageName : com.example.simpledms.service.community
 * fileName : MbLikeService
 * author : ds
 * date : 2022-12-19
 * description : 모임게시판 좋아요 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Transactional
@RequiredArgsConstructor
@Service

public class MbLikeService {
    @Autowired
    MbLikeRepository mbLikeRepository;

    // 좋아요 클릭 메서드
    public MbLike save(MbLike mbLike) {
        MbLike mbLike2 = mbLikeRepository.save(mbLike);

        return mbLike2;
    }

    // 좋아요 1회로 제한하는 메서드
    public Optional<MbLike> findLike(int mno, Long userId) {
        Optional<MbLike> optionalMbLike = mbLikeRepository.findLike(mno, userId);

        return optionalMbLike;
    }

    public Optional<MbLikeDto> CountLike(int mno) {
        Optional<MbLikeDto> optionalMbLikeDto = mbLikeRepository.CountLike(mno);

        return optionalMbLikeDto;
    }

    //    삭제
    public boolean removeById(Long mno) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(mbLikeRepository.existsById(mno) == true) {
            mbLikeRepository.deleteById(mno);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

}
