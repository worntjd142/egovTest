package member.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import member.service.MemberService;
import member.service.MemberVO;


//어노테이션 : 자동으로 빈에 등록됨.
@Controller
public class MemberController {
	// memberService 사용하겠다.
	@Resource(name = "memberService")
	public MemberService memberService;
	
	/* 회원등록 페이지 호출 */
	@RequestMapping ("memberWrite.do")
	public String memberWrite() {
		return "member/memberWrite";
	}
	
	@RequestMapping ("memberWriteSave.do")
	@ResponseBody
	public String memberWriteSave(MemberVO vo) throws Exception {
		// 저장을 하고 나서 저장이 됐다는 걸 확인하기 위해서
		// 메세지 전송 할 수 있음
		String message = "";
		
		String result = memberService.insertMember(vo);
		
			if (result == null) {
				message = "ok";
			}
		
		return message;
	}
	
	/* 아이디 중복체크 */
	@RequestMapping ("userid_Chk.do")
	@ResponseBody
	public String userid_Chk (String userid) throws Exception {
				
		String message;
		
		int result = memberService.selectIdChk(userid);
		System.out.println("아이디: " + userid);
		System.out.println("result값: " +result);
		
			if (result == 0) {
				message = "Y";
			} else {
				message = "X";
			}
		return message;
	}
	
	/* 로그인 페이지 호출 */
	@RequestMapping ("/login.do")
	public String login() {
		return "member/login";
	}
	
	/*로그인 PROC 실행화면 */
	@RequestMapping("/loginProc.do")
	@ResponseBody //세션을 만들어주는 클래스
	public String loginProc (MemberVO vo, HttpSession session) throws Exception{
		System.out.println(vo);
		String message = "";
		
		int cnt = memberService.selectIdChk(vo.getUserid());
		System.out.println("cnt : " +cnt);
		
		if(cnt == 0 ) {//아이디가 없습니다.
			message = "x";
		} else {//성공 
			int cnt2 = memberService.loginProc(vo);
			System.out.println("cnt2 : "+  cnt2);
			
			if(cnt2 == 0) { //패스워드가 틀려요
				message = "wrong password";
			} else {
				//session 생성
				session.setAttribute("sessionId", vo.getUserid());
				message = "ok";
			}
		}
		return message;
	}
	
	/* 
	 * 로그아웃 
	 */
	@RequestMapping("/logout.do")
	public String logout (HttpSession session) {
		session.removeAttribute("sessionId");
		return "member/main";
	}
	
	/* 
	 * 메인
	 */
	@RequestMapping("/main.do")
	public String main (HttpSession session, Model model, String userid) throws Exception {
		
		System.out.println("데이터 찾는 중");
		
		List<MemberVO> DATA = memberService.memberselect() ;
		
		System.out.println("형태 알기" + DATA);
		
		model.addAttribute("data", DATA);
	
		return "member/main";
	}
}