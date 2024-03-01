package com.dadok.dadok.noticeboard.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Entity
@Table(name="noticeboard",
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
public class NoticeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int notc_id; // 글번호
    private int notc_views; // 조회수
    private String notc_title; // 글제목
    private String notc_content; // 글내용
    private Date notc_updatedAt = new Date();

    private Date notc_createdAt = new Date();

    @Column(unique = true)
    private String notice_uuid; // 첨부파일uuid
    private String notice_file_name; // 첨부파일명
    private boolean pinned; // 고정글여부

}

