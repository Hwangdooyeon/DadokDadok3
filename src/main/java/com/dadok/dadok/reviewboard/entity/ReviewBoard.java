package com.dadok.dadok.reviewboard.entity;

import com.dadok.dadok.freeboard.dto.FreeBoardAttachDTO;
import com.dadok.dadok.freeboard.vo.FreeBoardAttachVO;
//import com.dadok.dadok.reviewboard.vo.ReviewAttachVO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Entity
@DynamicUpdate
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")
public class ReviewBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int review_id;
    private int member_id;

    private String book_isbn;

    private String review_title;
    private String review_content;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "review_createdAt")
    private Date reviewCreatedAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date review_updatedAt;
    private int review_views;

    private String keyword;

    private int searchCount;

    private String search;
    private int start;
    private int end;
    private int page;

//    private ReviewAttachVO review_attach;

    private String nickname;

}

