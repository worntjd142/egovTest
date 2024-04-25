package member.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.service.MemberService;
import member.service.MemberVO;

//service 어노테이션 비즈니스 로직을 수행하는 Class라는 것을 나타내는 용도
@Service("memberService")
public class MemberServiceimpl implements MemberService {
	
	@Autowired
	MemberDAO memberdao;
	
	public List<?> select_board(){
		
		return memberdao.select_board();
		
	}
	
	public void insert(MemberVO vo) {
		
		 memberdao.insert(vo);
		
	}
	


}
