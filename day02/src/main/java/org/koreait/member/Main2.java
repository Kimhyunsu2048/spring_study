package org.koreait.member;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class, AppCtx2.class);
		
		MemberRegisterService registerService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
		Member member = new Member();
		member.setUserId("user01");
		member.setUserPw("123456");
		member.setUserNm("사용자01");
		member.setRegDt(LocalDateTime.now());
		registerService.process(member);
		
		
		MemberListService listService = ctx.getBean(MemberListService.class);
		List<Member> members = listService.gets();
		for(Member m : members) {
			System.out.println(m);
		}
		
		ctx.close();
	}	
	

}
