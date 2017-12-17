package com.imooc.webbusiness;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

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
		log.debug("===========================================================");
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

	@RequestMapping("file")
	public String file() {
		return "file";

	}

	/* 上传文件 */
	@RequestMapping(value = "doUpload", method = RequestMethod.POST)
	public String doUpload(@RequestParam("file") MultipartFile file) throws IOException {

		if (!file.isEmpty()) {
			log.debug("正在处理文件,{}" + file.getOriginalFilename());
			String fileName = "F:\\Code\\git\\MavneWebProject\\testFile\\" + System.currentTimeMillis()
					+ file.getOriginalFilename();
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(fileName));

		}

		return "success";
	}

	
	@RequestMapping(value="getEntity/{id}",method=RequestMethod.GET)
	public @ResponseBody  IndexEntity getIndexEntityJson(@PathVariable("id") int id) {
		IndexEntity entity = indexServer.getIndexEntityByID(id);
		return entity;
	}
}
