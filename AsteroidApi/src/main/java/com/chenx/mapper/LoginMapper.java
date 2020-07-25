package com.chenx.mapper;

import com.chenx.common.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginMapper {
    User getLogin(String username);
}
