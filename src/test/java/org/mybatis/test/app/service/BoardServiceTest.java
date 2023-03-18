package org.mybatis.test.app.service;

import org.junit.jupiter.api.Test;
import org.mybatis.test.app.mapper.BoardMapper;
import org.mybatis.test.app.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@WebAppConfiguration
@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardMapper mapper;
    @Autowired
    private BoardService service;

    @Test
    void save() {
        //given
        BoardDto dto = BoardDto.builder()
                .id(2)
                .memberId("H")
                .title("title")
                .content("hello")
                .build();

        //when
        mapper.save(dto);

        //then
        assertThat(dto.getId()).isEqualTo(2);
    }

    @Test
    void findAll() {
        //given
        BoardDto dto1 = BoardDto.builder()
                .id(2)
                .memberId("H")
                .title("title1")
                .content("hello!")
                .build();
        mapper.save(dto1);


        BoardDto dto2 = BoardDto.builder()
                .id(3)
                .memberId("J")
                .title("title2")
                .content("hello@")
                .build();
        mapper.save(dto2);

        //when
        List<BoardDto> result = service.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
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