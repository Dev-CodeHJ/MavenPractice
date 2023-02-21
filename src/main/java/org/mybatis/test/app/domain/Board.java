package org.mybatis.test.app.domain;

import lombok.*;

@Data
@NoArgsConstructor
public class Board {
    private int boardId;
    private String name;
    private String title;
    private String content;

    @Builder

    public Board(int boardId, String name, String title, String content) {
        this.boardId = boardId;
        this.name = name;
        this.title = title;
        this.content = content;
    }
}
