package org.koreait.member2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // MemberRegisterService -> memberRegisterService(빈이름)
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
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
