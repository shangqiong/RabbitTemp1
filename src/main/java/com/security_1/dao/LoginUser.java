package com.security_1.dao;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser implements UserDetails {
    private static final long serialVersionUID = -7971486849150250051L;
    private User user;
    private List<String > list;
    @JSONField(serialize = false)
    private List<GrantedAuthority> newList;

    public LoginUser(User user, List<String> list) {
        this.user = user;
        this.list = list;
//        for (String s : this.list) {
//            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(s);
//            newList.add(simpleGrantedAuthority);
//        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        newList = new ArrayList<>();
        for (String s : this.list) {
            newList.add(new SimpleGrantedAuthority(s));
        }
        return this.newList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
