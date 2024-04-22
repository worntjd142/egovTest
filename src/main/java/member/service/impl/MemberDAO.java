package member.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import member.service.MemberVO;

// 데이터베이스에 접근하는 메소드를 가지고 있는 Class에 사용
@Repository("memberDAO")
						// extends EgovAbstractDAO : 전자정부프레임워크를 사용하려면 상속처리해야함
public class MemberDAO extends EgovAbstractDAO {

	
	public String insertMember(MemberVO vo) {
		return (String) insert("memberDAO.insertMember", vo);
	}

	public int loginProc(MemberVO vo) {
		return (int) select("memberDAO.loginProc", vo);
	}
	
	public int selectIdChk(String userid) {
		System.out.println((int) select("memberDAO.selectIdChk", userid));
		return (int) select("memberDAO.selectIdChk", userid);
	}

	@SuppressWarnings("unchecked")
	public List<MemberVO> memberselect() {
		    return (List<MemberVO>)list("memberDAO.memberselect");
	}
	

}
