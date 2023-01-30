package com.example.simpledms.repository.community;

import com.example.simpledms.dto.community.BbLikeDto;
import com.example.simpledms.model.community.BbLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/**
 * packageName : com.example.simpledms.repository.community
 * fileName : BbLikeRepository
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
public interface BbLikeRepository extends JpaRepository<BbLike, Long> {

        // 게시판 번호와 유저아이디로 좋아요 확인 쿼리
        @Query(value = "select b.* from tb_bb_like b where :bno = b.bno and :userId = b.user_id"
                ,nativeQuery = true)
        Optional<BbLike> findLike(@Param("bno") int bno, @Param("userId") Long userId);

        // 좋아요 카운트 상승쿼리
        @Query(value = "select count(*) as count from tb_bb_like b where b.bno = :bno",
        nativeQuery = true)
        Optional<BbLikeDto> CountLike(@Param("bno") int bno);
}
