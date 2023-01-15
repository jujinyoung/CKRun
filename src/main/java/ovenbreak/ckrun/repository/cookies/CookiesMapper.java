package ovenbreak.ckrun.repository.cookies;

import org.apache.ibatis.annotations.Mapper;
import ovenbreak.ckrun.domain.cookies.Cookies;

import java.util.List;

@Mapper
public interface CookiesMapper {

    List<Cookies> findAllCookies();
}
