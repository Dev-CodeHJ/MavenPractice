package org.mybatis.test.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.test.app.dto.MemberDto;

@Mapper
public interface MemberMapper {
    void join(MemberDto member);
    void login(MemberDto member);
    void deleteMember(MemberDto member);
}
