package com.example.simpledms.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * packageName : com.example.jpaexam.model
 * fileName : Dept
 * author : ds
 * date : 2022-10-19
 * description : 부서 모델(== JPA : 엔티티(Entity)) 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-19         ds          최초 생성
 */
@Entity
@Table(name = "TB_PROFILE_IMAGE")
@SequenceGenerator(
        name= "SQ_PROFILE_IMAGE_GENERATOR"
        , sequenceName = "SQ_PROFILE_IMAGE"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql="UPDATE TB_PROFILE_IMAGE SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE PID = ?")
public class ProfileImage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
                   , generator = "SQ_FILE_GENERATOR"
    )
    private Integer pid;

    @Column
    private Long userId;

    @Column
    private String fileName;

    @Column
    private String fileType;


//    @Lob : DB 테이블의 Blob/Clob 자료형에 해당하는 컬럼일 경우 @ 사용함
//          자료형은 byte[] 사용.
    @Lob
    @Column
    private byte[] fileData; // 이미지



//    id 제외 생성자


    public ProfileImage(Integer pid, Long userId, String fileName, String fileType, byte[] fileData) {
        this.pid = pid;
        this.userId = userId;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
    }

    public ProfileImage(Long userId, String fileName, String fileType, byte[] fileData) {
        this.userId = userId;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
    }

    public ProfileImage(String fileName, String fileType, byte[] fileData) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
    }
}










