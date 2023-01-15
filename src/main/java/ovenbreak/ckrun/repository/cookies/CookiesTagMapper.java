package ovenbreak.ckrun.repository.cookies;

import org.apache.ibatis.annotations.Mapper;
import ovenbreak.ckrun.domain.cookies.CookiesTag;

import java.util.List;

@Mapper
public interface CookiesTagMapper {

    List<CookiesTag> findByName(String name);
}
