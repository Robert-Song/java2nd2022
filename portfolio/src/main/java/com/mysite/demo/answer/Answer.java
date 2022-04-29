package com.mysite.demo.answer;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mysite.demo.question.Question;
import com.mysite.demo.user.SiteUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="answer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
	@Id//해당 속성을 기본키로 지정할 떄 사용
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//generatedValue = 값을 세팅하지 않아도 1씩 자동으로 증가.
	//GenerationType.IDENTITY = 해당 컬럼만의 독립적인 시퀀스 생성.
	//			(새로운 컬럼이면 다시 1부터 시작)
	
	@Column(columnDefinition = "TEXT")//글자제한X
	private String content;
	
	private LocalDateTime createDate;
	@ManyToOne // 외래키 생성. 질문에 대한 답이 여러개일 수 있으므로 ManyToOne으로 생성.
			   // Question에서 생성했더라면 OneToMany로 함.
	private Question question;
	
	@ManyToOne
	private SiteUser author;
	
	private LocalDateTime modifyDate;
	
	@ManyToMany
	Set<SiteUser> voter;
}
