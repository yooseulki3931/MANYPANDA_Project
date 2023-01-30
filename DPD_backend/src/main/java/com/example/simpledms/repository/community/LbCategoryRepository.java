package com.example.simpledms.repository.community;

import com.example.simpledms.model.community.LbCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * packageName : com.example.simpledms.repository.community
 * fileName : LbCategoryRepository
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
public interface LbCategoryRepository extends JpaRepository<LbCategory, String>  {

    // 카테고리 검색시 페이징 조회
    Page<LbCategory> findAllByLbCtitleContainingOrderByInsertTimeDesc(String lbCtitle, Pageable pageable);

}
