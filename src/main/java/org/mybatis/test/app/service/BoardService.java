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

    public void create(final BoardDto dto) {

        mapper.save(dto);
        log.info("save id = {}", dto.getBoardId());
    }

    public List<BoardDto> readAll() {
        return mapper.findAll();
    }

    public List<BoardDto> readMemberBoard(String memberId) {

        List<BoardDto> boardLIst = mapper.findByMemberId(memberId);
        return boardLIst;
    }

    public String update(BoardDto dto) {

        Optional<Integer> dtoId = Optional.ofNullable(dto.getBoardId());

        if (dtoId.isPresent()) {

            mapper.update(dto);
            log.info("update id = {}", dto.getBoardId());

            return dto.getBoardId() + "번 글이 수정되었습니다.";

        } else {
            throw new RuntimeException("업데이트할 글이 존재하지 않습니다.");
        }
    }

    public String delete(int id) {

        Optional<BoardDto> foundDto = Optional.ofNullable(mapper.findById(id));

        if (foundDto.isPresent()) {

            mapper.delete(id);
            return id + "번 글이 삭제되었습니다.";

        } else {
            throw new RuntimeException("삭제할 글이 없습니다.");
        }
    }

    private void validate(final BoardDto dto) {

        if (dto == null) {
            log.warn("DTO cannot be null!");
            throw new RuntimeException("DTO cannot be null!");
        }

        if (dto.getMemberId() == null) {
            log.warn("Unknown member!");
            throw new RuntimeException("Unknown member!");
        }
    }
}
