package com.wb.webbook.dao;

import com.wb.webbook.model.BookInfo;
import com.wb.webbook.model.CategoryInfo;
import com.wb.webbook.model.ChapterInfo;
import com.wb.webbook.mongo.pagehelper.PageResult;
import com.wb.webbook.query.BookQuery;
import com.wb.webbook.query.ChapterQuery;

import java.util.List;

public interface IBookApiDao {
    List<CategoryInfo> getCategoryInfo();

    PageResult<BookInfo> getBookListByPage(BookQuery bookQuery);

    PageResult<ChapterInfo> getChapterListByPage(ChapterQuery chapterQuery);

    ChapterInfo getChapterContent(ChapterQuery chapterQuery);

    BookInfo getBookDetail(BookQuery bookQuery);
}
