package org.koreait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.koreait.member.Member;
import org.koreait.member.MemberRegisterService;

class MemberTest {

	@DisplayName("회원 가입 테스트")
	@Test
	public void memberRegisterTest() {
		MemberRegisterService service = new MemberRegisterService();
		/**
		 * 1. 회원 가입을 성공하면 true값 반환
		 * 2. 가입하는 회원 DTO 객체가 빈값이면 -> RuntimeException
		 */
		Member member = new Member();
		boolean result = service.join(member);
		
		assertEquals(result, true);
		
		assertThrows(RuntimeException.class, () -> {
			service.join(null);				
		});
		
	}

}
