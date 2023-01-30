import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  // 첫페이지 == 전체 목록 페이지
  {
    path: "/",
    alias: "/home",
    name: "home",
    component: () => import("../views/HomeView.vue"),
  },
  // TODO : 상품 관련 페이지
  {
    path: "/dapanda",
    name: "dapanda",
    component: () => import("../components/dapanda/DapandaCom.vue"),
  },
  {
    path: "/dapanda-board-write",
    name: "dapanda-board-wirte",
    component: () => import("../components/dapanda/DapandaBoardWrite.vue"),
  },
  {
    path: "/update/:goodsId",
    name: "dapanda-update",
    component: () => import("../components/dapanda/DapandaUpdate.vue"),
  },
  {
    path: "/dapanda/detail/:goodsId",
    name: "dapanda-detail",
    component: () => import("../components/dapanda/DapandaDetail.vue"),
  },
  {
    path: "/login",
    name: "login",
    component: () => import("../components/login/LoginCom.vue"),
  },
  {
    path: "/joinUs",
    name: "joinUs",
    component: () => import("../components/join/JoinUsCom.vue"),
  },
  // 다이어리
  // 다이어리 목록
  {
    path: "/diary",
    name: "diary",
    component: () => import("../components/diary/DiaryList.vue"),
  },
  // 다이어리 추가 페이지
  {
    path: "/add/diary",
    name: "add-diary",
    component: () => import("../components/diary/AddDiary.vue"),
  },
  {
    path: "/myPage",
    name: "myPage",
    component: () => import("../components/myPage/MyPage.vue"),
  },
  {
    path: "/memberEdit",
    name: "memberEdit",
    component: () => import("../components/myPage/memberEdit.vue"),
  },
  {
    path: "/logOut",
    name: "logOut",
    component: () => import("../components/logOut/LogOut.vue"),
  },
  {
    path: '/auth-redirect',
    name: 'auth-redirect',
    // lazy-loaded
    component: () => import('../views/Auth2View.vue')
  },
 

 // TODO : 커뮤니티 페이지
 {
  path: "/community",
  name: "community",
  component: () => import("../components/community/CommunityCom.vue"),
},
// 자유게시판 목록 페이지
{
  path: "/community-free-Board",
  name: "community-free-Board",
  component: () =>
    import("../components/community/freeBoard/CommunityFreeBoard.vue"),
},
// 자유게시판 글쓰기 페이지
{
  path: "/free-Board-Write",
  name: "free-Board-Write",
  component: () =>
    import("../components/community/freeBoard/FreeBoardWrite.vue"),
},
// 자유게시판 상세 페이지
{
  path: "/fb/:fno",
  name: "community-free-detail",
  component: () =>
    import("../components/community/freeBoard/CommunityFreeDetail.vue"),
},
// 자유게시판 수정 페이지
{
  path: "/free-Board-Edit/:fno",
  name: "free-Board-Edit",
  component: () =>
    import("../components/community/freeBoard/FreeBoardEdit.vue"),
},

// 추천게시판 목록 페이지
{
  path: "/community-best-Board",
  name: "community-best-Board",
  component: () =>
    import("../components/community/bestBoard/CommunityBestBoard.vue"),
},
// 추천게시판 글쓰기 페이지
{
  path: "/best-Board-Write",
  name: "best-Board-Write",
  component: () =>
    import("../components/community/bestBoard/BestBoardWrite.vue"),
},
// 추천게시판 상세 페이지
{
  path: "/bb/:bno",
  name: "community-best-detail",
  component: () =>
    import("../components/community/bestBoard/CommunityBestDetail.vue"),
},
// 추천게시판 수정 페이지
{
  path: "/best-Board-Edit/:bno",
  name: "best-Board-Edit",
  component: () =>
    import("../components/community/bestBoard/BestBoardEdit.vue"),
},

// 모임게시판 목록 페이지
{
  path: "/community-moim-Board",
  name: "community-moim-Board",
  component: () =>
    import("../components/community/moimBoard/CommunityMoimBoard.vue"),
},
// 모임게시판 글쓰기 페이지
{
  path: "/moim-Board-Write",
  name: "moim-Board-Write",
  component: () =>
    import("../components/community/moimBoard/MoimBoardWrite.vue"),
},
// 모임게시판 상세 페이지
{
  path: "/mb/:mno",
  name: "community-moim-detail",
  component: () =>
    import("../components/community/moimBoard/CommunityMoimDetail.vue"),
},
// 모임게시판 수정 페이지
{
  path: "/moim-Board-Edit/:mno",
  name: "moim-Board-Edit",
  component: () =>
    import("../components/community/moimBoard/MoimBoardEdit.vue"),
},

// 분실게시판 목록 페이지
{
  path: "/community-lost-Board",
  name: "community-lost-Board",
  component: () =>
    import("../components/community/lostBoard/CommunityLostBoard.vue"),
},
// 분실게시판 글쓰기 페이지
{
  path: "/lost-Board-Write",
  name: "lost-Board-Write",
  component: () =>
    import("../components/community/lostBoard/LostBoardWrite.vue"),
},
 // 분실게시판 상세 페이지
{
  path: "/lb/:lno",
  name: "community-lost-detail",
  component: () =>
    import("../components/community/lostBoard/CommunityLostDetail.vue"),
},
 // 분실게시판 수정 페이지
 {
  path: "/lost-Board-Edit/:lno",
  name: "lost-Board-Edit",
  component: () =>
    import("../components/community/lostBoard/LostBoardEdit.vue"),
},
// 프로필 사진 수정
 {
  path: "/photoEdit",
  name: "photoEdit",
  component: () =>
    import("../components/myPage/PhotoEdit.vue"),
},
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
