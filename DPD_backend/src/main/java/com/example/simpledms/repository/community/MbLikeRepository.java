package com.example.simpledms.repository.community;

import com.example.simpledms.dto.community.MbLikeDto;
import com.example.simpledms.model.community.MbLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/**
 * packageName : com.example.simpledms.repository.community
 * fileName : MbLikeRepository
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Transactional(readOnly = true)
@Repository
public interface MbLikeRepository extends JpaRepository<MbLike, Long> {

        // 게시판 번호와 유저아이디로 좋아요 확인 쿼리
        @Query(value = "select m.* from tb_mb_like m where :mno = m.mno and :userId = m.user_id"
                ,nativeQuery = true)
        Optional<MbLike> findLike(@Param("mno") int mno, @Param("userId") Long userId);

        // 좋아요 카운트 상승쿼리
        @Query(value = "select count(*) as count from tb_mb_like b where b.mno = :mno",
                nativeQuery = true)
        Optional<MbLikeDto> CountLike(@Param("mno") int mno);

}
