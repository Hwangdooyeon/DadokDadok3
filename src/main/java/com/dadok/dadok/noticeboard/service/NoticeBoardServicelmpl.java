package com.dadok.dadok.noticeboard.service;

import com.dadok.dadok.noticeboard.entity.NoticeBoard;
import com.dadok.dadok.noticeboard.repository.NoticeBoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // 클래스안에 final 정의된 객체에 대해 자동으로 di를 해주는 기능
public class NoticeBoardServicelmpl implements NoticeBoardService {
    private final NoticeBoardRepository noticeBoardRepository;

    @Override
    public List<NoticeBoard> findFiveNoticeBoard() {
//        return noticeBoardRepository.findTop5ByNotcCreatedAtDesc()
        return noticeBoardRepository.findAll();
    }

    // 공지 게시판 NoticeBoardRepository 에 추가해줄 필요가 없음 service에만 추가해주면 됨

    @Transactional
    public void deleteNotice(Long id) {
        noticeBoardRepository.deleteById(id);
    }
}
