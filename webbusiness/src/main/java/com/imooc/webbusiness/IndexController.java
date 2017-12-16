package com.imooc.webbusiness;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	/*
	 * @RequestMapping("/index") public String index() { return "index"; }
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(@RequestParam("id") int id, Model model) {
		log.debug("in viewCourse,id={}", id);
		IndexEntity entity = indexServer.getIndexEntityByID(id);
		model.addAttribute("entity", entity);
		return "index";
	}

	@RequestMapping(value = "index2/{id}", method = RequestMethod.GET)
	public String index2(@PathVariable("id") int id, Map<String, Object> model) {
		IndexEntity entity = indexServer.getIndexEntityByID(id);
		model.put("entity", entity);
		return "index";
	}

	@RequestMapping("index3")
	public String index3(HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		IndexEntity entity = indexServer.getIndexEntityByID(id);
		request.setAttribute("entity", entity);
		return "index";
	}

	@RequestMapping("edit")
	public String edit() {
		return "edit";
	}

	@RequestMapping("save")
	public String save(IndexEntity entity) {
		return "redirect:index3?id=180";
	}
}
