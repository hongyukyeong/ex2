package com.choa.ex2;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeService;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Inject //inject는 type으로 찾음 bean 에서 만든 것을 넣어라
	private NoticeService noticeService; 
	
	//list
	@RequestMapping(value="noticeList", method=RequestMethod.GET)
	public void noticeList(Model model, @RequestParam(defaultValue="1") Integer curPage) throws Exception{
		
		List<NoticeDTO> ar = noticeService.noticeList(curPage);
		model.addAttribute("list", ar);
	}
	
	//view
	@RequestMapping(value="noticeView", method=RequestMethod.GET)
	public void noticeView(Integer num, Model model) throws Exception{
		
		NoticeDTO noticeDTO=noticeService.noticeView(num);
		model.addAttribute("view", noticeDTO);
	}
	
	//writeForm
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public void noticeWrite(){
		
	}
	//write
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO, Model model, RedirectAttributes rd) throws Exception{
		
		int result=noticeService.noticeWrite(noticeDTO);
		String message ="FAIL";
		
		if(result>0){
			message="SUCCESS";
		}
		
		
		/*redirect로 보낼 때 message도 보내고 싶고*/
		/**/
		rd.addFlashAttribute("message", message);
		
		return "redirect:noticeList?curPage=2";
		
		/*redirect로 보내는 방법*/
		/*return "redirect:/"; 바로 홈으로 가는 주소 */
		
		
	}
	
	//updateForm
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public void noticeUpdate(Integer num, Model model) throws Exception{
		
			NoticeDTO noticeDTO = noticeService.noticeView(num);
			model.addAttribute("dto", noticeDTO);
	}
	
	//update
	@RequestMapping(value="noticeUpdate" , method=RequestMethod.POST)
	public String noticeUpdate(NoticeDTO noticeDTO, RedirectAttributes rd, Model model) throws Exception{
		int result= noticeService.noticeUpdate(noticeDTO);
		String message ="UPDATE FAIL";
		
		if(result>0){
			message="UPDATE SUCCESS";			
		}
		
		rd.addFlashAttribute("message", message);
		return "redirect:noticeList";
		
		//if문 성공 실패
	}
		
	//delete
	@RequestMapping(value="noticeDelete", method=RequestMethod.GET)
	public String noticeDelete(Integer num, RedirectAttributes rd) throws Exception{
		int result=noticeService.noticeDelete(num);
		String message ="DELETE FAIL";
		
		if(result>0){
			message="DELETE SUCCESS";
		}
		
		
		
		rd.addFlashAttribute("message", message);
		return "redirect:noticeList";
		//if문 성공 실패
	}
	
	

}
