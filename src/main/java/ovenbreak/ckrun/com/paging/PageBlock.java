package ovenbreak.ckrun.com.paging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PageBlock {

    private int currentPage;
    private int numberPerPage = 10;
    private int numberOfPageBlock = 10;
    private int startOfPageBlock = 1;  // 시작 번호
    private int endOfPageBlock ;  // 끝 번호
    private boolean isPrev, isNext;    //이전,다음버튼
}
