package com.liu.auth;

import com.alibaba.fastjson.JSON;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
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
 * @date 2020/10/12 13:30
 **/
@RunWith(SpringRunner.class)
@SpringBootTest()
public class RoleTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");


    private MockMvc mockMvc;


    @Before
    public void setUp(){

        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(documentationConfiguration(restDocumentation)).build();

    }

    @Test
    @Transactional
    public void createRole()throws Exception{
        mockMvc.perform(post("/role/createRole").param("id","11").param("name","角色11")
        ).andExpect(status().isOk()).andExpect(jsonPath("$.code",is("1"))).
                andDo(document("/role/createRole",
                        requestParameters(parameterWithName("id").description("name"),
                                          parameterWithName("name").description("code")
                                     ),
                        responseFields(fieldWithPath("code").description("1成功，-1失败"),fieldWithPath("message").description("提示信息"))
                        )


                );

    }

    @Test
    @Transactional
    public void modifyRole()throws Exception{
        mockMvc.perform(post("/role/modifyRole").param("id","1").param("name","角色名")
        ).andExpect(status().isOk())
        .andExpect(jsonPath("$.code",is("1")))
        .andDo(document("/role/modifyRole",
                requestParameters(parameterWithName("id").description("id"),
                        parameterWithName("name").description("角色名")
                        ),
                responseFields(fieldWithPath("code").description("1成功，-1失败"),fieldWithPath("message").description("提示信息"))
                )
        );

    }

    @Test
    @Transactional
    public void findRolesByIds()throws Exception{
        List<String> ids=new ArrayList<>();
        ids.add("1");
        mockMvc.perform(get("/role/findRolesByIds").contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(ids)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].name",is("角色1")))
                .andDo(document("/role/findRolesByIds",
                        requestFields(fieldWithPath("[]").description("角色id")),
                        responseFields(fieldWithPath("code").description("1成功，-1失败"),fieldWithPath("message").description("提示信息"),fieldWithPath("data[].id").description("角色ID"),fieldWithPath("data[].name").description("角色名"))




                        )





                )
        ;

    }

    @Test
    public void findRoleById()throws Exception{

        mockMvc.perform(get("/role/findRoleById").param("id","1"))
            .andExpect(jsonPath("$.code",is("1")))
            .andExpect(jsonPath("$.data.name",is("角色1")))
            .andExpect(status().isOk())
            .andDo(document("/role/findRoleById",requestParameters(
                    parameterWithName("id").description("角色id")
                    ),
                    responseFields(fieldWithPath("code").description("1成功，-1失败"),fieldWithPath("message").description("提示信息"),
                            fieldWithPath("data.id").description("角色id"),
                            fieldWithPath("data.name").description("角色名")

                            )
            ))

        ;


    }

}
