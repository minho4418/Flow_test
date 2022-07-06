package com.my.flow.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.flow.dto.Flow;
import com.my.flow.service.FlowService;

@Controller
public class FlowController {
	//접근제한자, 공용, 상수, 클래스형, 참조변수(필드) = 클래스형, 스태틱메소드(매개변수)
		private static final Logger logger = LoggerFactory.getLogger(FlowController.class);
		
		@Autowired
		private FlowService flowService;
		
		//리스트로 이동
		@RequestMapping("/")
		public String home() {
			return "home";
		}
		
		//조회를 눌렀을때(데이터조회후 list로 이동)
		@RequestMapping("list")
		public void list(Model model) {
			List<Flow> flist = flowService.selectList();
			logger.info(flist.toString());

			int cnt = flowService.selectTotalCnt();
			logger.info(cnt+": 추가 개수");
			
			model.addAttribute("total",cnt);
			model.addAttribute("flist", flist);
		}
		
		@GetMapping("check")
		public String check(@RequestParam int file_num) {
			logger.info("file_num:" + file_num);
			
			int cnt = flowService.updateRemoveyn(file_num);
			logger.info(cnt+"체크");
			
			return "redirect:list";
			
		}
		@GetMapping("check2")
		public String check2(@RequestParam int file_num) {
			logger.info("file_num:" + file_num);
			
			int cnt = flowService.updateRemoveyn2(file_num);
			logger.info(cnt+"체크");
			
			return "redirect:list";
			
		}
		
		@GetMapping("add")
		public String add(Flow flow, @RequestParam String file_extension) {
			logger.info(flow.toString());
			
			int cnt = flowService.insert(flow);
			logger.info(cnt+"체크");
			
			/*
			 * flow = flowService.selectOne(file_extension); logger.info(flow.toString());
			 */
			
			return "redirect:list";
			
		}
		
		@GetMapping("remove")
		public String remove(Flow flow,@RequestParam String remove_file) {
			logger.info(flow.toString());
			
			int cnt = flowService.delete(remove_file);
			logger.info(cnt+"체크");
			
			return "redirect:list";
		}
		
		@GetMapping("removeAll")
		public String removeAll(Flow flow) {
			logger.info(flow.toString());
			
			int cnt = flowService.deleteAll();
			logger.info(cnt+"체크");
			
			return "redirect:list";
		}
}
