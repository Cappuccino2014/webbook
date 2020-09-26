package com.wb.webbook.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ChapterQuery extends PageQuery {

    private Integer chapterNumber;
    private String chapterName;
    private String chapterContent;
    private String bookId;

}
