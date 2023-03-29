package org.mybatis.test.app.service;

import org.junit.jupiter.api.Test;
import org.mybatis.test.app.dto.BoardDto;
import org.mybatis.test.app.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired
    BoardService service;
    @Autowired
    BoardMapper mapper;

    @Test
    void create() {
        //given
        BoardDto board = BoardDto.builder()
                .memberId("khj")
                .title("new title")
                .content("hello")
                .build();

        //when
        service.create(board);

        //then
        assertThat(board).isEqualTo(mapper.findById(board.getBoardId()));
    }

    @Test
    void readAll() {
        //given
        BoardDto board = BoardDto.builder()
                .memberId("khj")
                .title("new title")
                .content("hello")
                .build();
        service.create(board);

        BoardDto board1 = BoardDto.builder()
                .memberId("jhb")
                .title("new title1")
                .content("hello1")
                .build();
        service.create(board1);

        BoardDto board2 = BoardDto.builder()
                .memberId("gnl")
                .title("new title2")
                .content("hello2")
                .build();
        service.create(board2);

        //when
        List<BoardDto> boardList = service.readAll();

        //then
        assertThat(boardList.size()).isEqualTo(3);
        System.out.println("All:boardList = " + boardList.size() + "건의 글이 조회되었습니다.");
    }

    @Test
    void readMemberBoard() {
        //given
        BoardDto board = BoardDto.builder()
                .memberId("khj")
                .title("new title")
                .content("hello")
                .build();
        service.create(board);

        BoardDto board1 = BoardDto.builder()
                .memberId("khj")
                .title("new title1")
                .content("hello1")
                .build();
        service.create(board1);

        BoardDto board2 = BoardDto.builder()
                .memberId("hj")
                .title("new title2")
                .content("hello2")
                .build();
        service.create(board2);

        //when
        List<BoardDto> boardList = service.readMemberBoard("khj");
        System.out.println("boardList = " + boardList);

        //then
        assertThat(boardList.size()).isEqualTo(2);
        System.out.println("khj:boardList = " + boardList.size() + "건의 글이 조회되었습니다.");
    }

    @Test
    void update() {
        //given
        BoardDto board = BoardDto.builder()
                .memberId("khj")
                .title("new title")
                .content("hello")
                .build();
        service.create(board);

        //when
        String updateMessage = service.update(board);

        //then
        System.out.println(updateMessage);
    }

    @Test
    void delete() {
        //given
        BoardDto board = BoardDto.builder()
                .memberId("khj")
                .title("new title")
                .content("hello")
                .build();
        service.create(board);

        //when
        String deleteMessage = service.delete(board.getBoardId());

        //then
        System.out.println(deleteMessage);
    }
}