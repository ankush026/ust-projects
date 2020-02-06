package com.ankush.stockManagementProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ankush.stockManagementProject.model.order_info;
import com.ankush.stockManagementProject.model.product_info;
import com.ankush.stockManagementProject.model.stockuser;
import com.ankush.stockManagementProject.service.MyService;

@RequestMapping("/")
@Component
public class MyController {

	@Autowired
	MyService ms;


	@RequestMapping("/Home")
	public ModelAndView Home(HttpServletRequest req) {
		HttpSession ss=req.getSession(false);

		String em=(String) ss.getAttribute("email");
		if(em!=null) {
			return new ModelAndView("Home","user",em);
		}
		else
		{
			return new ModelAndView("Login","msgf","Please Login first");
		}
	}

	//==============================================register user========================================================
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest req) {

		return new ModelAndView("Register");
	}

	@RequestMapping("/UserRegister")
	public String reg() {
		return "Register";
	}

	@RequestMapping(value="/RegUser",method=RequestMethod.POST)
	public ModelAndView regUser(@ModelAttribute stockuser rdto) {
		boolean b=ms.regUser(rdto);
		if(b) {
			return new ModelAndView("Register","msg","User is  registered Sucessfully......");
		}
		else
		{
			return new ModelAndView("Register","msgf","User is already registered........");
		}
	}
	//==============================================register user========================================================

	//======================================Login section======================================

	@RequestMapping("/UserLogin")
	public String log() {
		return "Login";
	}


	@RequestMapping(value="/Login",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req) {

		boolean  b=ms.login(req);
		if(b) {
			String em=req.getParameter("email");

			HttpSession ss=req.getSession();
			ss.setAttribute("email", em);
			String user=(String) ss.getAttribute("email");
			System.out.println("Success");
			return  new ModelAndView("Home","user",user);
		}
		else {
			System.out.println("Failed");
			return new ModelAndView("Login","msgf","Invalid Id or Password");
		}
	}
	//======================================Login section======================================

	//======================================Logout section======================================


	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req) {
		HttpSession ss=req.getSession(false);
		ss.invalidate();
		return new ModelAndView("ind","logout","Logout Sucessfull......");
	}

	//======================================Logout section======================================

	//======================================add product section======================================

	@RequestMapping("/addpage")
	public ModelAndView addpage(HttpServletRequest req) {
		HttpSession ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		if(em!=null) {
			return new ModelAndView("addpage");
		}
		else
		{
			return new ModelAndView("Login","msgf","Please login first!!!!");
		}
	}

	@RequestMapping(value="/addproduct", method = RequestMethod.POST)
	public ModelAndView addproduct(product_info pdto) {
		boolean b=ms.addproduct(pdto);
		if(b) {
			return new ModelAndView("Home");
		}
		else
		{
			return new ModelAndView("Home","msg","Product already in Stock");
		}
	}
	//======================================add product section======================================


	//======================================add product section======================================


	//======================================Available stock section======================================
	@RequestMapping("/stock")
	public ModelAndView stock(HttpServletRequest req) {
		HttpSession ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		if(em!=null) {
			List<product_info> plist=ms.stock();
			if(plist!=null) {
				return new ModelAndView("stock","plist",plist);	
			}
			else
			{
				return new ModelAndView("stock","msg","Stock is empty");
			}
		}
		else
		{
			return new ModelAndView("Login","msgf","Please login first!!!!");	
		}

	}
	//======================================Available stock section======================================


	//======================================update product section======================================

	@RequestMapping("/updateproduct")
	public ModelAndView updateproduct(HttpServletRequest req) {

		HttpSession ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		if(em!=null) {
			List<product_info> plist=ms.stock();
			if(plist!=null) {
				return new ModelAndView("updateproduct","plist",plist);	
			}
			else
			{
				return new ModelAndView("updateproduct","msg","Stock is empty");
			}
		}else
		{
			return new ModelAndView("Login","msgf","Please login first!!!!");
		}

	}

	@RequestMapping("/updatelink")
	public ModelAndView updatelink(HttpServletRequest req) {
		List<product_info> plist=ms.updatelink(req);
		if(plist!=null) {
			return new ModelAndView("updateproduct","plist",plist);	
		}
		else
		{
			return new ModelAndView("updateproduct","msg","Stock is empty");
		}
	}

	@RequestMapping("/deletelink")
	public ModelAndView deletelink(HttpServletRequest req) {
		List<product_info> plist=ms.deletelink(req);
		if(plist!=null) {
			return new ModelAndView("updateproduct","plist",plist);	
		}
		else
		{
			return new ModelAndView("updateproduct","msg","Stock is empty");
		}
	}

	//======================================update product section======================================

	//======================================add to cart product link======================================

	@RequestMapping("/addtocart")
	public ModelAndView addtocart(@RequestParam int pid) {
		List<product_info> plist=ms.addtocart(pid);
		if(plist!=null) {
			return new ModelAndView("stock","plist",plist);	
		}
		else
		{
			return new ModelAndView("stock","msg","Stock is empty");
		}
	}

	//======================================add to cart product link======================================

	//======================================my cart  link======================================

	@RequestMapping("/mycart")
	public ModelAndView mycart(HttpServletRequest req) {
		HttpSession ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");


		if(em!=null) {

			List<order_info> bill=ms.mycart();
			if(bill!=null) {
				return new ModelAndView("mycart","bill",bill);
			}else
			{
				return new ModelAndView("mycart","msg","Cart is Empty");
			}

		}
		else
		{
			return new ModelAndView("Login","msgf","Please login first!!!!");
		}
	}
	//======================================my cart  link======================================

	//======================================Search link======================================

	@RequestMapping(value="/searchproduct",method = RequestMethod.POST)
	public ModelAndView searchproduct(HttpServletRequest req) {
		HttpSession ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		if(em!=null) {
			List<product_info> plist=ms.searchproduct(req);
			return new ModelAndView("stock","plist",plist);
		}
		else
		{
			return new ModelAndView("Login","msgf","Please login first!!!!");
		}
	}

	//======================================Search link======================================
	

	//my controller end	
}
