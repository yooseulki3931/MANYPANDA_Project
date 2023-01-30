package com.example.simpledms.repository.community;

import com.example.simpledms.model.community.FbComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.simpledms.repository.community
 * fileName : FbCommentRepository
 * author : ds
 * date : 2022-10-20
 * description : 자유게시판 댓글 Repository
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */

@Repository
public interface FbCommentRepository extends JpaRepository<FbComment, Integer> {

    // 댓글 조회 쿼리
    @Query(value = "select c.* from tb_fb_comment c" +
    " where c.fno = :fno " +
            "and c.delete_yn = 'N'"
    ,nativeQuery = true)
    List<FbComment> findCommentAll(@Param("fno") int fno);
}









