package member.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import member.service.MemberService;
import member.service.MemberVO;

@Controller
public class MemberController {

	/* memberService 사용하겟다~ */
	@Resource(name = "memberService")
	public MemberService memberService;
	
	@RequestMapping("main.do")
	public String main() {
		
		System.out.println("연결");
		return "member/main";
	}

	/* 회원등록 페이지 호출 */
	@RequestMapping("memberWrite.do")
	public String memberWrite(MemberVO vo) throws Exception {
		System.out.println("연결");

		return "member/memberWrite";
	}

	@RequestMapping("memberWriteSave.do")
	@ResponseBody // 메시지 전송할수 있다
	public String insertMember(MemberVO vo) throws Exception {
		String message = "";

		String result = memberService.insertMember(vo);
		if (result == null) {
			message = "ok";
		}
		return message;
	}

	/* 중복 회원 검증 */
	@RequestMapping("idChk.do")
	@ResponseBody
	public String memberIdChk(MemberVO co) throws Exception {
		System.out.println(co.getUserid());
		String result = memberService.memberIdChk(co);
		System.out.println(result);

		if (result == null) {
			result = "ok";
		}
		return result;
	}

	/*
	 * 2025-04-22 김양훈 최초작성~
	 * 2025-05-22 ~ 누가 어떤 사유로 수정하였다.
	 */

	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("sessionid");
		return "member/main";
	}

	/* 로그인 호출 화면 */
	@RequestMapping("login.do")
	public String login() {
		return "member/memberLogin";
	}
	
	/* 로그인 PROC 실행화면 */
	@RequestMapping("/loginProc.do")
	@ResponseBody // 세션을 만들어주는 클래스
	public String loginProc(MemberVO vo, HttpSession session) throws Exception {
		String message = "";
		int cnt = memberService.idlogin(vo.getUserid());
		System.out.println("cnt : " + cnt);
		if (cnt == 0) {// 아이디가 없습니다.
			message = "x";
		} else {// 성공
			int cnt2 = memberService.loginProc(vo);
			System.out.println("cnt2 : " + cnt2);

			if (cnt2 == 0) { // 패스워드가 틀려요
				message = "wrong password";
			} else {
				// session 생성
				session.setAttribute("sessionId", vo.getUserid());
				message = "ok";
			}
		}
		return message;
	}

	/*
	 * 회원리스트 김남훈 ~ 최초생성일자
	 */
	@RequestMapping("memberList.do")
	public String selectMemberList(ModelMap map) throws Exception {
		List<?> list = memberService.selectMemberList();
		System.out.println("list : " + list);
		map.addAttribute("memberList", list);
		return "member/memberList";
	}
}
