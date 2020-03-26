package com.gmail.hi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gmail.hi.domain.User;

@Controller
public class UserController {
	@RequestMapping(value = "user/register", method = RequestMethod.GET)
	public void register(Model model) {

	}

	@Autowired
	private UserService userService;

	@RequestMapping(value = "user/register", method = RequestMethod.POST)
	public String registerPost(MultipartHttpServletRequest request, RedirectAttributes rttr) {
		int result = userService.register(request);
		System.out.print("result:" + result);
		if (result > 0) {
			rttr.addFlashAttribute("insert", "success");
			return "redirect:/";
		} else {
			return "redirect:register";
		}
	}

	@RequestMapping(value = "user/login", method = RequestMethod.GET)
	public void login(Model model) {
	}


	@RequestMapping(value = "user/login", method = RequestMethod.POST)
	public String login(User user, HttpSession session, Model model, RedirectAttributes attr) {
		User userVO = userService.login(user);
		if (userVO == null) {
			attr.addFlashAttribute("msg", "없는 이메일이거나 비밀번호가 잘못되었습니다.");
			return "redirect:login";
		}
		session.setAttribute("user", userVO);
		return "redirect:/";
	}
	
	@RequestMapping(value = "user/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "user/update", method = RequestMethod.GET)
	public String update(Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:user/login";
		} else {
			return "user/pwcheck";
		}
	}
	

	@RequestMapping(value = "user/updateform", method = RequestMethod.POST)
	public String updatePost(MultipartHttpServletRequest request, RedirectAttributes rttr) {
		int result = userService.update(request);
		if (result > 0) {
			request.getSession().removeAttribute("user");
			rttr.addFlashAttribute("update", "success");
			return "redirect:/";
		} else {
			return "redirect:user/updateform";
		}
	}

	@RequestMapping(value = "user/secession", method = RequestMethod.POST)
	public String secession(HttpServletRequest request, Model model, RedirectAttributes attr) {
		int r = userService.secession(request);
		if (r >= 0) {
			request.getSession().removeAttribute("user");
			attr.addFlashAttribute("secession", "success");
			return "redirect:/";
		} else {
			attr.addFlashAttribute("msg", "비밀번호가 잘못되었습니다.");
			return "redirect:secession";
		}
	}

}
