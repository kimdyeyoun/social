package com.nagaja.admin.util;

import com.nagaja.admin.entity.Pagination;

public class MyUtils {


    public static Pagination Paging(int count, int pageNum, int limit)
    {

        int offset = (pageNum - 1) * limit;
        int start_page = ((pageNum - 1) / 10) * 10 + 1;
        int max_page = (count + limit - 1) / limit;

        Pagination page = new Pagination();
        page.setCount(count);
        page.setPageNum(pageNum);
        page.setStartPage(start_page);
        page.setEndPage(start_page + 9);
        page.setMaxPage(max_page);
        page.setOffset(offset);
        page.setLimit(limit);

        return page;
    }
}
