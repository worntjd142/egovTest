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
		
		int id_pasing = 0 ;
		
		/* 클라이언트의 아이디가 있는지 없는지 부터 확인*/
		
		int id_ch = (int) select("memberDAO.selectIdChk", vo.getUserid());  // 있으면 1, 없으면 0
		
		if(id_ch == 0) {
			
			 id_pasing = 3;
			 
		}else {
	
			
		/* 클라이언트의 아이디가 있다면 작성한 아이디와 비밀번호로 검색하여 확인 */	
			
			id_ch = (int) select("memberDAO.loginProc", vo); //아이디와 비번이 맞으면 1, 없으면 0
			
			if(id_ch == 1) {
				
				id_pasing = 1;
				
			}else {
				
				id_pasing = 2;
			}
			
			
			
		}
		
		
		return  id_pasing;
	}
	
	public int selectIdChk(String userid) {
		return (int) select("memberDAO.selectIdChk", userid);
	}

	@SuppressWarnings("unchecked")
	public List<MemberVO> memberselect() {
		    return (List<MemberVO>)list("memberDAO.memberselect");
	}
	

}
