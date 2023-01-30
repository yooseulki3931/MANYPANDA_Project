<template>
    <div class="myPage">
        <div style="margin:auto; text-align:center;">
            <div style="display:inline;">
                <input type="file" accept="image/*" ref="file" @change="selectImage"
                    style="font-size:12px; margin-bottom:50px;" />

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
                    <button class="uploadButton" style=" font-size: 12px;" @click="saveProfile"><svg
                            xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            class="bi bi-upload" viewBox="0 0 16 16">
                            <path
                                d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z" />
                            <path
                                d="M7.646 1.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 2.707V11.5a.5.5 0 0 1-1 0V2.707L5.354 4.854a.5.5 0 1 1-.708-.708l3-3z" />
                        </svg>등록</button>
                </div>
            </div>
        </div>
        <!-- 업로드/취소 버튼 끝 -->
    </div>

</template>
  
<script>
/* eslint-disable */
import ProfileService from '@/services/ProfileService'

export default {
    // name: 'daumMap',
    data() {
        return {
            currentImage: undefined,
            // previewImage: undefined,
            message: "",
            profile: [],
        }
    },
    methods: {

        // 미리보기 이미지
        selectImage() {
            this.currentImage = this.$refs.file.files.item(0);
            // this.previewImage = URL.createObjectURL(this.currentImage);
            this.message = "";
        },
        // 취소
        cancel() {
            location.href = '/profile';
        },
        // 프로필 등록
        saveProfile() {
            ProfileService.upload(
                this.$store.state.auth.user.id,
                this.currentImage
            )
                .then((response) => {
                    this.message = response.data.message;
                    const { profile } = response.data;
                    this.profile = profile;
                    console.log(response.data);
                    alert("프로필 사진이 변경되었습니다");
                    location.href = 'myPage';
                    this.$router.push("/myPage");
                })
                .catch((e) => {
                    console.log(e);
                    this.message = "Could not upload the image!" + e;
                    this.currentImage = undefined;
                })

        }
    },
    mounted() {
    }

}
</script>
<style>
.myPage {
    margin-top: 350px;
}

.tab-pane {
    color: black;
    font-size: 14px;
    height: 800px;
    width: 1100px;
}

.w-btn-gray {
    background-color: #a3a1a1;
    color: #e3dede;

}

.w-btn {
    border: none;
    border-radius: 5px;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    transition: 0.25s;
}

.w-btn-outline {
    border-radius: 5px;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    transition: 0.25s;
}

.bottomButton {
    background-color: #dbdbdb;
    color: #e3dede;
    border: none;
    border-radius: 5px;
}

.cancleButton {
    height: 40px;
    background-color: rgb(255, 255, 255);
    border-radius: 2.5px;
    margin: auto;
    margin-bottom: 50px;
    border: none;
    width: 60px;
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
</style>