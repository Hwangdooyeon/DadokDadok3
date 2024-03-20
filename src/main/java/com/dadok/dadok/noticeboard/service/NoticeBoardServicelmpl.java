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
    @Transactional
    public NoticeBoard insertNotice(NoticeBoard noticeBoard) {
        return noticeBoardRepository.save(noticeBoard);
    }
    @Transactional
    public NoticeBoard updateNotice(Long id, NoticeBoard noticeBoardDetails) {
        NoticeBoard noticeBoard = noticeBoardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));

        // 필요한 필드를 여기서 업데이트. 예를 들어, title 필드를 업데이트 한다면
         noticeBoard.setNotc_title(noticeBoardDetails.getNotc_title());
         noticeBoard.setNotc_content(noticeBoardDetails.getNotc_content());
        return noticeBoardRepository.save(noticeBoard);
    }
    @Override
    public List<NoticeBoard> searchNoticeBoardsByTitle(String keyword) {
        return noticeBoardRepository.findByTitleContaining(keyword);
    }

}
