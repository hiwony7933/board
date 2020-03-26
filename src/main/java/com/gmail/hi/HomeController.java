package com.gmail.hi;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gmail.hi.domain.User;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}

	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "user/pwcheck", method = RequestMethod.POST)
	public String pwcheck(User user, HttpSession session, Model model, RedirectAttributes attr) {
		User loginUser = (User) session.getAttribute("user");
		user.setEmail(loginUser.getEmail());
		User userXO = userService.login(user);
		
		if (userXO == null) {
			attr.addFlashAttribute("msg", "비밀번호가 잘못되었습니다.");
			return "redirect:/user/update";
		}
		session.setAttribute("user", userXO);
		return "redirect:updateform";
	}

	@RequestMapping(value = "user/updateform", method = RequestMethod.GET)
	public String updatefrom() {
		return "user/updateform";
	}

	@RequestMapping(value = "user/secession", method = RequestMethod.GET)
	public String pwinput(Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:user/login";
		} else {
			return "user/secession";
		}
	}
}
