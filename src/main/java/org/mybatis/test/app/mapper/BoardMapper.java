package org.mybatis.test.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.test.app.dto.BoardDto;

import java.util.List;

@Mapper
public interface BoardMapper {
     void save(BoardDto dto);
     List<BoardDto> findAll();
     BoardDto findById(int id);
     public int boardCount(String memberId);

}

