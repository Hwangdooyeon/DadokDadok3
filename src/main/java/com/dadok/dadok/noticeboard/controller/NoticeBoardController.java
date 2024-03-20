package com.dadok.dadok.noticeboard.controller;

import com.dadok.dadok.noticeboard.entity.NoticeBoard;
import com.dadok.dadok.noticeboard.repository.NoticeBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


        System.out.println("noticeFiveList" + noticeFiveList);


        return "noticeboard/notice_list";
    }

    @ResponseBody //데이터 그 자체를 return함 //단골질문!
    @PostMapping(value = "/list")
    public ResponseEntity<List<NoticeBoard>> noticeSearch(@RequestParam(required = false) String keyword) throws Exception {
        List<NoticeBoard> noticeBoards;
        if (keyword != null && !keyword.isEmpty()) {
            // 키워드를 포함하는 공지사항 검색
            noticeBoards = noticeBoardRepository.findByTitleContaining(keyword);
            System.out.println("----------------------------");
        } else {
            // 키워드가 제공되지 않았을 경우, 최근 공지사항 5개 반환
            noticeBoards = noticeBoardRepository.findTop5ByOrderByNotcCreatedAtDesc();
            System.out.println("333333333333333333333333333");
        }
        System.out.println("keyword"+ keyword);
        return new ResponseEntity<>(noticeBoards, HttpStatus.OK);
    }


//    @ResponseBody //데이터 그 자체를 return함 //단골질문!
//    @PostMapping(value = "/list")// url이 숨겨저서 나옴
//    public ResponseEntity<List<NoticeBoard>> noticeSearch(String keyword) throws Exception {
//        return new ResponseEntity<>(noticeBoardRepository.findTop5ByOrderByNotcCreatedAtDesc(), HttpStatus.OK);
//    }


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


