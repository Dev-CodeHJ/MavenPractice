package org.mybatis.test.app.dto;

import lombok.*;

@Data
@Builder
public record BoardDto(
        int id,
        String name,
        String title,
        String content
) {

}
