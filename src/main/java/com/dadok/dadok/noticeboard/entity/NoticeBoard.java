package com.dadok.dadok.noticeboard.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="notice",
        uniqueConstraints = {@UniqueConstraint(
                name = "unique",
                columnNames = {"notc_id","notice_uuid"} )
        })
@DynamicUpdate
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoticeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false, unique = true)
//
////    private int notc_id; // 글번호
    private int notc_views; // 조회수
    @Column(name = "notc_title",nullable = false)
    private String notcTitle; // 글제목

    @Column(nullable = false)
    private String notc_content; // 글내용

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime notcUpdatedAt = LocalDateTime.now(); // 수정된 부분

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime notcCreatedAt = LocalDateTime.now(); // 수정된 부분


    @Column(unique = true)
    private String notice_uuid; // 첨부파일uuid
    private String notice_file_name; // 첨부파일명
    private boolean pinned; // 고정글여부

}

