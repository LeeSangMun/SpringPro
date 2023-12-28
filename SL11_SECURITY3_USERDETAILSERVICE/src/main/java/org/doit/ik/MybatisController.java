package org.doit.ik;

import org.doit.ik.mapper.TimeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MybatisController {
	private static final Logger logger = LoggerFactory.getLogger(MybatisController.class);

	@Autowired
	private TimeMapper timeMapper;
	
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public String getTime(Model model) {
		logger.info("> MybatisController.getTime Controller Method.. ");

		String currentTime = this.timeMapper.getTime();	
		String nextTime = this.timeMapper.getNextTime();	
		
		model.addAttribute("currentTime", currentTime);
		model.addAttribute("nextTime", nextTime);
		model.addAttribute("name", "admin");
		
		return "time";
	}
	
}
