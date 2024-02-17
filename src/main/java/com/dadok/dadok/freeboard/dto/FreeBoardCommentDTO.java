package com.dadok.dadok.freeboard.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class FreeBoardCommentDTO {
  private int bocm_id; // 댓글번호
  private int board_id; // 게시글 번호
  private String cm_content; // 댓글내용
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date cm_createdAt; // 댓글등록일
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date cm_modifiedAt; // 댓글수정일
  private String nickname; // 닉네임
  private int cm_class; // 계층 - 원댓글(부모):0, 대댓글(자식): 1
  private int cm_group; // 그룹
  private int member_id; // 회원번호


}
