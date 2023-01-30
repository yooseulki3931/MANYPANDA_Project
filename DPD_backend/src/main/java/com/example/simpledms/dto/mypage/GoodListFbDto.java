package com.example.simpledms.dto.mypage;

/**
 * packageName : com.example.simpledms.dto.response
 * fileName : SoldDto
 * author : ds
 * date : 2022-11-30
 * description : 마이페이지 - 좋아요 리스트 dto
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-11-30         ds          최초 생성
 */

public interface GoodListFbDto {
//    user.userNum == goods.sellerId

    //    User 클래스 getter
    Integer getId();    //유저 NO
    String getUsername();    //유저 nick


    //    fb 클래스 getter
    Integer getFno();   //상품 NO
    String getNick();   //판매자 NO
    String getCategory(); //카테고리번호
    String getFbTitle(); //제목
    String getInsertTime();  //생성날짜
    String getDeleteYn();

}