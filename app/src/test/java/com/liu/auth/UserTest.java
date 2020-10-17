package com.liu.auth;


import com.alibaba.fastjson.JSON;
import com.liu.controller.dto.UpdateUserDTO;
import com.liu.controller.dto.UpdateUserRoleDTO;
import com.liu.domain.UserService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.LinkedHashSet;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.hamcrest.Matchers.*;

/**
 * @author Liush
 * @description
 * @date 2020/9/26 21:21
 **/
@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserTest {

    @Autowired
    UserService userService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");


    private MockMvc mockMvc;


    @Before
    public void setUp(){

        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(documentationConfiguration(restDocumentation)).build();

    }


    /**
     * requestFields 可以理解为添加的示例数据入{"id":"222","name":"Liush"}
     * responseFields 同理
     * requestParameters 为入参数,使用此方法添加后会生成入场表格文件
     */
    @Test
    @Transactional
    public void createUser()throws Exception{
        mockMvc.perform(post("/createUser").contentType(MediaType.TEXT_PLAIN)
                .param("id","12353").param("name","lius").param("mobile","123421")
                .param("password","password")
        )
                .andExpect(status().isOk())
               .andDo(document("/user/createUser",requestParameters(parameterWithName("id").description("用户id"),
                       parameterWithName("name").description("姓名"),
                       parameterWithName("mobile").description("电话"),
                       parameterWithName("password").description("密码")
                       ),
                       responseFields(fieldWithPath("code").description("1成功，-1失败"),fieldWithPath("message").description("提示信息"))
               ));




    }


    @Test
    @Transactional
    public void modifyUser()throws Exception{
        UpdateUserDTO updateUserDTO=new UpdateUserDTO("123","name","mobile");
        mockMvc.perform(post("/modifyUser").contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(updateUserDTO))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code",is("1")))
                .andDo(document("/user/modifyUser",
                        requestFields(fieldWithPath("id").description("id"),fieldWithPath("name").description("姓名"),fieldWithPath("mobile").description("电话")),
                        responseFields(fieldWithPath("code").description("1成功，-1失败"),fieldWithPath("message").description("提示信息"))
                ));




    }



    @Test
    public void findUserById()throws Exception{
        mockMvc.perform(get("/findUserById").contentType(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_JSON)
                .param("id","1")
        )
                .andExpect(status().isOk())
                .andDo(document("/user/findUserById",
                        requestParameters(parameterWithName("id").description("用户id")),
                        responseFields(fieldWithPath("code").description("1成功，-1失败"),fieldWithPath("message").description("提示信息"),fieldWithPath("data.id").description("id"),fieldWithPath("data.name").description("name"),
                                fieldWithPath("data.mobile").description("电话"),fieldWithPath("data.roles[].id").description("角色ID"),fieldWithPath("data.roles[].name").description("角色名")
                        )
                ));




    }


    @Test
    @Transactional
    public void modifyUserRole()throws Exception{
        LinkedHashSet<String> roles=new LinkedHashSet<>();
        roles.add("1");
        UpdateUserRoleDTO updateUserDTO=new UpdateUserRoleDTO("1",roles);
        mockMvc.perform(post("/modifyUserRole").contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(updateUserDTO))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code",is("1")))
                .andDo(document("/user/modifyUserRole",
                        requestFields(fieldWithPath("id").description("id"),fieldWithPath("roles[]").description("角色")),
                        responseFields(fieldWithPath("code").description("1成功，-1失败"),fieldWithPath("message").description("提示信息"))
                ));




    }






}
