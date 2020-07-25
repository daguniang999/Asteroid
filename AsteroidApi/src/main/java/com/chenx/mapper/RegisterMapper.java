package com.chenx.mapper;

import com.chenx.common.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterMapper {
    User isExist(User user);
    Integer addUser(User user);
}
