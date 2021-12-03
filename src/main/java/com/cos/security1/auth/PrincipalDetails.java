package com.cos.security1.auth;

// 시큐리티가 /login 주소 요청이오면 낚아채서 로그인을 진행시킨다.
// 로그인을 진해잉 완료가되면 session을 만들어줍니다. (Security ContextHolder)
// 오브젝트 => Authentication 타입 객체
// Authentication 안에 User 정보가 있어야 됨.
//User 오브젝트 타입 => UserDetails 타입 객체

import com.cos.security1.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

//시큐리티가 가지고 있는 세션영역
//Security Session => Authentication => UserDetails(PrincipalDetails)
public class PrincipalDetails implements UserDetails {

    private User user;// 컴포지션

    public PrincipalDetails(User user) {
        this.user = user;
    }

    //해당 User의 권한을 리턴하는곳!!
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override//계정 만료됐니?
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override//계정 잠겼니?
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override//비밀번호가 오래사용되었는가?
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override//계정이 활성화되어있는가?
    public boolean isEnabled() {
        //우리사이트!! 1년동안 회원이 로그인 안하면 !! 휴먼 계정하기로함
        //현재시간 - 마지막 로그인 시간 => 1년을 초과하면 return false;
        return true;
    }
}
