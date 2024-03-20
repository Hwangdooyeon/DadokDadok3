package com.dadok.dadok.noticeboard.repository;

import com.dadok.dadok.noticeboard.entity.NoticeBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {

//
//      <select id="noticeBoardListFive" resultType="noticeBoardVO">
//    select *
//    from notice
//    order by notc_createdAt desc limit 5;
//    </select>

    List<NoticeBoard> findTop5ByOrderByNotcCreatedAtDesc();

    // 검색 기능
    List<NoticeBoard> findByTitleContaining(String keyword);

}

