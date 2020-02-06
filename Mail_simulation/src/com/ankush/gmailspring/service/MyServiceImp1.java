package com.ankush.gmailspring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankush.gmailspring.dao.MyDAO;
import com.ankush.gmailspring.model.Mail_info;
import com.ankush.gmailspring.model.User_info;
@Component
public class MyServiceImp1 implements MyService{
 @Autowired
 MyDAO md;
	@Override
	public boolean regUser(User_info rdto) {
		// TODO Auto-generated method stub
		boolean b=md.regUser(rdto);
		return b;
	}
	@Override
	public boolean login(HttpServletRequest req) {
		// TODO Auto-generated method stub
	    boolean	b=md.login(req);
		
		return b;
	}
	@Override
	public boolean sent(HttpServletRequest req) {
		// TODO Auto-generated method stub
		boolean b=md.sent(req);
		return b;
	}
	@Override
	public List<Mail_info> sentInbox(String em) {
		// TODO Auto-generated method stub
		
		return md.sentInbox(em);
	}
	@Override
	public List<Mail_info> inbox(String em) {
		
		return md.inbox(em);
	}
	@Override
	public List<Mail_info> draft(String em) {

		return md.draft(em);
	}
	
	public boolean forgetpw(HttpServletRequest req) {
		
		boolean b=md.forgetpw(req);
		return b;
	}
	@Override
	public boolean changepassword(HttpServletRequest req) {
		boolean b=md.changepassword(req);
		return b;
	}
	@Override
	public List<Mail_info> deletedmsginhome(String em) {
		
		return md.deletedmsginhome(em);
	}
	@Override
	public boolean deletemsg(int mid) {
		
		
		return md.deletemsg(mid);
	}
	@Override
	public Mail_info fullinbox(int ibid) {
		
		return md.fullinbox(ibid);
	}
	
	@Override
	public boolean perdelete(int msgid) {
		
		return md.perdelete(msgid);
	}

}
