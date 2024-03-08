package com.dadok.dadok;

import com.dadok.dadok.noticeboard.entity.NoticeBoard;
import com.dadok.dadok.noticeboard.repository.NoticeBoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DadokApplicationTests {
	@Autowired
	private NoticeBoardRepository noticeBoardRepository;


	@Test
	void contextLoads() {


	}

	@Test
	@DisplayName("공지게시판 리스트 5개 불러오기")
	@Transactional
	void 공지게시판리스트5개불러오기() {
		System.out.println("------------------");
		List<NoticeBoard> notices = noticeBoardRepository.findTop5ByOrderByNotcCreatedAtDesc();
		for (int i = 0; i < notices.size(); i++) {
			NoticeBoard notice = notices.get(i);
			System.out.println(notice);

			System.out.println("------------------");


		}
	}
	@Test
	@DisplayName("공지게시판 리스트 5개 불러오기")
	@Transactional // 테스트 종료 후 롤백
	void 공지게시판insert테스트() {
		System.out.println("------------------");
		NoticeBoard notice = new NoticeBoard();
		notice.setNotc_title("공지공지");
		notice.setNotc_content("중요한내용");

		NoticeBoard savedNotice = noticeBoardRepository.save(notice);

		// 데이터베이스에서 방금 저장한 데이터를 조회
		Optional<NoticeBoard> foundNotice = noticeBoardRepository.findById(savedNotice.getId());
		if (foundNotice.isPresent()) {
			System.out.println("데이터베이스에 추가된 데이터: " + foundNotice.get());
		} else {
			System.out.println("데이터를 찾을 수 없습니다.");
		}

		System.out.println("------------------");
	}
	}

