package com.example.simpledms.repository.community;

import com.example.simpledms.dto.community.LbLikeDto;
import com.example.simpledms.model.community.LbLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/**
 * packageName : com.example.simpledms.repository.community
 * fileName : LbLikeRepository
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
public interface LbLikeRepository extends JpaRepository<LbLike, Long> {

        // 게시판 번호와 유저아이디로 좋아요 확인 쿼리
        @Query(value = "select l.* from tb_lb_like l where :lno = l.lno and :userId = l.user_id"
                ,nativeQuery = true)
        Optional<LbLike> findLike(@Param("lno") int lno, @Param("userId") Long userId);

        // 좋아요 카운트 상승쿼리
        @Query(value = "select count(*) as count from tb_lb_like b where b.lno = :lno",
                nativeQuery = true)
        Optional<LbLikeDto> CountLike(@Param("lno") int lno);

}
