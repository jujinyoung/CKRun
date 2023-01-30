package ovenbreak.ckrun.repository.cookies;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ovenbreak.ckrun.domain.cookies.Cookies;

import java.util.List;

@Mapper
public interface CookiesMapper {

    List<Cookies> findAllCookies();

    List<Cookies> selectCookiesList(@Param("begin") int begin,@Param("end") int end);

    List<Cookies> searchCookiesList(@Param("begin") int begin,@Param("end") int end, @Param("searchWord") String searchWord);

    Integer getTotalRecords();

    Integer getSearchRecords(String searchWord);

    Cookies findCookiesByID(int ckID);

    Integer addComment(@Param("ckID") int ckID, @Param("aveGrade") double aveGrade);
}
