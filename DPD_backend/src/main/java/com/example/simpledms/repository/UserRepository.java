package com.example.simpledms.repository;

import com.example.simpledms.dto.mypage.*;
import com.example.simpledms.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByNick(String nick);

//  oauth2 에서 사용할 함수
//  소셜 로그인으로 반환되는 값 중 email을 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지 판단하기 위한 함수
    Optional<User> findByEmail(String email);

    Page<User> findAllByUsernameContaining(String username, Pageable pageable);

    @Query(value = "SELECT u.ID as id, u.nick as nick, g.GOODS_ID as goodsId, " +
            "g.SELLER_ID as sellerId, g.STATUS, g.CATEGORY as category, g.TITLE, " +
            "case when substr(g.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(g.insert_time, 6,5)) " +
            "else (substr(g.insert_time, 11, 9)) " +
            "end as insertTime " +
            "FROM TB_USER u, TB_GOODS g " +
            "WHERE :nick = g.SELLER_ID " +
            "AND :nick = u.nick " +
            " and g.delete_yn = 'N' " +
            " AND ROWNUM <= 8 ",
            nativeQuery = true)
    List<SoldDto> findGoodByUsername(@Param("nick") String nick);

    // 마이페이지 - 글쓴내역 조회 쿼리
    // @Query, 자유게시판 글쓴내역 조회 함수
    @Query(value = "SELECT f.NICK, f.FNO as fno, f.FB_CATEGORY as fbCategory, f.FB_TITLE as fbTitle, " +
            "case when substr(f.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(insert_time, 6,5)) " +
            "else (substr(f.insert_time, 11, 9)) " +
            "end as insertTime " +
            "FROM TB_FB f " +
            "WHERE :nick = f.NICK " +
            " and f.delete_yn = 'N' " +
            " AND ROWNUM <= 8 ",
            nativeQuery = true)
    List<WroteDto> findFbByNick(@Param("nick") String nick);

    // @Query, 모임게시판 글쓴내역 조회 함수
    @Query(value = "SELECT m.NICK, m.MNO, m.MB_CATEGORY as mbCategory, m.MB_TITLE as mbTitle, " +
            "case when substr(m.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(m.insert_time, 6,5)) " +
            "else (substr(m.insert_time, 11, 9)) " +
            "end as insertTime " +
            "FROM  TB_MB m " +
            "WHERE :nick = m.NICK " +
            " and m.delete_yn = 'N' " +
            " AND ROWNUM <= 8 ",
            nativeQuery = true)
    List<WroteMbDto> findMbByNick(@Param("nick") String nick);

    // @Query, 추천게시판 글쓴내역 조회 함수
    @Query(value = "SELECT b.NICK, b.BNO, b.BB_CATEGORY as bbCategory, b.BB_TITLE as bbTitle, " +
            "case when substr(b.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(b.insert_time, 6,5)) " +
            "else (substr(b.insert_time, 11, 9)) " +
            "end as insertTime " +
            "FROM TB_BB b " +
            "WHERE :nick = b.NICK " +
            " and b.delete_yn = 'N' " +
            " AND ROWNUM <= 8 ",
            nativeQuery = true)
    List<WroteBbDto> findBbByNick(@Param("nick") String nick);

    // @Query, 분실게시판 글쓴내역 조회 함수
    @Query(value = "SELECT l.NICK, l.LNO, l.LB_CATEGORY as lbCategory, l.LB_TITLE as lbTitle, " +
            "case when substr(l.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(l.insert_time, 6,5)) " +
            "else (substr(l.insert_time, 11, 9)) " +
            "end as insertTime " +
            "FROM TB_LB l " +
            "WHERE :nick = l.NICK " +
            " and l.delete_yn = 'N' " +
            " AND ROWNUM <= 8 ",
            nativeQuery = true)
    List<WroteLbDto> findLbByNick(@Param("nick") String nick);

    // @Query,찜목록 쿼리
    @Query(value = "SELECT g.SELLER_ID as sellerId, g.title, g.status, g.category, g.GOODS_ID as goodsId, " +
            "case when substr(g.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(g.insert_time, 6,5)) " +
            "else (substr(g.insert_time, 11, 9)) " +
            "end as insertTime " +
            "FROM TB_GOODS g " +
            "WHERE g.GOODS_ID IN (SELECT c.GOODS_ID " +
            "FROM TB_GOOD_CART c " +
            "WHERE c.USER_ID = :id) " +
            " and g.delete_yn = 'N' ",
            nativeQuery = true)
    List<WishListDto> findGoodsCartById(@Param("id") Long id);

    // @Query, 좋아요 목록 쿼리 자유
    @Query(value = "select f.FB_TITLE as fbTitle, f.nick, f.fno " +
            "from tb_fb f " +
            "where f.fno in " +
            "(select g.fno " +
            "from tb_fb_like g " +
            "where g.user_id = :id)" +
            "and f.delete_yn = 'N' ",
            nativeQuery = true)
    List<GoodListFbDto> findGoodsFbById(@Param("id") Long id);

    // @Query, 좋아요 목록 쿼리 모임
    @Query(value = "select m.MB_TITLE as mbTitle, m.nick, m.mno " +
            "from tb_mb m " +
            "where m.mno in " +
            "(select g.mno " +
            "from tb_mb_like g " +
            "where g.user_id = :id) " +
            "and m.delete_yn = 'N' ",
            nativeQuery = true)
    List<GoodListMbDto> findGoodsMbById(@Param("id") Long id);

    // @Query, 좋아요 목록 쿼리 추천
    @Query(value = "select b.BB_TITLE as bbTitle, b.nick, b.bno " +
            "from tb_bb b " +
            "where b.bno in " +
            "(select g.bno " +
            "from tb_bb_like g " +
            "where g.user_id = :id) " +
            "and b.delete_yn = 'N' ",
            nativeQuery = true)
    List<GoodListBbDto> findGoodsBbById(@Param("id") Long id);

    // @Query, 좋아요 목록 쿼리 분실
    @Query(value = "select l.LB_TITLE as lbTitle, l.nick, l.lno " +
            "from tb_lb l " +
            "where l.lno in " +
            "(select g.lno " +
            "from tb_lb_like g " +
            "where g.user_id = :id) " +
            "and l.delete_yn = 'N' ",
            nativeQuery = true)
    List<GoodListLbDto> findGoodsLbById(@Param("id") Long id);
}


