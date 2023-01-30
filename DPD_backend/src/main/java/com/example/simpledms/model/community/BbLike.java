package com.example.simpledms.model.community;

import com.example.simpledms.model.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * packageName : com.example.simpledms.model
 * fileName : FbLike
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Entity
@Table(name = "TB_BB_LIKE")
@SequenceGenerator(
        name= "SQ_BB_LIKE_GENERATOR"
        , sequenceName = "SQ_BB_LIKE"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class BbLike {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_BB_LIKE_GENERATOR"
    )
    @Column(columnDefinition = "NUMBER")
    private Long bbLikeId;

    private int bno;

    private Long userId;
}
