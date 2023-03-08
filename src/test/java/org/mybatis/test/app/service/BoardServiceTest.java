package org.mybatis.test.app.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.test.app.dto.BoardDto;
import org.mybatis.test.app.dao.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class BoardServiceTest {

    @Autowired
    private BoardMapper mapper;
    @Autowired
    private BoardService service;

    @Test
    void findAll() {
        //given
        BoardDto dto1 = BoardDto.builder()
                .id(1)
                .name("K")
                .title("title1")
                .content("hello!")
                .build();


        BoardDto dto2 = BoardDto.builder()
                .id(2)
                .name("H")
                .title("title2")
                .content("hello@")
                .build();

        //when
        List<BoardDto> result = service.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void findById() {
        //given

        //when

        //then

    }

    @Test
    void findByName() {
        //given

        //when

        //then

    }
}