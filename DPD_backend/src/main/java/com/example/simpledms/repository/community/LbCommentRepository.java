package com.example.simpledms.repository.community;

import com.example.simpledms.model.community.LbComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.simpledms.repository.community
 * fileName : LbCommentRepository
 * author : ds
 * date : 2022-10-20
 * description : 분실게시판 댓글 Repository
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */

@Repository
public interface LbCommentRepository extends JpaRepository<LbComment, Integer> {

    // 댓글 조회 쿼리
    @Query(value = "select c.* from tb_lb_comment c" +
    " where c.lno = :lno " +
            "and c.delete_yn = 'N'"
    ,nativeQuery = true)
    List<LbComment> findCommentAll(@Param("lno") int lno);
}









