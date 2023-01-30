package com.example.simpledms.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * packageName : com.example.simpledms.model
 * fileName : Category
 * author : ds
 * date : 2022-12-22
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-22         ds          최초 생성
 */
@Entity
@Table(name = "TB_AREAS")
@SequenceGenerator(
        name = "SQ_AREAS_GENERATOR"
        , sequenceName = "SQ_AREAS"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql="UPDATE TB_AREAS SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE AREA_ID = ?")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_AREAS_GENERATOR"
    )
    @Column(columnDefinition = "NUMBER", name = "AREA_ID")
    private Integer areaId;

    @Column(columnDefinition = "VARCHAR2(1000)")
    private String areaName;

}
