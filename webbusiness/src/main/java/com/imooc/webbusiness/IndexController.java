package com.imooc.webbusiness;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.imooc.webbusiness.entity.IndexEntity;
import com.imooc.webbusiness.servlet.IndexService;

@Controller
public class IndexController {
	private IndexService indexServer;

	@Autowired
	public void setIndexServer(IndexService indexServer) {
		this.indexServer = indexServer;
	}

	private static Logger log = LoggerFactory.getLogger(IndexController.class);

/*	@RequestMapping("/index")
	public String index() {
		return "index";
	}*/

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(@RequestParam("id") int id, Model model) {
		log.debug("in viewCourse,id={}", id);
		IndexEntity entity = indexServer.getIndexEntityByID(id);
		model.addAttribute("entity",entity);
		return "index";
	}
}
