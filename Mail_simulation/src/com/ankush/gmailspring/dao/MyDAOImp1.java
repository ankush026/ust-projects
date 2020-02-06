package com.ankush.gmailspring.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankush.gmailspring.model.Mail_info;
import com.ankush.gmailspring.model.User_info;

@Component
public class MyDAOImp1 implements MyDAO{
	@Autowired
	SessionFactory sf;

	HttpSession ss=null;

	//======================================Registration section======================================

	@Override
	public boolean regUser(User_info rdto) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("email", rdto.getEmail()));
		User_info dto=(User_info) cr.uniqueResult();
		if(dto==null) {
			ss.save(rdto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}
		else
		{
			return false;
		}

	}

	//======================================Registration section======================================


	//======================================Login section======================================

	@Override
	public boolean login(HttpServletRequest req) {
		String pw=req.getParameter("password");
		String email=req.getParameter("email");
		Session ss=sf.openSession();
		Criteria cr =ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("password",pw));
		cr.add(Restrictions.eq("email",email));
		User_info dto=(User_info) cr.uniqueResult();
		ss.beginTransaction().commit();
		ss.close();
		if(dto!=null) {
			return true;
		}else {
			return false;
		}
	}
	//======================================Login section======================================


	//======================================compose sent  section======================================

	@Override
	public boolean sent(HttpServletRequest req) {

		String	tem=req.getParameter("email");
		String ibx=	req.getParameter("uinbox");
		String usub=req.getParameter("usub");
		this.ss=req.getSession(false);
		String memail=(String) this.ss.getAttribute("email");
		Session ss=sf.openSession();

		Mail_info idto=null;

		if(memail!=null) {

			Query qry=ss.createQuery("from User_info where email='"+tem+"'");
			User_info rdto=(User_info) qry.uniqueResult();
			List<Mail_info>ilist;


			if(rdto!=null) {
				idto=new Mail_info();
				idto.setUto(tem);
				idto.setUinbox(ibx);
				idto.setUsent(memail);
				idto.setUsub(usub);

				ilist=rdto.getInfolist();
				ilist.add(idto);
				ss.saveOrUpdate(rdto);
				ss.beginTransaction().commit();
				ss.close();
				return true;
			}else {
				idto=new Mail_info();
				idto.setUdraft(tem);
				idto.setUsent(memail);
				idto.setUinbox(ibx);
				qry=ss.createQuery("from User_info where email='"+memail+"'");
				rdto=(User_info) qry.uniqueResult();
				ilist=rdto.getInfolist();
				ilist.add(idto);
				ss.saveOrUpdate(rdto);
				ss.beginTransaction().commit();
				ss.close();
				return false;
			}
		}
		else
		{
			ss.close();
			return false;
		}
	}
	//======================================compose  sent section======================================

	//====================================== show sent  email section======================================

	@Override
	public List<Mail_info> sentInbox(String em) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("usent", em));
		cr.add(Restrictions.isNotNull("uinbox"));
		cr.add(Restrictions.isNull("udraft"));
		cr.add(Restrictions.isNull("udelete"));
		//		cr.add(Restrictions.neOrIsNotNull("udelete","deleted"));
		List<Mail_info>ilist=cr.list();
		ss.close();
		return ilist;
	}
	//======================================show sent email section======================================


	//======================================inbox section======================================
	@Override
	public List<Mail_info> inbox(String em) {

		Session ss=sf.openSession();
		System.out.println("em="+em);
		//	Query qry=ss.createQuery("from Mail_info where uto='"+em+"' and udelete !='deleted'");
		Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("uto",em));
		//	String deleted="deleted";
		cr.add(Restrictions.isNull("udelete"));

		List<Mail_info>ilist=cr.list();
		ss.close();
		return ilist;
	}
	//======================================inbox section======================================


	//========================================draft section=================================

	@Override
	public List<Mail_info> draft(String em) {

		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("usent", em));
		cr.add(Restrictions.isNull("udelete"));
		cr.add(Restrictions.isNull("uto"));
		cr.add(Restrictions.isNotNull("udraft"));
		List<Mail_info>ilist=cr.list();
		ss.close();
		return ilist;

	}

	//========================================draft section=================================


	//========================================forget password section=================================

	public boolean forgetpw(HttpServletRequest req) {
		Session ss=sf.openSession();
		String email=req.getParameter("email");
		String seccques=req.getParameter("secques");
		String seccansw=req.getParameter("secansw");
		String newpw=req.getParameter("newpassword");
		String conpw=req.getParameter("confirmpassword");

		if(conpw.equals(newpw)) {
			Criteria cr=ss.createCriteria(User_info.class);
			cr.add(Restrictions.eq("email", email));
			cr.add(Restrictions.eq("secques", seccques));
			cr.add(Restrictions.eq("secansw", seccansw));
			User_info dto=(User_info) cr.uniqueResult();
			if(dto!=null) {
			dto.setPassword(newpw);
			ss.saveOrUpdate(dto);
			ss.beginTransaction().commit();
			return true;
		}else
		{
			return false;
		}}
			else
			{
				return false;
			}

	}
	//========================================forget password section=================================

	//========================================change password section=================================
	@Override
	public boolean changepassword(HttpServletRequest req) {
		Session ss=sf.openSession();
		String email=req.getParameter("email");
		String newpw=req.getParameter("newpassword");
		String conpw=req.getParameter("confirmpassword");

		if(conpw.equals(newpw)) {
			Criteria cr=ss.createCriteria(User_info.class);
			cr.add(Restrictions.eq("email", email));
			User_info dto=(User_info) cr.uniqueResult();

			if(dto!=null) {
				dto.setPassword(newpw);
				ss.saveOrUpdate(dto);
				ss.beginTransaction().commit();
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	//========================================change password section=================================


	//========================================deleted in home section=================================

	@Override
	public List<Mail_info> deletedmsginhome(String em) {

		Session ss=sf.openSession();
		System.out.println("em= "+em);
		Query qry=ss.createQuery("from Mail_info where uto='"+em+"'or usent='"+em+"' and udelete='deleted' and udelete!='perdelete'");
		List<Mail_info>ilist=qry.list();
		ss.close();
		return ilist;

	}

	//========================================deleted in home section=================================


	//========================================deleted msg in inbox section=================================

	@Override
	public boolean deletemsg(int mid) {

		Session ss=sf.openSession();

		System.out.println("msgid= "+mid);

		Mail_info mi=ss.load(Mail_info.class, mid);

		if(mi!=null) {

			mi.setUdelete("deleted");

			ss.saveOrUpdate(mi);
			ss.beginTransaction().commit();

			ss.close();
			return true;
		}
		else
		{
			ss.close();
			return false;
		}
	}

	//========================================deleted msg in inbox section=================================

	@Override
	public Mail_info fullinbox(int ibid) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("infid",ibid));
		//	String deleted="deleted";
		cr.add(Restrictions.isNull("udelete"));
		Mail_info mailinfo=(Mail_info) cr.uniqueResult();
		ss.close();

		return mailinfo;
	}

	//========================================deleted msg in inbox section=================================

	//======================================== permanent deleted msg in draft section=================================
	
	@Override
	public boolean perdelete(int msgid) {
		Session ss=sf.openSession();
		Mail_info mi=ss.load(Mail_info.class, msgid);
		if(mi!=null)
		{
//			mi.setUdelete("perdelete");
//			ss.save(mi);
			ss.delete(mi);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}
		else
		{
			ss.close();
			return false;
		}
	}

	//======================================== permanent deleted msg in draft section=================================





	//mydao close
}
