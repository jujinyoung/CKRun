package ovenbreak.ckrun.repository.cookies;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ovenbreak.ckrun.domain.cookies.CookiesComment;

import java.util.List;

@Mapper
public interface CookiesCommentMapper {

    List<CookiesComment> findAllCommentsByCkID(int ckID);

    List<CookiesComment> findBestCommentsByCKID(int ckID);

    void insert(@Param("ckID") int ckID,@Param("email") String email, @Param("nickname") String nickname
            ,@Param("grade") int grade , @Param("content") String content);

    Double selectAverageGrade(int ckID);

    void updateRecommend(int commentID);

    int findRecommendByID(int commentID);
}
