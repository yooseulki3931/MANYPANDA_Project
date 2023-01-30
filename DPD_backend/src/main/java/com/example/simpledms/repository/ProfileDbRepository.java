package com.example.simpledms.repository;

import com.example.simpledms.dto.filedb.ResponseFileDto;
import com.example.simpledms.model.FileDb;
import com.example.simpledms.model.ProfileImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
public interface ProfileDbRepository extends JpaRepository<ProfileImage, Integer> {

    Optional<ProfileImage> findByUserId(Long userId);

}









