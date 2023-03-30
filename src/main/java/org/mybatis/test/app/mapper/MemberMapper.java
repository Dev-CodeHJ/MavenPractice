package org.mybatis.test.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.test.app.dto.MemberDto;

@Mapper
public interface MemberMapper {
    MemberDto findByMember(String memberId);
    MemberDto login(String memberId, String pw);

    void join(MemberDto member);
    void updateMember(MemberDto member);
    void deleteMember(MemberDto member);
}
