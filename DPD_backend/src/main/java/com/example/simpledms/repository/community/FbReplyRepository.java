package com.example.simpledms.repository.community;

import com.example.simpledms.model.community.FbReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.simpledms.repository.community
 * fileName : FbReplyRepository
 * author : ds
 * date : 2022-10-20
 * description : 자유게시판 대댓글 repository
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */

@Repository
public interface FbReplyRepository extends JpaRepository<FbReply, Integer> {

    // 대댓글 조회 쿼리
    @Query(value = "select r.* from tb_fb_reply r" +
    " where r.fno = :fno " +
            "and r.delete_yn = 'N'"
    ,nativeQuery = true)
    List<FbReply> findReplyAll(@Param("fno") int fno);
}









