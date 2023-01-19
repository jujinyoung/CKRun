package ovenbreak.ckrun.com.paging;

public class PageService {

    public static PageBlock pagingService(int currentPage, int numberPerPage, int numberOfPageBlock, int totalPages) {

        if (totalPages == 0) totalPages = 1;
        int begin = ( currentPage - 1)/numberOfPageBlock * numberOfPageBlock + 1;
        int end    = begin + numberOfPageBlock - 1;
        if( end > totalPages )  end = totalPages;

        boolean prev =   begin == 1 ?  false : true;
        boolean next  =  end == totalPages ? false: true;

        return new PageBlock(currentPage,numberPerPage,numberOfPageBlock,begin,end,prev,next);
    }

    public static int begin(int currentPage, int numberPerPage){
        return (currentPage-1)*numberPerPage + 1;
    }

    public static int end(int currentPage, int numberPerPage){
        return begin(currentPage, numberPerPage) + numberPerPage -1;
    }
}
