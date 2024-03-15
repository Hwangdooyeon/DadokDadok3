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

	void 공지게시판insert테스트() {
		System.out.println("------------------");
		NoticeBoard notice = new NoticeBoard();
		notice.setNotc_title("공지공지");
		notice.setNotc_content("중요한내용");


		noticeBoardRepository.save(notice);

			System.out.println("------------------");


		}
	}

