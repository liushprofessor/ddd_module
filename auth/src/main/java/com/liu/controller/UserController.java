package com.liu.controller;

import com.liu.common.pojo.Result;
import com.liu.common.utils.ObjectCopyUtils;
import com.liu.controller.dto.CreateUserDTO;
import com.liu.controller.dto.UpdateUserDTO;
import com.liu.controller.dto.UpdateUserRoleDTO;
import com.liu.common.utils.ResultUtil;
import com.liu.controller.dto.UserDTO;
import com.liu.domain.Role;
import com.liu.domain.RoleService;
import com.liu.domain.User;
import com.liu.domain.UserService;
import com.liu.domain.client.*;
import com.liu.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author Liush
 * @description
 * @date 2020/9/26 21:36
 **/
@RestController
public class UserController {



    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/createUser")
    public Result createUser(CreateUserDTO userDTO){
        userService.createUser(ObjectCopyUtils.copy(userDTO,CreateUserCommand.class));
        return ResultUtil.success();
    }

    @RequestMapping("/modifyUser")
    public Result modifyUserRole(@RequestBody UpdateUserDTO updateUserDTO){
        userService.modifyUser(ObjectCopyUtils.copy(updateUserDTO, UpdateUserCommand.class));
        return ResultUtil.success();
    }

    @RequestMapping("/findUserById")
    public Result findUserById(String id){
        UserRoleModal user=userRepository.findUserById(id);
        return ResultUtil.success(user);
    }

    @RequestMapping("/modifyUserRole")
    public Result modifyUserRole(@RequestBody UpdateUserRoleDTO updateUserRoleDTO){
        userService.modifyUserRole(ObjectCopyUtils.copy(updateUserRoleDTO, UpdateUserRoleCommand.class));
        return ResultUtil.success();
    }

}
