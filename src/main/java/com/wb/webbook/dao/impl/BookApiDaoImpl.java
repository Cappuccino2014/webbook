package com.wb.webbook.dao.impl;

import com.wb.webbook.dao.IBookApiDao;
import com.wb.webbook.model.BookInfo;
import com.wb.webbook.model.CategoryInfo;
import com.wb.webbook.model.ChapterInfo;
import com.wb.webbook.mongo.pagehelper.MongoPageHelper;
import com.wb.webbook.mongo.pagehelper.PageResult;
import com.wb.webbook.query.BookQuery;
import com.wb.webbook.query.ChapterQuery;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookApiDaoImpl implements IBookApiDao {

    @Autowired
    MongoPageHelper mongoPageHelper;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<CategoryInfo> getCategoryInfo() {
        return mongoTemplate.findAll(CategoryInfo.class);
    }

    @Override
    public PageResult<BookInfo> getBookListByPage(BookQuery bookQuery) throws IllegalArgumentException {
        final Query query = new Query();
        String categoryId = bookQuery.getCategoryId();
        if (StringUtils.isNotBlank(categoryId)) {
            query.addCriteria(Criteria.where("categoryId").is(new ObjectId(categoryId)));
        }
        query.fields().include("bookName");
        query.fields().include("cover");
        query.fields().include("_id");
        query.with(new Sort(Sort.Direction.DESC,"_id"));
        return mongoPageHelper.pageQuery(query, BookInfo.class, bookQuery.getPageSize(),
                bookQuery.getPageNum(), bookQuery.getLastId());
    }

    @Override
    public BookInfo getBookDetail(BookQuery bookQuery) throws IllegalArgumentException {
        String id = bookQuery.getId();
        BookInfo bookInfo = mongoTemplate.findById(new ObjectId(id),BookInfo.class);
        return bookInfo;
    }

    @Override
    public PageResult<ChapterInfo> getChapterListByPage(ChapterQuery chapterQuery) throws IllegalArgumentException {
        String bookId = chapterQuery.getBookId();
        final Query query = new Query(Criteria.where("bookId").is(new ObjectId(bookId)));
        query.fields().include("chapterNumber");
        query.fields().include("chapterName");
        query.fields().include("_id");
        query.with(new Sort(Sort.Direction.ASC,"chapterNumber"));
        PageResult<ChapterInfo> chapterInfoPageResult = mongoPageHelper.pageQuery(query, ChapterInfo.class, chapterQuery.getPageSize(),
                chapterQuery.getPageNum(), chapterQuery.getLastId());
        return chapterInfoPageResult;
    }

    @Override
    public ChapterInfo getChapterContent(ChapterQuery chapterQuery) throws IllegalArgumentException {
        return mongoTemplate.findById(new ObjectId(chapterQuery.getId()),ChapterInfo.class);
    }


}
