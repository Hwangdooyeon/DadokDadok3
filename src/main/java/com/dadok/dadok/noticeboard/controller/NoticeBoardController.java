package com.dadok.dadok.noticeboard.controller;

import com.dadok.dadok.noticeboard.entity.NoticeBoard;
import com.dadok.dadok.noticeboard.repository.NoticeBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("noticeboard")
public class NoticeBoardController {
    private final NoticeBoardRepository noticeBoardRepository;

    // index.html에 5개의 공지사항 가지고 오기
    @GetMapping("/list")
    public String list(Model model) {
        List<NoticeBoard> noticeFiveList = noticeBoardRepository.findAll();
        model.addAttribute("noticefive", noticeFiveList);
        System.out.println("------------------------------");
        System.out.println("noticeFiveList" + noticeFiveList);
        System.out.println("------------------------------");
        return "noticeboard/notice_list";
    }
    //게시글 작성
    @RequestMapping(value = "/notice_write")
    public String writeNotice() throws Exception {
        return "noticeboard/notice_write";
    }
//    @Autowired
//    private NoticeService noticeService; // NoticeService는 공지사항 데이터를 가져오는 데 사용됩니다. 실제 구현은 생략됩니다.

//    @GetMapping("/noticeboard")
//    public String showNoticeBoard(Model model) {
//        List<NoticeBoard> searchResults = noticeService.findAllNotices(); // 모든 공지사항을 가져오는 메서드, 실제 구현은 생략됩니다.
//        model.addAttribute("searchResults", searchResults); // 모델에 searchResults를 추가합니다.
//        return "noticeboard/notice_list"; // Thymeleaf 템플릿의 이름을 반환합니다. 예를 들어, "noticeboard.html"
//    }
}


