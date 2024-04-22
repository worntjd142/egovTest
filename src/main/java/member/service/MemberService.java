package member.service;

import java.util.ArrayList;
import java.util.List;

public interface MemberService {
	/* 회원등록 처리 */
	public String insertMember(MemberVO vo) throws Exception;
	
	/* 로그인 */
	public int loginProc(MemberVO vo) throws Exception;

	/* 아이디 중복체크 */
	public int selectIdChk(String userid) throws Exception;
	
	/* 가입자 확인 */
	public List<MemberVO> memberselect() throws Exception;
}
