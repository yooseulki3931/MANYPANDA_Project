<template>
    <div>
        <div class="freeBoardWrite">
            <section class="secondSection ">
                <div class="container " data-aos="fade-left" data-aos-delay="200">
                    <div class="row">

                        <!-- 글쓰기 게시판 시작 -->
                        <div class="writeTable" style="margin-bottom:100px; margin-left: 150px;  text-align: left">
                            <table class="tableWrite">
                                <thead>
                                    <!-- 사진등록 대표사진 1개 -->
                                    <tr data-v-224097a6="" style="font-size: 14px;">
                                        <th scope="col" data-v-224097a6=""
                                            style="text-align: right; width: 20%; margin: 10px; ">
                                            상품 사진 등록
                                        </th>
                                        <td>
                                            <input type="file" accept="image/*" ref="file" @change="selectImage"
                                                style="font-size:12px; margin-left:10px" />
                                        </td>
                                    </tr>

                                    <!-- 카테고리 선택 -->
                                    <tr style="font-size: 14px;  ">
                                        <th scope="col" style="text-align: right; width: 200px; margin: 10px;  ">
                                            Category
                                        </th>
                                        <td>
                                            <select class="search" name="count" data-title="선택"
                                                style="width: 80%; font-size: 12px; margin: 10px; background-color: white; height: 25px; border-radius: 5px; border-color: gray;"
                                                required v-model="goods.category">
                                                <option value="디지털기기">디지털기기</option>
                                                <option value="의류">의류</option>
                                                <option value="뷰티/미용">뷰티/미용</option>
                                                <option value="인테리어">인테리어</option>
                                                <option value="생활가전">생활가전</option>
                                                <option value="기타">기타</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <!-- 지역 선택 -->
                                    <tr style="font-size: 14px;  ">
                                        <th scope="col" style="text-align: right; width: 200px; margin: 10px;  ">
                                            지역
                                        </th>
                                        <td>
                                            <select class="search" name="count" data-title="선택"
                                                style="width: 80%; font-size: 12px; margin: 10px; background-color: white; height: 25px; border-radius: 5px; border-color: gray;"
                                                v-model="goods.sellingAreaId">

                                                <option value="중구">중구</option>
                                                <option value="서구">서구</option>
                                                <option value="동구">동구</option>
                                                <option value="영도구">영도구</option>
                                                <option value="부산진구">부산진구</option>
                                                <option value="동래구">동래구</option>
                                                <option value="남구">남구</option>
                                                <option value="북구">북구</option>
                                                <option value="해운대구">해운대구</option>
                                                <option value="사하구">사하구</option>
                                                <option value="금정구">금정구</option>
                                                <option value="강서구">강서구</option>
                                                <option value="연제구">연제구</option>
                                                <option value="수영구">수영구</option>
                                                <option value="사상구">사상구</option>
                                                <option value="기장군">기장군</option>
                                            </select>
                                        </td>
                                    </tr>

                                    <!-- 상품명 입력 -->
                                    <tr data-v-224097a6="" style="font-size: 14px;">
                                        <th scope="col" data-v-224097a6=""
                                            style="text-align: right; width: 20%; margin: 10px; ">
                                            상품
                                        </th>
                                        <td>
                                            <input type="text" placeholder="상품명을 입력하세요" class="category"
                                                style=" font-size: 12px; width: 80%; margin: 10px; " required
                                                v-model="goods.title">
                                        </td>
                                    </tr>

                                    <!-- 중고판매가격 입력 -->
                                    <tr data-v-224097a6="" style="font-size: 14px;">
                                        <th scope="col" data-v-224097a6=""
                                            style="text-align: right; width: 20%; margin: 10px; ">
                                            가격
                                        </th>
                                        <td>
                                            <input type="number" placeholder="가격을 입력하세요" class="category"
                                                style=" font-size: 12px; width: 80%; margin: 10px; " required
                                                v-model="goods.sellPrice">
                                        </td>
                                    </tr>

                                    <!-- 원가입력(필수아님) -->
                                    <tr data-v-224097a6="" style="font-size: 14px;">
                                        <th scope="col" data-v-224097a6=""
                                            style="text-align: right; width: 20%; margin: 10px; ">
                                            원가
                                        </th>
                                        <td>
                                            <input type="text" placeholder="원가를 입력하세요 (필수입력아님)" class="category"
                                                style=" font-size: 12px; width: 80%; margin: 10px; "
                                                v-model="goods.originPrice">
                                        </td>
                                    </tr>

                                    <!-- 해쉬태그 설정 -->
                                    <tr data-v-224097a6="" style="font-size: 14px;">
                                        <th scope="col" data-v-224097a6=""
                                            style="text-align: right; width: 20%; margin: 10px; ">
                                            태그
                                        </th>
                                        <td>
                                            <input type="text" placeholder="#해쉬태그는 5개" class="category"
                                                style=" font-size: 12px; width: 80%; margin: 10px; "
                                                v-model="goods.tag">
                                        </td>
                                    </tr>

                                    <!-- 주소 설정 (카카오 api) -->
                                    <!-- <tr style="font-size: 14px;">
                                        <th scope="col" data-v-224097a6=""
                                            style="text-align: right; width: 20%; margin: 10px; ">
                                            지역
                                            <div class="daummap">
                                                <p style="font-size: 12px;">우편번호: <span>{{ zip }}</span></p>
                                                <p style="font-size: 12px;">기본주소: <span>{{ addr1 }}</span></p>
                                                <p style="font-size: 12px;">상세주소: <span>{{ addr2 }}</span></p>
                                                <div ref="embed"></div>
                                                <button @click="showApi" class="clickButton"
                                                    style=" font-size: 12px;">주소찾기클릭<svg
                                                        xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                        fill="currentColor" class="bi bi-hand-index"
                                                        viewBox="0 0 16 16">
                                                        <path
                                                            d="M6.75 1a.75.75 0 0 1 .75.75V8a.5.5 0 0 0 1 0V5.467l.086-.004c.317-.012.637-.008.816.027.134.027.294.096.448.182.077.042.15.147.15.314V8a.5.5 0 1 0 1 0V6.435a4.9 4.9 0 0 1 .106-.01c.316-.024.584-.01.708.04.118.046.3.207.486.43.081.096.15.19.2.259V8.5a.5.5 0 0 0 1 0v-1h.342a1 1 0 0 1 .995 1.1l-.271 2.715a2.5 2.5 0 0 1-.317.991l-1.395 2.442a.5.5 0 0 1-.434.252H6.035a.5.5 0 0 1-.416-.223l-1.433-2.15a1.5 1.5 0 0 1-.243-.666l-.345-3.105a.5.5 0 0 1 .399-.546L5 8.11V9a.5.5 0 0 0 1 0V1.75A.75.75 0 0 1 6.75 1zM8.5 4.466V1.75a1.75 1.75 0 1 0-3.5 0v5.34l-1.2.24a1.5 1.5 0 0 0-1.196 1.636l.345 3.106a2.5 2.5 0 0 0 .405 1.11l1.433 2.15A1.5 1.5 0 0 0 6.035 16h6.385a1.5 1.5 0 0 0 1.302-.756l1.395-2.441a3.5 3.5 0 0 0 .444-1.389l.271-2.715a2 2 0 0 0-1.99-2.199h-.581a5.114 5.114 0 0 0-.195-.248c-.191-.229-.51-.568-.88-.716-.364-.146-.846-.132-1.158-.108l-.132.012a1.26 1.26 0 0 0-.56-.642 2.632 2.632 0 0 0-.738-.288c-.31-.062-.739-.058-1.05-.046l-.048.002zm2.094 2.025z" />
                                                    </svg></button>
                                            </div>
                                        </th>
                                    </tr> -->

                                    <!-- 상세내용입력 -->
                                    <tr data-v-224097a6="" style="font-size: 14px;">
                                        <th scope="col" data-v-224097a6=""
                                            style="text-align: right; width: 20%; margin: 10px; ">
                                            상품 상세 설명
                                        </th>
                                        <td style="width: 80%;">
                                            <input type="text" placeholder="내용을 입력하세요" class="category"
                                                style="font-size: 12px; height: 400px; width: 80%; margin: 10px;  "
                                                required v-model="goods.description">
                                        </td>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <!-- 글쓰기 게시판 끝 -->

                        <!-- 업로드/취소 버튼 시작 -->
                        <div class="button">
                            <button @click="cancel" class="cancleButton" style=" font-size: 12px;"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                    class="bi bi-x-square" viewBox="0 0 16 16">
                                    <path
                                        d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z" />
                                    <path
                                        d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
                                </svg>취소</button>
                            <button class="uploadButton" style=" font-size: 12px;" @click="saveGoods"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                    class="bi bi-upload" viewBox="0 0 16 16">
                                    <path
                                        d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z" />
                                    <path
                                        d="M7.646 1.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 2.707V11.5a.5.5 0 0 1-1 0V2.707L5.354 4.854a.5.5 0 1 1-.708-.708l3-3z" />
                                </svg>등록</button>
                        </div>
                        <!-- 업로드/취소 버튼 끝 -->

                    </div>
                </div>
            </section>

        </div>
    </div>

