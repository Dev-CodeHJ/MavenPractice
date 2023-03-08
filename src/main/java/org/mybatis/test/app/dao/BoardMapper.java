package org.mybatis.test.app.dao;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.test.app.dto.BoardDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
     public void save(BoardDto dto);
     List<BoardDto> findAll();
     Optional<BoardDto> findById(int id);
     public int boardCount(String name);

}

