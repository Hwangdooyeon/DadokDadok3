package com.dadok.dadok.reviewboard.repository;

import com.dadok.dadok.freeboard.entity.FreeBoard;
import com.dadok.dadok.freeboard.vo.FreeBoardVO;
import com.dadok.dadok.reviewboard.entity.ReviewBoard;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ReviewBoardRepository extends JpaRepository<ReviewBoard, Long> {

    //entity = table 에서 값을 가져오는 목적
    //DTO = 통신을 위한 객체 service, service = 화면
    //JPA로 구현

   List<ReviewBoard> findTop15ByOrderByReviewCreatedAtDesc();

//    SELECT m FROM table m ORDER BY column DESC LIMIT 10



    //후기 게시판 작성

        @Modifying
        @Query(value = "INSERT INTO review (member_id, book_isbn, review_title, review_content, review_createdAt, review_updatedAt, review_views) " +
                "VALUES (:memberId, :bookIsbn, :reviewTitle, :reviewContent, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0)",
                nativeQuery = true)
        @Transactional
        void insertReview(@Param("memberId") Long memberId, @Param("bookIsbn") String bookIsbn, @Param("reviewTitle") String reviewTitle,
                          @Param("reviewContent") String reviewContent);

//    INSERT INTO review (
//            member_id,
//            book_isbn,
//            review_title,
//            review_content,
//            review_createdAt,
//            review_updatedAt,
//            review_views)
//    VALUES (
//
//				   #{member_id},
//            #{book_isbn},
//            #{review_title},
//            #{review_content},
//    DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i:%s'),
//    DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i:%s'),
//            0);

    // 후기 게시판 업데이트

    @Modifying
    @Query("UPDATE Review r SET r.reviewTitle = :reviewTitle, r.reviewContent = :reviewContent WHERE r.reviewId = :reviewId")
    @Transactional
    void updateReview(@Param("reviewTitle") String reviewTitle, @Param("reviewContent") String reviewContent, @Param("reviewId") Long reviewId);

//    	<update id="reviewUpdate" parameterType="reviewVO">
//    update review set review_title
//		= #{review_title}, review_content = #{review_content} where review_id
//		= #{review_id}
//	</update>

    // 후기 게시판 삭제하기

    @Modifying
    @Query("DELETE FROM Review r WHERE r.reviewId = :reviewId")
    @Transactional
    void deleteReview(@Param("reviewId") int reviewId);

//    	<delete id="reviewDelete" parameterType="int">
//    delete from review where review_id = #{review_id}
//	    </delete>

    // 후기 게시판 상세 페이지

    @Query("SELECT r FROM Review r WHERE r.reviewId = :reviewId")
        ReviewBoard getReviewOne(@Param("reviewId") Long reviewId);

//    	<select id="getReviewOne" parameterType="reviewVO" resultType="reviewVO">
//           select * from review where review_id = #{review_id}
//	    </select>

    // 후기 게시판 게시물 수

    @Query("SELECT COUNT(r) FROM Review r")
    int getReviewCount();

//    	<select id="reviewCount" resultType="int"> <!-- ==> PAGEDAO랑 연결됨 -->
//          select count(*) from review
//	    </select>

    // 후기 게시판 검색 키워드를 포함하는 리스트 게시물 수

    @Query("SELECT COUNT(r) FROM Review r WHERE (:keyword IS NULL OR r.reviewTitle LIKE CONCAT('%', :keyword, '%'))")
    int getSearchCount(@Param("keyword") String keyword);

//    	<select id="searchCount"  parameterType="reviewVO" resultType="int"> <!-- ==> PAGEDAO랑 연결됨 -->
//    select count(*) from review
//		<if test="keyword != null">
//    WHERE review_title LIKE CONCAT('%', #{keyword}, '%')
//		</if>
//	    </select>

    //후기 게시판 페이징 처리 + 리스트 보여주기

    @Query("SELECT r FROM Review r ORDER BY r.reviewId DESC")
    List<ReviewBoard> getReviewList(Pageable pageable);

//    <select id="reviewList" parameterType="pageVO2" resultType="reviewVO">
//    select *
//    from
//            (select
//            ROW_NUMBER() over(order by review_id desc) as review_no, review_id,
//            member_id, review_title, review_content, review_createdAt,review_updatedAt,
//            review_views
//    from review r) r2
//    where r2.review_no BETWEEN #{start} and #{end}
//
//	</select>

    // isbn 기반 도서후기 리스트



        @Query("SELECT r FROM Review r WHERE r.book.isbn = :isbn ORDER BY r.reviewUpdatedAt DESC")
        Page<ReviewBoard> getReviewListByIsbn(@Param("isbn") String isbn, Pageable pageable);



//    	<select id="reviewListByIsbn" resultType="reviewVO">
//    select *
//    from review
//    where book_isbn = #{isbn} -- ISBN에 맞는 리뷰만 필터링
//    order by review_updatedAt desc
//    limit 10
//	</select>

    // 후기 게시판 검색 기능

    @Query("SELECT r FROM Review r WHERE r.reviewTitle LIKE CONCAT('%', :keyword, '%') ORDER BY r.reviewId DESC")
    List<ReviewBoard> searchReviewsByTitle(@Param("keyword") String keyword);

//    	<select id="reviewSearch" parameterType="pageVO2" resultType="reviewVO">
//
//    select *
//    from
//            (select
//                     ROW_NUMBER() over(order by review_id desc) as review_no, review_id,
//            member_id, review_title, review_content, review_createdAt,review_updatedAt,
//            review_views
//    from review r
//    WHERE review_title LIKE CONCAT('%', #{keyword},'%')
//            ) r2
//    where r2.review_no BETWEEN #{start} and #{end}
//
//	</select>

    // 후기 게시판 게시물 조회수 증가

    @Modifying
    @Query("update ReviewBoard r set r.reviewViews = r.reviewViews + 1 where r.id = :reviewId")
    void increaseViews(@Param("reviewId") Long reviewId);

    // 후기 게시판 상세페이지 조회수 증가

    @Query("SELECT r.reviewViews FROM Review r WHERE r.reviewId = :reviewId")
    Integer getReviewViews(@Param("reviewId") Long reviewId);


   // 첨부파일을 받아오는 쿼리문 추후에 질문
//    	<insert id="attachInsert" parameterType="reviewattachVO">
//
//    INSERT INTO review_attach
//            (review_id,
//             review_uuid, review_file_name, review_file_type)
//    VALUES
//            (#{review_id}, #{review_uuid},
//            #{review_file_name},#{review_file_type})
//
//	</insert>

//    // 후기 게시판 첨부파일 삭제 기능 추후에 질문
//
//    @Transactional
//    @Modifying
//    @Query("DELETE FROM ReviewAttach ra WHERE ra.reviewId = :reviewId")
//    void deleteByReviewId(@Param("reviewId") Long reviewId);
}

