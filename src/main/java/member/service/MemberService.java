package member.service;

import java.util.List;

public interface MemberService {
	/*회원등록처리*/
	public String insertMember(MemberVO vo) throws Exception;
	/*아이디 중복 검사*/
	public String memberIdChk(MemberVO vo) throws Exception;
	
	public int loginProc(MemberVO vo) throws Exception;
	
	public int idlogin(String string) throws Exception;
	
	public List<?> selectMemberList();
}
