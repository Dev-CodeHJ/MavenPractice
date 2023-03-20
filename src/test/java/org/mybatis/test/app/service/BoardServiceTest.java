package org.mybatis.test.app.service;

import org.junit.jupiter.api.Test;
import org.mybatis.test.app.dto.BoardDto;
import org.mybatis.test.app.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@WebAppConfiguration
@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired
    private BoardMapper mapper;
    @Autowired
    private BoardService service;

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

        //then
        assertThat(dto.getMemberId()).isEqualTo("H");
    }

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
        List<BoardDto> result = service.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
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
        BoardDto result = service.findById(dto.getId());

        //then
        assertThat(result.getMemberId()).isEqualTo("K");

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
        int count = service.boardCount("K");

        //then
        assertThat(count).isEqualTo(2);
    }
}