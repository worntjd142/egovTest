package member.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import member.service.MemberVO;

//DataBase에 접근하는 method를 가지고 있는 Class에서 쓰인다.
@Repository("memberDAO")
public class MemberDAO extends EgovAbstractDAO{

	public String insertMember(MemberVO vo) {
		return (String) insert("memberDAO.insertMember", vo);
	}
	
	public String memberIdChk(MemberVO co) {
		System.out.println("다오" + co); 
		String userid = co.getUserid();
		return (String)select("memberDAO.memberIdChk", userid);
	}
	
	public int loginProc(MemberVO vo) {
		return (int) select("memberDAO.loginProc", vo);
	}
	
	public int idlogin(String string) {
		return (int) select("memberDAO.idlogin", string);
	}
	
	public List<?> selectMemberList() {
		return list("memberDAO.selectMemberList");
	}		
}
