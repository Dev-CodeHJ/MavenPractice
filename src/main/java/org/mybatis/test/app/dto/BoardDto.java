package org.mybatis.test.app.dto;

import lombok.*;

@Data
@Builder
public class BoardDto {
        private int BoardId;
        private String memberId;
        private String title;
        private String content;
}
