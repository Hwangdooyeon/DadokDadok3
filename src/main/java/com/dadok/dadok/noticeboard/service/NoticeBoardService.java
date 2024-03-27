package com.dadok.dadok.noticeboard.service;

import com.dadok.dadok.noticeboard.entity.NoticeBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;



public interface NoticeBoardService  {
    List<NoticeBoard> findFiveNoticeBoard();
    
    //검색 기능
//    List<NoticeBoard> searchNoticeBoardsByTitle(String keyword);
    Page<NoticeBoard> searchNoticeBoardsByTitle(String keyword, Pageable pageable);

//    Page<NoticeBoard> searchNoticeBoardsByContent(String content, Pageable pageable);

//    Page<NoticeBoard> searchByKeyword(String type, String keyword, Pageable pageable);
}


