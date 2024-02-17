package com.dadok.dadok.freeboard.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class FreeBoardDTO {
  private int board_id;
  private int member_id;
  private Date board_createdAt;
  private Date board_updatedAt;
  private String board_writer;
  private int board_views;
  private String board_title;
  private String board_content;
  private int free_board_no;
  private String nickname;
  private List<FreeBoardAttachDTO> attachList;


}
