package org.koreait.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberRegisterService {
	
	
	private MemberDao memberDao;
	
	public MemberRegisterService() {}
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void process(Member member) {
		
		memberDao.add(member);
	}
	
	@Autowired
	@Qualifier("mdao")
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
