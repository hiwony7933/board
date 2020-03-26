package com.gmail.hi;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gmail.hi.domain.Board;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(Board board, Model model) {
	}

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(HttpServletRequest request, RedirectAttributes rttr) {
		boardService.register(request);
		rttr.addFlashAttribute("msg", "게시글 작성에 성공하셨습니다.");
		return "redirect:/board/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) {
		List<Board> list = boardService.list();
		model.addAttribute("list", list);
	}

	@RequestMapping(value = "/detail/{bno}", method = RequestMethod.GET)
	public String detail(@PathVariable("bno") int bno, Model model) {
		model.addAttribute("vo", boardService.detail(bno));
		return "board/detail";
	}

	@RequestMapping(value = "/update/{bno}", method = RequestMethod.GET)
	public String update(@PathVariable("bno") int bno, Model model) {
		model.addAttribute("vo", boardService.updateView(bno));
		return "board/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, RedirectAttributes rttr) {
		boardService.update(request);
		rttr.addFlashAttribute("msg", "게시글 수정에 성공하셨습니다.");
		return "redirect:list";
	}

	@RequestMapping(value = "/delete/{bno}", method = RequestMethod.GET)
	public String delete(@PathVariable("bno") int bno, RedirectAttributes rttr) {
		boardService.delete(bno);
		rttr.addFlashAttribute("msg", "게시글 삭제에 성공하셨습니다.");
		return "redirect:/board/list";
	}
}