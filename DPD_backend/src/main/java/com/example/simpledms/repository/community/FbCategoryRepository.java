package com.example.simpledms.repository.community;

import com.example.simpledms.model.community.FbCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * packageName : com.example.simpledms.repository.community
 * fileName : FbCategoryRepository
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
public interface FbCategoryRepository extends JpaRepository<FbCategory, String>  {

    // 카테고리 검색시 페이징 조회
    Page<FbCategory> findAllByFbCtitleContainingOrderByInsertTimeDesc(String fbCtitle, Pageable pageable);

}
