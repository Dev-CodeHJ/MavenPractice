package org.mybatis.test.app.service;

import org.mybatis.test.app.dao.BoardMapper;
import org.mybatis.test.app.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<BoardDto> findAll() {
        List<BoardDto> result = boardMapper.findAll();
        return result;
    }

    public Optional<BoardDto> findById(int id) {
        Optional<BoardDto> result = boardMapper.findById(id);
        return result;
    }

//    public int boardCount(String name) {
//        Optional<BoardDto> result = boardMapper.boardCount(name);
//        return result;
//    }
}
