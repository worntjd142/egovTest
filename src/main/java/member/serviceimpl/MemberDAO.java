package member.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import member.service.MemberVO;

//DataBase에 접근하는 method를 가지고 있는 Class에서 쓰인다.
@Repository("memberDAO")
public class MemberDAO extends EgovAbstractDAO{

	public List<?> select_board() {
		
		return list("memberDAO.select_board");
	}

	public void insert(MemberVO vo) {
		 insert("memberDAO.insert", vo);
	}

}
