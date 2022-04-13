package com.ysh.Utils;

import com.ysh.Pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail implements UserDetails {


    private User user;
    private List list;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(list==null){
            list=new ArrayList<SimpleGrantedAuthority>();
            for (String s : user.getPrem()) {
                list.add(new SimpleGrantedAuthority(s));
            }
            return list;
        }

        return list;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }
    //UsernameNotFoundException用户不存在
    @Override
    public String getUsername() {
        return user.getUsername();
    }
    //账户未过期
    @Override
    public boolean isAccountNonExpired() {

        return true;
    }
    //LockedException账户锁定
    @Override
    public boolean isAccountNonLocked() {

        return true;

    }
    //凭证未过期BadCredentialsException
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    //LockedException
    @Override
    public boolean isEnabled() {
        return true;

    }
}
