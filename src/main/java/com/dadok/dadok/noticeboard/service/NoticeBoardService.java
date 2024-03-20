package com.dadok.dadok.noticeboard.service;

import com.dadok.dadok.noticeboard.entity.NoticeBoard;

import java.util.List;



public interface NoticeBoardService  {
    List<NoticeBoard> findFiveNoticeBoard();
    
    //검색 기능
    List<NoticeBoard> searchNoticeBoardsByTitle(String keyword);

}


