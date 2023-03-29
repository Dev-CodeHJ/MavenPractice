package org.mybatis.test.app.mapper;

import org.junit.jupiter.api.Test;
import org.mybatis.test.app.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    void findAll() {
        //given
        BoardDto board1 = BoardDto.builder()
                .memberId("H")
                .title("title1")
                .content("hello!")
                .build();
        mapper.save(board1);


        BoardDto board2 = BoardDto.builder()
                .memberId("J")
                .title("title2")
                .content("hello@")
                .build();
        mapper.save(board2);

        //when
        List<BoardDto> boardList = mapper.findAll();

        //then
        assertThat(boardList.size()).isEqualTo(2);
        System.out.println("boardList.size() = " + boardList.size());
    }

    @Test
    void findById() {
        //given
        BoardDto board = BoardDto.builder()
                .memberId("K")
                .title("new title")
                .content("hihi")
                .build();
        mapper.save(board);

        //when
        BoardDto findBoard = mapper.findById(board.getBoardId());

        //then
        assertThat(findBoard).isEqualTo(board);
        System.out.println("board = " + board);
        System.out.println("findBoard = " + findBoard);
    }

    @Test
    void findByMemberId() {
        //given
        BoardDto board1 = BoardDto.builder()
                .memberId("K")
                .title("title1")
                .content("hello!")
                .build();
        mapper.save(board1);


        BoardDto board2 = BoardDto.builder()
                .memberId("K")
                .title("title2")
                .content("hello@")
                .build();
        mapper.save(board2);

        BoardDto board3 = BoardDto.builder()
                .memberId("HJ")
                .title("new title")
                .content("hihi")
                .build();
        mapper.save(board3);

        //when
        List<BoardDto> memberBoardList = mapper.findByMemberId("K");

        //then
        assertThat(memberBoardList.size()).isEqualTo(2);
        System.out.println("memberBoardList = " + memberBoardList);
    }

    @Test
    void boardCount() {
        //given
        BoardDto board1 = BoardDto.builder()
                .memberId("K")
                .title("title1")
                .content("hello!")
                .build();
        mapper.save(board1);

        BoardDto board2 = BoardDto.builder()
                .memberId("K")
                .title("title2")
                .content("hello@")
                .build();
        mapper.save(board2);

        BoardDto board3 = BoardDto.builder()
                .memberId("HJ")
                .title("new title")
                .content("hihi")
                .build();
        mapper.save(board3);

        //when
        int memberBoardCount = mapper.boardCount("K");

        //then
        assertThat(memberBoardCount).isEqualTo(2);
        System.out.println("memberBoardCount = " + memberBoardCount);
    }

    @Test
    void save() {
        //given
        BoardDto board = BoardDto.builder()
                .memberId("H")
                .title("title")
                .content("hello")
                .build();

        //when
        mapper.save(board);
        BoardDto result = mapper.findById(board.getBoardId());

        //then
        assertThat(result).isEqualTo(board);
        System.out.println("board = " + board);
        System.out.println("result = " + result);

    }
}