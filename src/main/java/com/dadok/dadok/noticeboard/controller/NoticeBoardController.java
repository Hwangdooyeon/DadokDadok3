package com.dadok.dadok.noticeboard.controller;

import com.dadok.dadok.noticeboard.entity.NoticeBoard;
import com.dadok.dadok.noticeboard.repository.NoticeBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("noticeboard")
public class NoticeBoardController {
    private final NoticeBoardRepository noticeBoardRepository;


    @GetMapping("/list")
    public String list(Model model) {
        List<NoticeBoard> noticeFiveList = noticeBoardRepository.findTop5ByNotcCreatedAtDesc();
        model.addAttribute("noticefive", noticeFiveList);
        return "index";
    }

}
