package com.example.simpledms.controller;

import com.example.simpledms.dto.mypage.*;
import com.example.simpledms.dto.request.SignupRequest;
import com.example.simpledms.dto.response.MessageResponse;
import com.example.simpledms.model.ERole;
import com.example.simpledms.model.Role;
import com.example.simpledms.model.User;
import com.example.simpledms.security.jwt.JwtUtils;
import com.example.simpledms.service.RoleService;
import com.example.simpledms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * packageName : com.example.simpledms.controller
 * fileName : UserController
 * author : ds
 * date : 2022-12-16
 * description : 유저 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-16         정도훈          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    // 판매내역 조회하는 함수
    @GetMapping("/user/sold/{nick}")
    public ResponseEntity<Object> findGoodByUsername(@PathVariable String nick) {

        try {
            List<SoldDto> list = userService.findGoodByUsername(nick);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // id로 유저 조회하는 함수
    @GetMapping("/user/{id}")
    public ResponseEntity<Object> findGoodsByGoodsId(@PathVariable Long id) {

        try {
            Optional<User> optionalUser = userService.findById(id);

            if (optionalUser.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // id로 유저 수정하는 함수
    @PutMapping("/user/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> updateUser(@PathVariable long id, @RequestBody SignupRequest signUpRequest) {

//        패스워드 변수
        String password = "";

        log.debug("signUpRequest {}", signUpRequest);
        // Create new user's account
        if (signUpRequest.isChangePwd()) {
            password = encoder.encode(signUpRequest.getPassword());
        } else {
            password = signUpRequest.getPassword();
        }
        User user = new User(id,
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                password,
                signUpRequest.getAddress(),
                signUpRequest.getNick());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleService.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "ROLE_ADMIN":
                        Role adminRole = roleService.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    default:
                        Role userRole = roleService.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userService.save(user);

        return ResponseEntity.ok(new MessageResponse("User update successfully!"));
    }

    //    글쓴내역 조회하는 함수
    //    닉네임으로(Nick) 로 자유게시판 글쓴내역 조회하는 함수
    @GetMapping("/user/wrote/{nick}")
    public ResponseEntity<Object> findFbByNick(@PathVariable String nick) {

        try {
            List<WroteDto> list = userService.findFbByNick(nick);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    닉네임으로(Nick) 로 모임게시판 글쓴내역 조회하는 함수
    @GetMapping("/user/wrote/mb/{nick}")
    public ResponseEntity<Object> findMbByNick(@PathVariable String nick) {

        try {
            List<WroteMbDto> list = userService.findMbByNick(nick);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    닉네임으로(Nick) 로 추천게시판 글쓴내역 조회하는 함수
    @GetMapping("/user/wrote/bb/{nick}")
    public ResponseEntity<Object> findBbByNick(@PathVariable String nick) {

        try {
            List<WroteBbDto> list = userService.findBbByNick(nick);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    닉네임으로(Nick) 로 분실게시판 글쓴내역 조회하는 함수
    @GetMapping("/user/wrote/lb/{nick}")
    public ResponseEntity<Object> findLbByNick(@PathVariable String nick) {

        try {
            List<WroteLbDto> list = userService.findLbByNick(nick);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //    찜목록
    @GetMapping("/user/wishlist/{id}")
    public ResponseEntity<Object> findGoodsCartById(@PathVariable Long id) {

        try {
            List<WishListDto> list = userService.findGoodsCartById(id);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //    좋아요 자유게시판
    @GetMapping("/user/goodfb/{id}")
    public ResponseEntity<Object> findGoodsFbById(@PathVariable Long id) {

        try {
            List<GoodListFbDto> list = userService.findGoodsFbById(id);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    좋아요 모임게시판
    @GetMapping("/user/goodmb/{id}")
    public ResponseEntity<Object> findGoodsMbById(@PathVariable Long id) {

        try {
            List<GoodListMbDto> list = userService.findGoodsMbById(id);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    좋아요 추천게시판
    @GetMapping("/user/goodbb/{id}")
    public ResponseEntity<Object> findGoodsBbById(@PathVariable Long id) {

        try {
            List<GoodListBbDto> list = userService.findGoodsBbById(id);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    좋아요 분실게시판
    @GetMapping("/user/goodlb/{id}")
    public ResponseEntity<Object> findGoodsLbById(@PathVariable Long id) {

        try {
            List<GoodListLbDto> list = userService.findGoodsLbById(id);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // id로 삭제 함수
    @DeleteMapping("/user/deletion/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {

        try {
            boolean bSuccess = userService.removeById(id);

            if (bSuccess == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 사용중인 email 조회로 확인하는 함수
    @GetMapping("/user/exists/{email}")
    public ResponseEntity<Boolean> checkEmailDuplicate(@PathVariable String email) {
        //        프론트엔드 쪽으로 상태정보를 보내줌
        try {
            return ResponseEntity.ok(userService.checkEmailDuplicate(email));
        } catch (Exception e) {
//            DB 에러가 날경우
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 사용중인 username 조회로 확인하는 함수
    @GetMapping("/user/exists2/{username}")
    public ResponseEntity<Boolean> checkUsernameDuplicate(@PathVariable String username) {
        return ResponseEntity.ok(userService.checkUsernameDuplicate(username));
    }

    // 사용중인 nick 조회로 확인하는 함수
    @GetMapping("/user/exists3/{nick}")
    public ResponseEntity<Boolean> checkNickDuplicate(@PathVariable String nick) {
        return ResponseEntity.ok(userService.checkNickDuplicate(nick));
    }

}
