package member.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import member.service.MemberService;
import member.service.MemberVO;

//service 어노테이션 비즈니스 로직을 수행하는 Class라는 것을 나타내는 용도
@Service("memberService")
public class MemberServiceimpl implements MemberService {
	@Resource(name="memberDAO")
	public MemberDAO memberDAO;
	
	@Override
	public String insertMember(MemberVO vo) throws Exception {
		return memberDAO.insertMember(vo);
	}
	
	@Override
	public String memberIdChk(MemberVO co) throws Exception {
		return memberDAO.memberIdChk(co);
	}
	@Override
	public int loginProc(MemberVO vo) throws Exception {
		return memberDAO.loginProc(vo);
	}
	@Override
	public int idlogin(String string) throws Exception {
		return memberDAO.idlogin(string);
	}
	@Override
	public List<?> selectMemberList() {
		return memberDAO.selectMemberList();
	}


}
