package org.mybatis.test.app.service;

import org.junit.jupiter.api.Test;
import org.mybatis.test.app.dto.BoardDto;
import org.mybatis.test.app.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        BoardDto dto = BoardDto.builder()
                .memberId("khj")
                .title("new title")
                .content("hello")
                .build();

        //when
        service.create(dto);

        //then
        assertThat(dto).isEqualTo(mapper.findById(dto.getId()));
    }

    @Test
    void read() {
        //given
        BoardDto dto = BoardDto.builder()
                .memberId("khj")
                .title("new title")
                .content("hello")
                .build();
        service.create(dto);

        BoardDto dto1 = BoardDto.builder()
                .memberId("khj")
                .title("new title1")
                .content("hello1")
                .build();
        service.create(dto1);

        BoardDto dto2 = BoardDto.builder()
                .memberId("hj")
                .title("new title2")
                .content("hello2")
                .build();
        service.create(dto2);

        //when
        List<BoardDto> boardList = service.read("khj");

        //then
        assertThat(boardList.size()).isEqualTo(2);
    }

    @Test
    void update() {
        //given
        BoardDto dto = BoardDto.builder()
                .memberId("khj")
                .title("new title")
                .content("hello")
                .build();
        service.create(dto);

        //when
        String updateMessage = service.update(dto);

        //then
        System.out.println(updateMessage);
    }

    @Test
    void delete() {
        //given
        BoardDto dto = BoardDto.builder()
                .memberId("khj")
                .title("new title")
                .content("hello")
                .build();
        service.create(dto);

        //when
        String deleteMessage = service.delete(dto.getId());

        //then
        System.out.println(deleteMessage);
    }
}