package com.wb.webbook.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BookQuery extends PageQuery {

    private String bookName;
    private String cover;
    private String author;
    private String intro;
    private String categoryId;
}
