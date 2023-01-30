package ovenbreak.ckrun.repository.cookies;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ovenbreak.ckrun.domain.cookies.CookiesTag;

import java.util.List;

@Mapper
public interface CookiesTagMapper {

    List<CookiesTag> findByID(int ckID);

    List<CookiesTag> findByTagName(@Param("begin") int begin,@Param("end") int end, @Param("tagName") String tagName);

    Integer getTotalRecords(String tagName);
}
