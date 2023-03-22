package org.koreait.member;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

public class MemberListService {
	
	@Autowired
	@Qualifier("mdao")
	private Optional<MemberDao> opt;
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
	
	public MemberListService() {}
	
	public MemberListService(MemberDao memberDao) {
		//this.memberDao = memberDao;
	}
	
	public List<Member> gets() {
		MemberDao memberDao = opt.get();
		List<Member> members = memberDao.getMembers();
		for (Member member : members) {
			if (formatter == null) {
				member.setRegDtStr(member.getRegDt().toString());
			} else {
				member.setRegDtStr(formatter.format(member.getRegDt()));
			}
		}
		
		return members;
	}
	
	//@Autowired(required=false)
	@Autowired
	public void setDateTimeFormatter(@Nullable DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

}
