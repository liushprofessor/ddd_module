package com.liu.controller;

import com.liu.common.pojo.Result;
import com.liu.common.utils.ObjectCopyUtils;
import com.liu.common.utils.ResultUtil;
import com.liu.controller.dto.RoleDTO;
import com.liu.controller.dto.UpdateRoleDTO;
import com.liu.domain.Role;
import com.liu.domain.RoleService;
import com.liu.domain.client.CreateRoleCommand;
import com.liu.domain.client.UpdateRoleCommand;
import com.liu.infrastructure.pojo.CreateRoleDO;
import com.liu.infrastructure.pojo.UpdateRoleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @author Liush
 * @description
 * @date 2020/10/10 17:23
 **/
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/createRole")
    public Result createRole(CreateRoleDO roleDTO){
        roleService.createRole(ObjectCopyUtils.copy(roleDTO, CreateRoleCommand.class));
        return ResultUtil.success();
    }


    @RequestMapping("/modifyRole")
    public Result modifyRole(UpdateRoleDTO roleDTO){
        roleService.modifyRole(ObjectCopyUtils.copy(roleDTO, UpdateRoleCommand.class));
        return ResultUtil.success();

    }

    @RequestMapping("/findRolesByIds")
    public Result findRolesByIds(@RequestBody  List<String> ids){

       return ResultUtil.success(roleService.findRolesByIds(ids));

    }

    @RequestMapping("/findRoleById")
    public Result findRoleById(String id){
       Role role= roleService.restoreRoleById(id);
       return ResultUtil.success(ObjectCopyUtils.copy(role,RoleDTO.class));
    }


}
