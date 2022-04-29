package com.mysite.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
}
// ORM
// DB에 대한 지식 없이 자바 코드로 DB 가능하긴 한데
// 복잡한 쿼리 작성히에 오히려 더 어려워져서 선호되진 않음.

// JPA(java persistence API)
// -> ORM의 표준 인터페이스
// -> 실제 클래스로 하이버네이트 사용.

