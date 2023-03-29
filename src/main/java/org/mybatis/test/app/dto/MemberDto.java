package org.mybatis.test.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private String memberId;
    @JsonIgnore
    private String pw;
    private String name;
    private String gender;
    private String email;
}