</template>
  
<script>
/* eslint-disable */
// import slideInit from "../../assets/script/dapandaSlide/carousel"
import GoodsDataService from "@/services/GoodsDataService";
import FileDbDataService from "@/services/FileDbDataService";

export default {
    // name: 'daumMap',
    data() {
        return {
            currentImage: undefined,
            // previewImage: undefined,
            message: "",
            fileDb: [],
            goods: {
                goodsId: null,
                title: "",
                sellPrice: '',
                category: '',
                originPrice: '',
                tag: '',
                description: '',
                sellerId: '',
                sellingAreaId: ''
            },

            // addr1: '',
            // addr2: '',

        }
    },
    methods: {

        // 상품등록
        saveGoods() {
            if (!this.goods.title) {
                alert("상품명을 적어주세요")
            } else if (!this.goods.sellPrice) {
                alert("가격을 입력하세요")
            } else if (!this.goods.category) {
                alert("카테고리를 선택하세요")
            } else if (!this.goods.description) {
                alert("상품 설명을 적어주세요")
            } else if (!this.goods.sellingAreaId) {
                alert("지역을 선택해주세요")
            } else if (!this.currentImage) {
                alert("상품 사진은 필수 항목입니다")
            } else {
                let data = {
                    title: this.goods.title,
                    sellPrice: this.goods.sellPrice,
                    category: this.goods.category,
                    originPrice: this.goods.originPrice,
                    tag: this.goods.tag,
                    description: this.goods.description,
                    sellerId: this.$store.state.auth.user.nick,
                    sellingAreaId: this.goods.sellingAreaId
                };

                // insert 요청 함수 호출(axios 공통함수 호출)
                GoodsDataService.create(data)
                    // 성공하면 then() 결과가 전송됨
                    .then(response => {
                        this.goods.goodsId = response.data.goodsId;
                        // 콘솔 로그 출력(response.data)
                        console.log(response.data);
                        location.href = '/dapanda'
                    })
                    // 실패하면 .catch() 결과가 전송됨
                    .catch(e => {
                        console.log(e);
                    })

                FileDbDataService.upload(
                    this.currentImage
                )
                    .then((response) => {
                        this.message = response.data.message;
                    })
                    .then((response2) => {
                        const { fileDb } = response2.data;
                        this.fileDb = fileDb;
                        console.log(response2.data);
                    })
                    .catch((e) => {
                        console.log(e);
                        this.message = "Could not upload the image!" + e;
                        this.currentImage = undefined;
                    })

            }
        },
        
        // 미리보기 이미지
        selectImage() {
            this.currentImage = this.$refs.file.files.item(0);
            // this.previewImage = URL.createObjectURL(this.currentImage);
            this.message = "";
        },

        // 취소
        cancel() {
            location.href = '/dapanda';
        },

        // 글쓰기 
        check() {
            if (!this.$store.state.auth.user) {
                alert("작성권한이 없습니다");
                location.href = '/dapanda';
            }
        }
    },
    mounted() {
        this.check();
    }

}
</script>
  
