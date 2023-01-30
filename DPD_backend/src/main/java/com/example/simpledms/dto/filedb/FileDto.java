package com.example.simpledms.dto.filedb;

import lombok.*;
import org.springframework.data.jpa.repository.Query;

/**
 * packageName : com.example.simpledms.dto.filedb
 * fileName : ResponseFileDto
 * author : ds
 * date : 2022-11-10
 * description : FileDb DTO
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-11-10         ds          최초 생성
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {


    private Integer fid;
    private String fileName;
    private String fileType;
//    가공된 속성
    private byte[] fileData; // 이미지


}







