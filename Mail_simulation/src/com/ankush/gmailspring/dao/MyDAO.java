package com.ankush.gmailspring.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ankush.gmailspring.model.Mail_info;
import com.ankush.gmailspring.model.User_info;

public interface MyDAO {
	public boolean regUser(User_info rdto);
	
	public boolean sent(HttpServletRequest req);
	
	public List<Mail_info> sentInbox(String em);
	
	public boolean login(HttpServletRequest req);
	
	public List<Mail_info> inbox(String em);
	
	public List<Mail_info> draft(String em);

	public boolean forgetpw(HttpServletRequest req);

	public boolean changepassword(HttpServletRequest req);

	public List<Mail_info> deletedmsginhome(String em);

	boolean deletemsg(int mid);

	public Mail_info fullinbox(int ibid);


	public boolean perdelete(int msgid);
}
