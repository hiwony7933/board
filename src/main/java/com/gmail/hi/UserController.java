package com.gmail.hi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
}
