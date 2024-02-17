package com.dadok.dadok.freeboard.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
@Slf4j

@Getter
@Setter
public class FreeBoardPageDTO {
  private int start; // 페이지 시작번호
  private int end; // 페이지 끝번호
  private int page; // 현재 페이지번호
  private int pageSize = 10; // 한 페이지에서 보여줄 게시글 수
  private int maxPage; // 총 페이지 갯수

  private String searchType; // 검색 타입
  private String keyword; // 검색 키워드

  public void setStartEnd() {
    start = 1 + (page - 1) * pageSize;
    end = page * pageSize;
    //start = 1
    //end = 1 * 10
  }

}
