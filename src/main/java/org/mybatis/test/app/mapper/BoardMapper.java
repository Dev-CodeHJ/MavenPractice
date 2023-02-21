package org.mybatis.test.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.test.app.domain.Board;

import java.util.List;

@Mapper
public interface BoardMapper {

     List<Board> findAll();

     Board findById(int id);

     Board findByName(String name);

}