<style>
.freeBoardWrite {
    margin-top: 350px;
}

.table {
    justify-content: center;
    margin-bottom: 50px;

}

.searchDapanda {
    height: 30px;
    /* background-color: rgb(101, 190, 145); */
    border-radius: 2.5px;
    border: none;
}

.cancleButton {
    height: 40px;
    background-color: rgb(255, 255, 255);
    border-radius: 2.5px;
    margin: auto;
    margin-bottom: 50px;
    border: none;
    width: 60px;
    margin-left: 600px;
    ;
}


.uploadButton {
    height: 40px;
    background-color: rgb(255, 255, 255);
    border-radius: 2.5px;
    margin-left: 10px;
    border: none;
    width: 60px;
}

.writeButton {
    margin-bottom: 50px;
}

.category {
    border-radius: 5px;
}

.clickButton {
    height: 40px;
    background-color: rgb(255, 255, 255);
    border-radius: 2.5px;
    border: none;
    width: 100px;
}

.carousel-inner {
    margin: 0 auto;
    overflow: hidden;
    padding-top: 10px;
    background-color: rgb(133, 133, 133);
    width: 1200px;
    height: 300px;
    margin-bottom: 100px;
}

article {
    float: left;
    margin-left: 20px;
    width: 360px;
}
</style>