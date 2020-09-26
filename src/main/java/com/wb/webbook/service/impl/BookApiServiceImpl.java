package com.wb.webbook.service.impl;

import com.wb.webbook.dao.IBookApiDao;
import com.wb.webbook.model.BookInfo;
import com.wb.webbook.model.CategoryInfo;
import com.wb.webbook.model.ChapterInfo;
import com.wb.webbook.mongo.pagehelper.PageResult;
import com.wb.webbook.query.BookQuery;
import com.wb.webbook.query.ChapterQuery;
import com.wb.webbook.service.IBookApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookApiServiceImpl implements IBookApiService {

    @Autowired
    IBookApiDao bookApiDao;

    @Override
    public List<CategoryInfo> getCategoryInfo() {
        return bookApiDao.getCategoryInfo();
    }

    @Override
    public PageResult<BookInfo> getBookListByPage(BookQuery bookQuery) {
        return bookApiDao.getBookListByPage(bookQuery);
    }

    @Override
    public BookInfo getBookDetail(BookQuery bookQuery) {
        return bookApiDao.getBookDetail(bookQuery);
    }

    @Override
    public PageResult<ChapterInfo> getChapterListByPage(ChapterQuery chapterQuery) {
        return bookApiDao.getChapterListByPage(chapterQuery);
    }

    @Override
    public ChapterInfo getChapterContent(ChapterQuery chapterQuery) {
        return bookApiDao.getChapterContent(chapterQuery);
    }
}
