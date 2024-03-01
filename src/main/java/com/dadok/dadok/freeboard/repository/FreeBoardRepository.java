//package com.dadok.dadok.freeboard.repository;
//
//import com.dadok.dadok.freeboard.entity.FreeBoard;
//import com.dadok.dadok.freeboard.vo.FreeBoardVO;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {
//
//    //entity = table 에서 값을 가져오는 목적
//    //DTO = 통신을 위한 객체 service, service = 화면
//    List<FreeBoard>  findTop15ByOrderByReviewCreatedAtDesc();
//
//     join문이 붙어 있어서 쿼리를 어떻게 짜야할지 고민
//}
