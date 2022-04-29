package com.mysite.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.demo.question.Question;
import com.mysite.demo.question.QuestionRepository;
import com.mysite.demo.question.QuestionService;

@SpringBootTest
class PortfolioApplicationTests {
	
	@Autowired //객체주입 annotation
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionService questionService;
	
	@Test
	void contextLoads() {
	}
		
	@Test
	void testJpa() {
//		Question q1 = new Question();
//		q1.setSubject("How to design DB?");
//		q1.setContent("How to design columns for tables in DB?");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);
//		
//		Question q2 = new Question();
//		q2.setSubject("When will this class end?");
//		q2.setContent("Just asking, no offense.");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
		
//		//데이터 조회
//		List<Question> searchQuestion = this.questionRepository.findAll();
//		//assertEquals(기대값, 실제값) : 기대값이 실제값과 동일한지 체크.
//		//만약 결과가 false라면 조회안됨.
//		assertEquals(2, searchQuestion.size());
//		
//		Question q = searchQuestion.get(0);
//		assertEquals("How to design DB?", q.getSubject());
//		
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("How to design DB?", q.getSubject());
//		}
		
		//update 테이블명
		//set 컬럼명 = 바꿀값
		//where 컬럼명 = 기준값
		
		//이게 where id=1이랑 비슷하다고 보면 됨.
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("Title update test!");
//		q.setContent("Content update test!");
//		this.questionRepository.save(q);
		
		//과제
		//답변 테이블에 데이터 저장
		//content : 과제 완성
		//Question : question객체 불러와서 어떤 질문의 답변인지 확인해야함.
		//create_date : 현재시간.
		
		for(int i=1; i<=200; i++) {
			String subject = String.format("테스트데이터:[%03d]", i);
			String content = "그런거 없다 ㅋㅋ";
			this.questionService.create(subject, content, null);
		}
	}

	
}
