package com.example.simpledms.repository.community;

import com.example.simpledms.model.community.MbReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.simpledms.repository.community
 * fileName : MbReplyRepository
 * author : ds
 * date : 2022-10-20
 * description : 모임게시판 대댓글 repository
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */

@Repository
public interface MbReplyRepository extends JpaRepository<MbReply, Integer> {

    // 대댓글 조회 쿼리
    @Query(value = "select r.* from tb_mb_reply r" +
    " where r.mno = :mno " +
            "and r.delete_yn = 'N'"
    ,nativeQuery = true)
    List<MbReply> findReplyAll(@Param("mno") int mno);
}









