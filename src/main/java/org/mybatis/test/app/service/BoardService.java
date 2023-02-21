package org.mybatis.test.app.service;

import lombok.RequiredArgsConstructor;
import org.mybatis.test.app.domain.Board;
import org.mybatis.test.app.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public List<Board> findAll() {
        List<Board> result = boardMapper.findAll();
        return result;
    }

    public Board findById(int id) {
        Board result = boardMapper.findById(id);
        return result;
    }

    public Board findByName(String name) {
        Board result = boardMapper.findByName(name);
        return result;
    }
}
