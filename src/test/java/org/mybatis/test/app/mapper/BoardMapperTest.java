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
        BoardDto dto1 = BoardDto.builder()
                .memberId("H")
                .title("title1")
                .content("hello!")
                .build();
        mapper.save(dto1);


        BoardDto dto2 = BoardDto.builder()
                .memberId("J")
                .title("title2")
                .content("hello@")
                .build();
        mapper.save(dto2);

        //when
        List<BoardDto> boardList = mapper.findAll();

        //then
        assertThat(boardList.size()).isEqualTo(2);
    }

    @Test
    void findById() {
        //given
        BoardDto dto = BoardDto.builder()
                .memberId("K")
                .title("new title")
                .content("hihi")
                .build();
        mapper.save(dto);

        //when
        BoardDto board = mapper.findById(dto.getBoardId());

        //then
        assertThat(board).isEqualTo(dto);
        System.out.println("dto = " + dto);
        System.out.println("board = " + board);
    }

    @Test
    void findByMemberId() {
        //given
        BoardDto dto1 = BoardDto.builder()
                .memberId("K")
                .title("title1")
                .content("hello!")
                .build();
        mapper.save(dto1);


        BoardDto dto2 = BoardDto.builder()
                .memberId("K")
                .title("title2")
                .content("hello@")
                .build();
        mapper.save(dto2);

        BoardDto dto3 = BoardDto.builder()
                .memberId("HJ")
                .title("new title")
                .content("hihi")
                .build();
        mapper.save(dto3);

        //when
        List<BoardDto> memberBoardList = mapper.findByMemberId("K");

        //then
        assertThat(memberBoardList.size()).isEqualTo(2);
        System.out.println("memberBoardList = " + memberBoardList);
    }

    @Test
    void boardCount() {
        //given
        BoardDto dto1 = BoardDto.builder()
                .memberId("K")
                .title("title1")
                .content("hello!")
                .build();
        mapper.save(dto1);

        BoardDto dto2 = BoardDto.builder()
                .memberId("K")
                .title("title2")
                .content("hello@")
                .build();
        mapper.save(dto2);

        BoardDto dto3 = BoardDto.builder()
                .memberId("HJ")
                .title("new title")
                .content("hihi")
                .build();
        mapper.save(dto3);

        //when
        int memberBoardCount = mapper.boardCount("K");

        //then
        assertThat(memberBoardCount).isEqualTo(2);
        System.out.println("memberBoardCount = " + memberBoardCount);
    }

    @Test
    void save() {
        //given
        BoardDto dto = BoardDto.builder()
                .memberId("H")
                .title("title")
                .content("hello")
                .build();

        //when
        mapper.save(dto);
        BoardDto result = mapper.findById(dto.getBoardId());

        //then
        assertThat(result).isEqualTo(dto);
        System.out.println("dto = " + dto);
        System.out.println("result = " + result);

    }
}