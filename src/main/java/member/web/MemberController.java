package member.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import member.service.MemberService;
import member.service.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberservice;

	@RequestMapping("main.do")
	public String main(ModelMap map, MemberVO vo) {
		
		 
		 List<?> board_list = memberservice.select_board();
		 
		 
		 System.out.println(board_list);
		 
		 map.addAttribute("board_list", board_list);
		 
		return "member/main";
	}
	
	@RequestMapping("insert.do")
	@ResponseBody
	public String insert(MemberVO vo) {
		
		System.out.println("연결");
		
		memberservice.insert(vo);
		
		return "";
		
	}
	
	
}
