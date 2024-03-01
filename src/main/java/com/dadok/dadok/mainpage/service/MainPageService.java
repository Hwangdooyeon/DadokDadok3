package com.dadok.dadok.mainpage.service;

import com.dadok.dadok.freeboard.entity.FreeBoard;
import com.dadok.dadok.reviewboard.entity.ReviewBoard;

import java.util.List;

public interface MainPageService {
    List<FreeBoard> findFreeBoardList();
    FreeBoard getFreeBoard();
    void join(FreeBoard freeBoard);

    List<ReviewBoard> findReviewBoardList();
    
}

//tob bar 주석처리
//header 주석처리
//296 303번째 foreach 주석처리
//314 323번째 foreach 주석처리