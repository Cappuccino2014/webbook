package com.wb.webbook.service;

import com.wb.webbook.model.BookInfo;
import com.wb.webbook.model.CategoryInfo;
import com.wb.webbook.model.ChapterInfo;
import com.wb.webbook.mongo.pagehelper.PageResult;
import com.wb.webbook.query.BookQuery;
import com.wb.webbook.query.ChapterQuery;

import java.util.List;

public interface IBookApiService {


    List<CategoryInfo> getCategoryInfo();

    PageResult<BookInfo> getBookListByPage(BookQuery bookQuery);

    BookInfo getBookDetail(BookQuery bookQuery);

    PageResult<ChapterInfo> getChapterListByPage(ChapterQuery chapterQuery);

    ChapterInfo getChapterContent(ChapterQuery chapterQuery);
}
