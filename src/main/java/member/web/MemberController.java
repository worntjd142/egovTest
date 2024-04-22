package member.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
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
	@ResponseBody
	public String login(MemberVO mv, HttpSession session) throws Exception {
		
		String m =""; // 리턴할 데이터.
		
		int form = memberService.loginProc(mv);
		
		System.out.println(form);
		if(form == 3) {
			
			m = "X"; //아이디가 없음.
			
		}else if(form == 2) {
			
			m = "N"; //아이디 및 비밀번호가 틀림.
			
		}else {
			
			m = "Y"; //아이디 및 비밀번호가 맞음.
			
			session.setAttribute("id", mv.getUserid()); //아이디를 세션영역에 저장.
		}
		System.out.println(m);
		return m;
	}
	
	//로그아웃
	@RequestMapping("/logout.do")
	@ResponseBody
	public String logout (HttpSession session) {
		//session.removeAttribute("sessionId"); -- 특정값 지정해서 세션값 삭제.
		session.invalidate(); // 세션값 전체 삭제.
		return "bye"; 
	}
	
	//메인
	@RequestMapping("/main.do")
	public String main () throws Exception {
			
		return "member/main";
	}
}