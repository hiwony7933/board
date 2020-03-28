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

import com.gmail.hi.domain.Study;

@Controller
@RequestMapping("/study/*")
public class StudyController {
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(Study study, Model model) {
	}

	@Autowired
	private StudyService studyService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registPOST(HttpServletRequest request, RedirectAttributes rttr) {
        studyService.register(request);
        rttr.addFlashAttribute("msg", "게시글 작성에 성공하셨습니다.");
        return "redirect:/study/list";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list(Model model) {
        List<Study> list = studyService.list();
        model.addAttribute("list", list);
    }
    @RequestMapping(value = "/detail/{bno}", method = RequestMethod.GET)
    public String detail(@PathVariable("bno") int bno, Model model) {
        model.addAttribute("vo", studyService.detail(bno));
        return "study/detail";
    }
    @RequestMapping(value = "/update/{bno}", method = RequestMethod.GET)
    public String update(@PathVariable("bno") int bno, Model model) {
        model.addAttribute("vo", studyService.updateView(bno));
        return "study/update";
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(HttpServletRequest request, RedirectAttributes rttr) {
        studyService.update(request);
        rttr.addFlashAttribute("msg", "게시글 수정에 성공하셨습니다.");
        return "redirect:list";
    }

    @RequestMapping(value = "/delete/{bno}", method = RequestMethod.GET)
    public String delete(@PathVariable("bno") int bno, RedirectAttributes rttr) {
        studyService.delete(bno);
        rttr.addFlashAttribute("msg", "게시글 삭제에 성공하셨습니다.");
        return "redirect:/study/list";
    }







}
