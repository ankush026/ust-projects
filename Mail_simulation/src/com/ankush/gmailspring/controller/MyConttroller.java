package com.ankush.gmailspring.controller;

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

import com.ankush.gmailspring.model.Mail_info;
import com.ankush.gmailspring.model.User_info;
import com.ankush.gmailspring.service.MyService;

@Component
@RequestMapping("/")
public class MyConttroller {

	@Autowired
	MyService ms;

//	HttpSession ss=null;



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

	//======================================Registration section======================================
	//mapping of register link with home page
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest req) {

		return new ModelAndView("Register");
	}
	@RequestMapping("/UserRegister")
	public String reg() {
		return "Register";
	}

	@RequestMapping(value="/RegUser",method=RequestMethod.POST)
	public ModelAndView regUser(@ModelAttribute User_info rdto) {
		boolean b=ms.regUser(rdto);
		if(b) {
			return new ModelAndView("Register","msg","User is  registered Sucessfully......");
		}
		else
		{
			return new ModelAndView("Register","msgf","User is already registered........");
		}
	}

	//======================================Registration section======================================

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

			HttpSession ss=ss=req.getSession();
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

	//======================================Compose section======================================


	@RequestMapping("/Compose")
	public ModelAndView compose(HttpServletRequest req) {
		HttpSession ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		if(em!=null) {
		return new ModelAndView("Compose");	
		}else
		{
			return new ModelAndView("Login","msgf","Please Login first");
		}
	}

	@RequestMapping(value="/Sent",method=RequestMethod.POST)
	public ModelAndView sent(HttpServletRequest req) {
		HttpSession ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		boolean b=ms.sent(req);

		if(b){
			return new ModelAndView("Home","msg","Mail Successfull Sent");
		}else {
			if(em!=null) {
				
//				return new ModelAndView("Home","msg","Mail not Sent");
				return new ModelAndView("Home","msg","Mail not Sent");
			}else
			{
				return new ModelAndView("Login","msg","Please Login First");
			}
		}

	}
	//======================================Compose Link section======================================

	//======================================sent Link section======================================


	@RequestMapping("/SentInbox")
	public ModelAndView sentInbox(HttpServletRequest req) {
		HttpSession ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		if(em!=null) {
		List<Mail_info>plist=ms.sentInbox(em);
		return new ModelAndView("SentEmail","plist",plist);
		}else
		{
			return new ModelAndView("Login","msgf","Please Login first");
		}
	}
	//======================================sent Link section======================================


	//======================================Inbox Link section======================================

	@RequestMapping("/Inbox")
	public ModelAndView Inbox(HttpServletRequest req) {
		HttpSession ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		if(em!=null) {
		List<Mail_info>plist=ms.inbox(em);
		return new ModelAndView("Inbox","plist",plist);
		}
		{
			return new ModelAndView("Login","msgf","Please Login first");
		}
	}
	//======================================Inbox Link section======================================


	//======================================Draft Link section======================================

	@RequestMapping("/Draft")
	public ModelAndView draft(HttpServletRequest req) {
		HttpSession ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		if(em!=null) {
		List<Mail_info>plist=ms.draft(em);
		return new ModelAndView("Draft","plist",plist);
		}else
		{
			return new ModelAndView("Login","msgf","Please Login first");
		}
	}

	//======================================Draft Link section======================================

	//======================================Logout  Linksection======================================

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req) {
		HttpSession ss=req.getSession(false);
		ss.invalidate();

		return new ModelAndView("ind","logout","Logout Sucessfull......");
	}
	//======================================Logout Link section======================================


	//======================================Forget Link section======================================

	@RequestMapping("/forget")
	public ModelAndView forget(HttpServletRequest req) {

		return new ModelAndView("forget");
	}

	@RequestMapping(value="/forgetpass",method = RequestMethod.POST)
	public ModelAndView forgetpass(HttpServletRequest req) {
		//		String em=(String) ss.getAttribute("email");
		HttpSession ss=req.getSession(false);
		boolean b=ms.forgetpw(req);
		if(b) {
			return new ModelAndView("forget","msg","password changed");
		}
		else
		{
			return new ModelAndView("forget","msg","Invalid credintials or password not matched");

		}
	}
	//======================================Forget Link section======================================


	//======================================Change password Link section======================================

	@RequestMapping("/changepass")
	public ModelAndView changepass(HttpServletRequest req) {
		HttpSession ss=req.getSession(false);
		String email=(String)ss.getAttribute("email");
		if(email!=null) {
		return new ModelAndView("changepass");
		}else
		{
			return new ModelAndView("Login","msgf","Please Login first");	
		}
		}
		

	@RequestMapping(value="/changepassword",method = RequestMethod.POST)
	public ModelAndView changepassword(HttpServletRequest req) {
		
		String email=(String)req.getAttribute("email");
		
		boolean b=ms.changepassword(req);
		if(b) {
			return new ModelAndView("changepass","msg","password changed successfully");
		}
		else
		{
			return new ModelAndView("changepass","msg","Password Not Matched");

		}
	}
	//======================================Change passwordLink  section======================================

	//======================================== Show Deleted section in Home page======================================


	@RequestMapping("/deletedmsginhome")
	public ModelAndView deletedmsginhome(HttpServletRequest req) {
		HttpSession ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		
		if(em!=null) {
		List<Mail_info>dlist=ms.deletedmsginhome(em);
		for (Mail_info infoDTO : dlist) {
			System.out.println("from  "+infoDTO.getUsent()+"  "+" deleted message"+infoDTO.getUinbox()  +""+infoDTO.getUsub());
		}
		return new ModelAndView("deletedmsginhome","dlist",dlist);
		}else
		{
			return new ModelAndView("Login","msgf","Please Login first");
		}
	}


	//======================================== Show Deleted section in Home Page======================================


	//======================================== Deleted button Emails in Home Page======================================

	@RequestMapping("/deletemsg")
	public ModelAndView deletemsg(@RequestParam int msgid,HttpServletRequest req) {
		HttpSession ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");

		boolean b=ms.deletemsg(msgid);

		if(b) 
		{
			return new ModelAndView("Home","msg","message deleted successfully");
		}
		else
		{
			return new ModelAndView("Home","msg","message Not  deleted ");

		}
	}
	//======================================== Deleted button Emails in Home Page======================================
	
	//========================================Permanent button Deleted Emails in Home Page======================================
	
	@RequestMapping("/perdelete")
	public ModelAndView perdelete(@RequestParam int msgid,HttpServletRequest req) {
		HttpSession ss	=req.getSession(false);
		String em=(String) ss.getAttribute("email");

		boolean b=ms.perdelete(msgid);

		if(b) 
		{
			return new ModelAndView("Home","msg","message Deleted Successfully ");
		}
		else
		{
			return new ModelAndView("Home","msg","message Not  deleted ");

		}
	}

	
	
	//========================================Permanent button Deleted Emails in Home Page======================================
	
	//======================================== Show full inbox ======================================
	@RequestMapping("/fullinbox")
	public ModelAndView fullinbox(@RequestParam int ibid,HttpServletRequest req) {
		HttpSession ss	=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		
		Mail_info maildto=ms.fullinbox(ibid);

		if(maildto!=null) 
		{
			return new ModelAndView("fullinbox","maildto",maildto);
		}
		else
		{
			return new ModelAndView("Home","msg","No message was found ");

		}
		
		
	}
	//======================================== Show full inbox ======================================
	
	
	@RequestMapping("/Composedraft")
	public ModelAndView Composedraft(@RequestParam int ibid) {
		
		Mail_info maildto=ms.fullinbox(ibid);

		if(maildto!=null) 
		{
			return new ModelAndView("Compose","maildto",maildto);
		}
		else
		{
			return new ModelAndView("Home","msg","No message was found ");

		}
		
		
	}
	
	
	
	
	//	my controller close	
}


