package com.example.simpledms.repository;

import com.example.simpledms.dto.filedb.FileDto;
import com.example.simpledms.dto.filedb.ResponseFileDto;
import com.example.simpledms.model.FileDb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.jpaexam.repository
 * fileName : FileDbRepository
 * author : ds
 * date : 2022-10-20
 * description : JPA CRUD를 위한 인터페이스(==DAO)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Repository
public interface FileDbRepository extends JpaRepository<FileDb, Integer> {

    // Carousel 조회 쿼리
    @Query(value = "select f.fid, f.file_name as fileName, f.file_type as fileType, f.file_data as fileData " +
            " from tb_file f",
    countQuery = "select count(*) from tb_file f",
    nativeQuery = true)
    Page<FileDb> findCarousel(Pageable pageable);

    // Carousel 랜던 쿼리
    @Query(value = "select * from tb_file order by dbms_random.value",
    nativeQuery = true)
    Page<FileDto> findCarousel2(Pageable pageable);
    @Query(value = "select * from tb_file order by dbms_random.value",
    nativeQuery = true)
    Page<FileDto> findCarousel3(Pageable pageable);

}









