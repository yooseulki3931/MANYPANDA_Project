package com.example.simpledms.repository.community;

import com.example.simpledms.dto.community.FbLikeDto;
import com.example.simpledms.model.community.FbLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/**
 * packageName : com.example.simpledms.repository.community
 * fileName : FbLikeRepository
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
public interface FbLikeRepository extends JpaRepository<FbLike, Long> {

        // 게시판 번호와 유저아이디로 좋아요 확인 쿼리
        @Query(value = "select f.* from tb_fb_like f where :fno = f.fno and :userId = f.user_id"
                ,nativeQuery = true)
        Optional<FbLike> findLike(@Param("fno") int fno, @Param("userId") Long userId);

        // 좋아요 카운트 상승쿼리
        @Query(value = "select count(*) as count from tb_fb_like b where b.fno = :fno",
                nativeQuery = true)
        Optional<FbLikeDto> CountLike(@Param("fno") int fno);

}
