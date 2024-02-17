package com.dadok.dadok.freeboard.dao;

//import com.dadok.dadok.freeboard.vo.FreeBoardPageVO;
//import com.dadok.dadok.freeboard.vo.FreeBoardVO;
//import com.dadok.dadok.freeboard.dto.FreeBoardAttachDTO;
//import com.dadok.dadok.freeboard.dto.FreeBoardCommentDTO;
//import com.dadok.dadok.freeboard.dto.FreeBoardPageDTO;
//import com.dadok.dadok.freeboard.dto.FreeBoardDTO;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//@Repository
//@Slf4j
//public class FreeBoardDAO {
//  // 연동처리하는 파일 <-> FreeBoardSQL.xml
//
//  @Autowired
//  SqlSessionTemplate sqlSession;
//
//  // 자유게시판 게시글 작성
//  public int freeBoardInsert(FreeBoardDTO freeBoardDTO){
//    return sqlSession.insert("freeBoardInsert", freeBoardDTO);
//  }
//
//  // 자유게시판 게시글 목록 조회
//  public List<FreeBoardVO> getFreeBoardList(FreeBoardDTO freeBoardDTO){
//    return sqlSession.selectList("freeBoardList", freeboardPageVO);
//  }
//
//  // 자유게시판 게시글 총 개수 구하기
//  public int freeBoardCount(FreeBoardPageVO freeboardPageVO){
//    return sqlSession.selectOne("freeBoardCount", freeboardPageVO);
//  }
//
//  //자유게시판  게시글 상세 보기
//  public FreeBoardVO freeBoardOne(int board_id) {
//    return sqlSession.selectOne("freeBoardOne", board_id);
//  }
//
//  // 자유게시판 게시글 클릭시 조회수 증가
//  public void freeBoardViewsCount(FreeBoardVO freeBoardVO) {
//    sqlSession.update("freeBoardViewsCount", freeBoardVO);
//  }
//
//  // 자유게시판 상세보기페이지에서 이전글 찾기
//  public FreeBoardVO getPreviousPost(int board_id) {
//    return sqlSession.selectOne("getPreviousPost", board_id);
//  }
//
//  // 자유게시판 상세보기페이지에서 다음글 찾기
//  public FreeBoardVO getNextPost(int board_id) {
//    return sqlSession.selectOne("getNextPost", board_id);
//  }
//
//  // 자유게시판  게시글 수정
//  public void freeBoardUpdate(FreeBoardVO freeBoardVO) {
//    sqlSession.update("freeBoardUpdate", freeBoardVO);
//  }
//
//  // 자유게시판 게시글만 삭제
//  public void freeBoardDelete(int board_id) {
//    sqlSession.delete("freeBoardDelete", board_id);
//  }
//
//  // 자유게시판 댓글 저장
//  public void freeBoardCommentInsert(FreeBoardCommentVO freeBoardCommentVO) {
//    sqlSession.insert("freeBoardCommentInsert", freeBoardCommentVO);
//  }
//
//  // 자유게시판 댓글리스트 가져오기
//  public List<FreeBoardCommentVO>freeBoardCommentList (int board_id) {
//    return sqlSession.selectList("freeBoardCommentList", board_id);
//  }
//
//  // 자유게시판 댓글 수정
//  public int freeBoardCommentUpdate(FreeBoardCommentVO freeBoardCommentVO) {
//    return sqlSession.update("freeBoardCommentUpdate",freeBoardCommentVO);
//  }
//
//  // 자유게시판 댓글 삭제
//  public int freeBoardCommentDelete(int  bocm_id) {
//    return sqlSession.update("freeBoardCommentDelete",bocm_id);
//  }
//
//  // 자유게시판 대댓글 입력
//  public void freeBoardCommentReply(FreeBoardCommentVO freeBoardCommentVO) {
//    sqlSession.insert("freeBoardCommentReply", freeBoardCommentVO);
//  }
//
//
//  // 자유게시판  파일업로드시 s3 이용
//  public void freeBoardFileS3Insert(FreeBoardAttachDTO freeBoardAttachVO) {
//    sqlSession.insert("freeBoardS3Insert", freeBoardAttachVO);
//  }
//
//  // 자유게시판 글 상세보기 - s3에 있는 파일정보 DB에서 찾기
//  public List<FreeBoardAttachVO> findByS3FileInfo(int board_id){
//    return sqlSession.selectList("freeBoardS3Find", board_id);
//  }
//
//  // 자유게시판 첨부파일 정보 삭제
//  public int deleteFreeBoardFileInfo(int board_id) {
//    return sqlSession.delete("freeBoardS3InfoDelete", board_id);
//  }
//  public List<FreeBoardVO> freeBoardListFive(FreeBoardVO freeBoardVO) {
//    return sqlSession.selectList("freeBoardListFive", freeBoardVO);
//  }
//}

