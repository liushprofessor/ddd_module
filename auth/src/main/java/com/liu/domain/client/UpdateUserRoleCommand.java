package com.liu.domain.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author Liush
 * @description
 * @date 2020/10/10 16:39
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserRoleCommand {

    private String id;

    private Set<String> roles;

}
