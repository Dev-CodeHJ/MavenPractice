package org.mybatis.test.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.test.app.mapper.BoardMapper;
import org.mybatis.test.app.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    public String create(final BoardDto board) {

        mapper.save(board);
        log.info("save id = {}", board.getBoardId());

        return board.getBoardId() + "번 글이 생성되었습니다.";
    }

    public List<BoardDto> readAll() {
        return mapper.findAll();
    }

    public List<BoardDto> readMemberBoard(String memberId) {
        return mapper.findByMemberId(memberId);
    }

    public String update(BoardDto board) {

        mapper.update(board);
        log.info("update id = {}", board.getBoardId());

        return board.getBoardId() + "번 글이 수정되었습니다.";
    }

    public String delete(int boardId) {

        Optional<BoardDto> foundBoard = Optional.ofNullable(mapper.findById(boardId));

        if (foundBoard.isPresent()) {

            mapper.delete(boardId);
            return boardId + "번 글이 삭제되었습니다.";

        } else {
            throw new RuntimeException("삭제할 글이 없습니다.");
        }
    }

    private void validate(final BoardDto board) {

        if (board == null) {
            log.warn("board cannot be null!");
            throw new RuntimeException("board cannot be null!");
        }

        if (board.getMemberId() == null) {
            log.warn("Unknown member!");
            throw new RuntimeException("Unknown member!");
        }
    }
}
