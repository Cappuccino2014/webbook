package com.wb.webbook.controller;


import com.wb.enums.ResultCode;
import com.wb.model.ResultBean;
import com.wb.webbook.model.BookInfo;
import com.wb.webbook.model.ChapterInfo;
import com.wb.webbook.mongo.pagehelper.PageResult;
import com.wb.webbook.query.BookQuery;
import com.wb.webbook.query.ChapterQuery;
import com.wb.webbook.service.IBookApiService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(allowCredentials="true")
@RestController
@RequestMapping("/bookapi")
public class BookApiController {

    @Autowired
    IBookApiService bookApiService;

    /**
     * @api {GET} /bookapi/category 获取类型列表
     * @apiVersion 0.1.0
     * @apiGroup category
     * @apiName categoryList
     * @apiUse returnSuccess
     * @apiSuccessExample {json} 返回样例
     * {
     *     "code": 200,
     *     "message": "success",
     *     "data": [
     *         {
     *             "id": "5ccac5bc30aabb4dbed09b83",
     *             "categoryName": "职场校园"
     *         }
     *     ]
     * }
     */
    @RequestMapping("/category")
    public ResultBean getCategory() {
        return ResultBean.success(bookApiService.getCategoryInfo());
    }

    /**
     * @api {POST} /bookapi/chapter 获取章节列表
     * @apiVersion 0.1.0
     * @apiGroup chapter
     * @apiName chapterList
     * @apiParam {String} bookId 书籍id,不可为空
     * @apiUse pageParam
     * @apiParamExample {json} 请求样例
     * {
     *     "bookId": "5ccac5a530aabb4dbed09afc",
     *     "pageSize": 10,
     *     "pageNum": 1,
     *     "lastId": ""
     * }
     * @apiUse returnSuccess
     * @apiSuccessExample {json} 返回样例
     * {
     *     "code": 200,
     *     "message": "success",
     *     "data": {
     *         "pageNum": 1,
     *         "pageSize": 10,
     *         "total": 85,
     *         "pages": 9,
     *         "list": [
     *             {
     *                 "chapterNumber": 48,
     *                 "chapterName": "第五十章 先进状况救援队",
     *                 "id": "5ccac5a630aabb4dbed09afe"
     *             }
     *         ]
     *     }
     * }
     */
    @RequestMapping("/chapter")
    public ResultBean getChapterListByPage(ChapterQuery chapterQuery) {
        if (StringUtils.isBlank(chapterQuery.getBookId())) {
            return ResultBean.error(ResultCode.NOT_NULL,"bookId不能为空");
        }
        PageResult<ChapterInfo> chapterList = bookApiService.getChapterListByPage(chapterQuery);
        return ResultBean.success(chapterList);
    }

    /**
     * @api {POST} /bookapi/chapter/content 获取章节内容
     * @apiVersion 0.1.0
     * @apiGroup chapter
     * @apiName chapterContent
     * @apiParam {String} id 章节id,不可为空
     * @apiParamExample {json} 请求样例
     * {
     *     "id": "5ccac5a530aabb4dbed09afa"
     * }
     * @apiUse returnSuccess
     * @apiSuccessExample {json} 返回样例：
     * {
     *     "code": 200,
     *     "message": "success",
     *     "data": {
     *         "chapterNumber": 14,
     *         "chapterName": "第14章 风狐",
     *         "chapterContent": "xxxxx",
     *         "bookId": "5ccac5a330aabb4dbed09af9",
     *         "id": "5ccac5a530aabb4dbed09afa"
     *     }
     * }
     */
    @RequestMapping("/chapter/content")
    public ResultBean getChapterContent(ChapterQuery chapterQuery) {
        ChapterInfo chapterContent = bookApiService.getChapterContent(chapterQuery);
        return ResultBean.success(chapterContent);
    }

    /**
     * @api {POST} /bookapi/book 获取书籍列表
     * @apiVersion 0.1.0
     * @apiGroup book
     * @apiName bookList
     * @apiParam {String} [categoryId] 类别id,为空则不按分类查询
     * @apiUse pageParam
     * @apiParamExample {json} 请求样例
     * {
     *     "categoryId": "",
     *     "pageSize": 10,
     *     "pageNum": 1,
     *     "lastId": ""
     * }
     * @apiUse returnSuccess
     * @apiSuccessExample {json} 返回样例
     * {
     *     "code": 200,
     *     "message": "success",
     *     "data": {
     *         "pageNum": 1,
     *         "pageSize": 10,
     *         "total": 5,
     *         "pages": 1,
     *         "list": [
     *             {
     *                 "id": "5ccac5a230aabb4dbed09af7",
     *                 "bookName": "快穿之青蘅",
     *                 "cover": "cover/快穿之青蘅.jpg"
     *             }
     *         ]
     *     }
     * }
     */
    @RequestMapping("/book")
    public ResultBean getbookList(BookQuery bookQuery) {
        PageResult<BookInfo> bookList = bookApiService.getBookListByPage(bookQuery);
        return ResultBean.success(bookList);
    }

    /**
     * @api {POST} /bookapi/book/detail 获取书籍详情
     * @apiVersion 0.1.0
     * @apiGroup book
     * @apiName bookDetail
     * @apiParam {String} id 书籍id,不可为空
     * @apiParamExample {json} 请求样例
     * {
     *     "id": "5ccac5a330aabb4dbed09af9"
     * }
     * @apiUse returnSuccess
     * @apiSuccessExample {json} 返回样例
     * {
     *     "code": 200,
     *     "message": "成功",
     *     "data": {
     *         "id": "5ccac5a330aabb4dbed09af9",
     *         "bookName": "末世之强制情人",
     *         "cover": "cover/末世之强制情人.jpg",
     *         "author": "跑跑红枣",
     *         "intro": "介绍:    夏庭重生了，以为能和无数小说的主角一样，牛逼哄哄的虐死渣男，斗败小三，修个法术，横行末世。",
     *         "categoryId": "5ccac5a230aabb4dbed09af8"
     *     }
     * }
     */
    @RequestMapping("/book/detail")
    public ResultBean getbookDetail(BookQuery bookQuery) {
        BookInfo bookInfo = bookApiService.getBookDetail(bookQuery);
        return ResultBean.success(bookInfo);
    }
}
