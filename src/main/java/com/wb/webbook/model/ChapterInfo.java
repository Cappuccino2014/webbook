package com.wb.webbook.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ChapterInfo {

    private Integer chapterNumber;
    private String chapterName;
    private String chapterContent;
    private String bookId;
    private String id;

}
