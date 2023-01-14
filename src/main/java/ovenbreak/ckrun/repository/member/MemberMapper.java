package ovenbreak.ckrun.repository.member;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ovenbreak.ckrun.domain.member.Member;

@Mapper
public interface MemberMapper {

    void save(Member member);

    Member login(@Param("email") String email, @Param("password") String password);
}
