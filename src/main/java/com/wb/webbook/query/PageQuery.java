package com.wb.webbook.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQuery {

    //页码，从1开始
    private Integer pageNum;

    //页面大小
    private Integer pageSize;

    //上一页最后一个id
    private String lastId;

    //id
    private String id;
}
