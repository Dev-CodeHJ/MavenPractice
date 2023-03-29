package org.mybatis.test.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.test.app.dto.BoardDto;

import java.util.List;

@Mapper
public interface BoardMapper {
     List<BoardDto> findAll();
     BoardDto findById(int id);
     List<BoardDto> findByMemberId(String memberId);

     int boardCount(String memberId);
     void save(BoardDto dto);
     void update(BoardDto dto);
     void delete(int id);
}

