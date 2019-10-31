package cn.sm1234.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.sm1234.domain.Customer;
import cn.sm1234.service.CustomerService;

@Controller
@RequestMapping("/cryomate")
public class CustomerController {
	@Resource
	private CustomerService customerService;
	
	//跳转到input.html页面
	@RequestMapping("/input")
	public String input(Model model, HttpServletRequest request){
		
		Customer cust = new Customer();
		cust.setId(2);
		cust.setAddress("new address");
		cust.setTelephone("12345");
		cust.setGender("female");		
		model.addAttribute("cust", cust);
		
		
		
		
		String name = request.getParameter("name");
		System.out.println("the name you input is: " + name);
		
		return "input";
	}
	
	
	//跳转到main.html	
	@RequestMapping("/main")
	public String index(Model model, HttpServletRequest request)
	{
		
		return "main";
	}
	
	
	/**
	 * 文件上传具体实现方法;
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model, HttpServletRequest request) {

		if (file.isEmpty()) {
			return "error: file is empty";
		}
		// 获取文件名
		String fileName = file.getOriginalFilename();
		System.out.println("上传的文件名为：" + fileName);
		// 获取文件的后缀名
		//String suffixName = fileName.substring(fileName.lastIndexOf("."));
		//System.out.println("上传的后缀名为：" + suffixName);
		// 文件上传后的路径
		//String filePath = "E://tmp/";
//		String filePath = "E://tmp/";
//		File dest = new File(filePath + fileName);
		File dest = new File(fileName);
		System.out.println("dest path: " + dest.getAbsolutePath());
		// 检测是否存在目录
//		if (!dest.getParentFile().exists()) {
//			dest.getParentFile().mkdirs();
//		}
		
		
		try {
			file.transferTo(dest.getAbsoluteFile());
			String description = request.getParameter("description");
			String responseMessage = "描述信息：" + description + ",  上传文件名：" + fileName;
			System.out.println("ResponseMessage = " + responseMessage);			
			return "success: " + responseMessage;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "error: upload file failed";
	}
	
	
	
	@RequestMapping("/upload2")
	//@ResponseBody
	public String handleFileUpload2(@RequestParam("file") MultipartFile file, Model model, HttpServletRequest request) {

		if (file.isEmpty()) {
			return "error";
		}
		// 获取文件名
		String fileName = file.getOriginalFilename();
		System.out.println("上传的文件名为：" + fileName);
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		System.out.println("上传的后缀名为：" + suffixName);
		// 文件上传后的路径
		String filePath = "./";
		File dest = new File(filePath + fileName);
		System.out.println("dest path: " + dest.getAbsolutePath());
		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
			String description = request.getParameter("description");
			String responseMessage = "描述信息：" + description + ", 上传文件名：" + fileName;
			System.out.println("ResponseMessage = " + responseMessage);
			model.addAttribute("returnMessage", responseMessage);
			return "success";
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	
	
	
	/**
	 * 保存方法
	 */
	@RequestMapping("/save")
	public String save(Customer customer, Model model){
		customerService.save(customer);
		
		
		model.addAttribute("cust", customer);
		return "succ";
	}
	
	/**
	 * 列表展示
	 */
	@RequestMapping("/list")
	public String list(Model model){
		List<Customer> list = customerService.findAll();
		model.addAttribute("list", list);
		return "list";
	}
	
	/**
	 * 根据id查询
	 */
	@RequestMapping("/findById")
	public String findById(Integer id,Model model){
		Customer cust = customerService.findById(id);
		model.addAttribute("cust", cust);
		return "input";
	}
	
	/**
	 * 删除客户
	 */
	@RequestMapping("/delete")
	public String delete(Integer id){
		customerService.delete(id);
		return "redirect:/customer/list";
	}
}
