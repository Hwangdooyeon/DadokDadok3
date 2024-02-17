package com.dadok.dadok.freeboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FreeBoardAttachDTO {
  private int board_attach_id; // 첨부파일번호
  private int board_id; // 자유게시판 번호
  private String board_uuid; // uuid
  private String board_file_name; // 파일이름
  private String board_file_type; // 파일타입



}
