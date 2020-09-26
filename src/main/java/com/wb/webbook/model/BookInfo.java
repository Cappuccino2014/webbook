package com.wb.webbook.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookInfo {

    private String id;
    private String bookName;
    private String cover;
    private String author;
    private String intro;
    private String categoryId;
}
