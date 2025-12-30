package com.rong.rongdadabackenduserservice.controller.inner;

import com.rong.rongdadabackendcommon.common.ErrorCode;
import com.rong.rongdadabackendcommon.exception.ThrowUtils;
import com.rong.rongdadabackendmodel.entity.User;
import com.rong.rongdadabackendserviceclient.service.UserFeignClient;
import com.rong.rongdadabackenduserservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 用户接口
 */
@RestController
@RequestMapping("/inner")
@Slf4j
public class UserInnerController implements UserFeignClient {

    @Resource
    private UserService userService;

    /**
     * @param userId
     * @return
     */
    @Override
    @GetMapping("/get/id")
    public User getById(Long userId) {
        ThrowUtils.throwIf(userId == null, ErrorCode.PARAMS_ERROR,"用户id不能为空");
        User user = userService.getById(userId);
        ThrowUtils.throwIf(user == null, ErrorCode.NOT_FOUND_ERROR,"用户不存在");
        return user;
    }

    /**
     * @param idList
     * @return
     */
    @Override
    @GetMapping("/list/ids")
    public List<User> listByIds(Collection<? extends Serializable> idList) {
        ThrowUtils.throwIf(idList == null, ErrorCode.PARAMS_ERROR,"id列表不能为空");
        return userService.listByIds(idList);
    }
}
