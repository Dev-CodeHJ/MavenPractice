package org.mybatis.test.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDto {

    private String memberId;
    private String password;
    private String name;
    private String gender;
    private String email;
}
