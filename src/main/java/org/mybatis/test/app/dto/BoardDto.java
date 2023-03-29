package org.mybatis.test.app.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
        private int boardId;
        private String memberId;
        private String title;
        private String content;
}
