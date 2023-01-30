package com.example.simpledms.repository.community;

import com.example.simpledms.model.community.BbComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.simpledms.repository.community
 * fileName : BbCommentRepository
 * author : ds
 * date : 2022-10-20
 * description : 추천게시판 댓글 Repository
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */

@Repository
public interface BbCommentRepository extends JpaRepository<BbComment, Integer> {

    // 댓글 조회 쿼리
    @Query(value = "select c.* from tb_bb_comment c" +
    " where c.bno = :bno " +
            "and c.delete_yn = 'N'"
    ,nativeQuery = true)
    List<BbComment> findCommentAll(@Param("bno") int bno);
}









