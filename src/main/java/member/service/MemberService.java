package member.service;

import java.util.List;

public interface MemberService {

	public List<?> select_board();

	public void insert(MemberVO vo);
}
