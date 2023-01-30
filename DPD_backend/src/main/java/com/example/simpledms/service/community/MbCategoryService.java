package com.example.simpledms.service.community;

import com.example.simpledms.model.community.MbCategory;
import com.example.simpledms.repository.community.MbCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * packageName : com.example.simpledms.service.community
 * fileName : MbCategoryService
 * author : ds
 * date : 2022-12-19
 * description : 모임게시판 카테고리 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Service
public class MbCategoryService {

    @Autowired
    MbCategoryRepository mbCategoryRepository;

    // 등록시 실행될 메소드
    public boolean createMbCategory(MbCategory mbCategory) {

        // id 중복 체크
        if( mbCategory.getMbCid() != null) {
            boolean bResult = mbCategoryRepository.existsById(mbCategory.getMbCid());

//            id 중복 체크
            if(bResult) return false;

        }

//        생성 날짜 지정을 위한 날짜 라이브러리 가져오기
        LocalDateTime localDateTime = LocalDateTime.now();
//            시간 형태 지정 : 예) 2022-07-28 15:02:45
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH24:MI:SS");

//        생성 날짜 지정
        mbCategory.setInsertTime(localDateTime.format(formatter));

        mbCategoryRepository.save(mbCategory);

        return true;
    }

    // 전체 조회시 최신순 페이징으로 실행될 메소드
    public Page<MbCategory> findAllMbCtitleDesc(String mbCtitle, Pageable pageable) {

        Page<MbCategory> mbCategoryPage = mbCategoryRepository.findAllByMbCtitleContainingOrderByInsertTimeDesc(mbCtitle, pageable);
        return mbCategoryPage;
    }

    // 전체 조회시 실행될 메소드
    public List<MbCategory> findAll() {

        List<MbCategory> mbCategoryList = mbCategoryRepository.findAll();
        return mbCategoryList;
    }

    // 삭제시 실행될 메소드
    public boolean removeById(String mbCid) {

        if (mbCategoryRepository.existsById(mbCid)) {
            mbCategoryRepository.deleteById(mbCid);
            return true;
        }
        return false;
    }
}
