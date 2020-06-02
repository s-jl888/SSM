package org.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.po.User;
import org.po.UserExample;

public interface UserMapper {
   public User findUser(@Param("usercode") String usercode,
                        @Param("password") String password);
}