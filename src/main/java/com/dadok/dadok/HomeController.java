package com.dadok.dadok;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
//    @GetMapping("/review-list")
//    @ResponseBody
//    public ResponseEntity<List<ReviewVO>> reviewList(ReviewVO reviewVO) {
//        return ResponseEntity.ok(mainPageService.getReviewList(reviewVO));
//    }
}
