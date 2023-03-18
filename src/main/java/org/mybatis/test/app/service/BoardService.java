package org.mybatis.test.app.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.mybatis.test.app.mapper.BoardMapper;
import org.mybatis.test.app.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    public void save(BoardDto dto) {
        mapper.save(dto);
    }

    public List<BoardDto> findAll() {
        List<BoardDto> result = mapper.findAll();
        return result;
    }

    public BoardDto findById(int id) {
        BoardDto result = mapper.findById(id);
        return result;
    }

    public int boardCount(String memberId) {
        int result = mapper.boardCount(memberId);
        return result;
    }
}
