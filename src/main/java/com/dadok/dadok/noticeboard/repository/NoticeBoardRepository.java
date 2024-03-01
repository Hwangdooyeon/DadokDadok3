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

    List<NoticeBoard> findTop5ByNotcCreatedAtDesc();


    // 공지 게시판 글쓰기

    @Modifying
    @Query(value = "INSERT INTO notice (notc_title, notc_content, notc_createdAt, notc_updatedAt, notc_views, notice_uuid, notice_file_name, pinned) " +
            "VALUES (:notcTitle, :notcContent, :notcCreatedAt, :notcUpdatedAt, :notcViews, :noticeUuid, :noticeFileName, :pinned)",
            nativeQuery = true)
    void insertNotice(@Param("notcTitle") String notcTitle, @Param("notcContent") String notcContent,
                      @Param("notcCreatedAt") LocalDateTime notcCreatedAt, @Param("notcUpdatedAt") LocalDateTime notcUpdatedAt,
                      @Param("notcViews") Integer notcViews, @Param("noticeUuid") String noticeUuid,
                      @Param("noticeFileName") String noticeFileName, @Param("pinned") Boolean pinned);

    // 공지 게시판 글 수정하기

    @Modifying
    @Query("UPDATE NoticeBoard n SET " +
            "n.notcTitle = :notcTitle, " +
            "n.notcContent = :notcContent, " +
            "n.notcUpdatedAt = :notcUpdatedAt, " +
            "n.noticeUuid = :noticeUuid, " +
            "n.noticeFileName = :noticeFileName, " +
            "n.pinned = :pinned " +
            "WHERE n.id = :id")
    void updateNotice(@Param("notcTitle") String notcTitle,
                      @Param("notcContent") String notcContent,
                      @Param("notcUpdatedAt") LocalDateTime notcUpdatedAt,
                      @Param("noticeUuid") String noticeUuid,
                      @Param("noticeFileName") String noticeFileName,
                      @Param("pinned") Boolean pinned,
                      @Param("id") Long id);


    // 공지 게시판 조회수 +1

    @Modifying
    @Query("UPDATE NoticeBoard n SET n.notcViews = n.notcViews + 1 WHERE n.id = :id")
    void updateViewCountNotice(@Param("id") Long id);


}

