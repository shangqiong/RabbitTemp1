package com.security_1.service;

import com.security_1.dao.User;
import com.security_1.respons.ResponsResult;

public interface LoginService {
    ResponsResult login(User user);

    ResponsResult logout();
}
