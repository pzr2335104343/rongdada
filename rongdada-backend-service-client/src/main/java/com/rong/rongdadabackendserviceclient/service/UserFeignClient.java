package com.rong.rongdadabackendserviceclient.service;


import com.rong.rongdadabackendcommon.common.ErrorCode;
import com.rong.rongdadabackendcommon.exception.BusinessException;
import com.rong.rongdadabackendmodel.entity.User;
import com.rong.rongdadabackendmodel.enums.UserRoleEnum;
import com.rong.rongdadabackendmodel.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import static com.rong.rongdadabackendcommon.constant.UserConstant.USER_LOGIN_STATE;

/**
 * 用户服务
 */
@FeignClient(name = "rongdada-backend-user-service", path = "/api/user/inner")
public interface UserFeignClient {

    /**
     * 根据用户id获取用户
     *
     * @param userId
     * @return
     */
    @GetMapping("/get/id")
    User getById(@RequestParam("userId") Long userId);

    /**
     * 根据用户id列表获取用户列表
     *
     * @param idList
     * @return
     */
    @GetMapping("/list/ids")
    List<User> listByIds(@RequestParam("idList") Collection<? extends Serializable> idList);

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    default User getLoginUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(USER_LOGIN_STATE);
        if (user == null || user.getId() ==null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        return user;
    }

    /**
     * 是否为管理员
     *
     * @param user
     * @return
     */
    default boolean isAdmin(User user) {
        return user != null &&
                UserRoleEnum.ADMIN.getValue().equals(user.getUserRole());
    }

    /**
     * 获取脱敏的用户信息
     *
     * @param user
     * @return
     */
    default UserVO getUserVO(User user){
        if (user == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
