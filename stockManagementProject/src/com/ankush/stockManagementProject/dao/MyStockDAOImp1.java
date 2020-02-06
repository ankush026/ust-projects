package com.ankush.stockManagementProject.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankush.stockManagementProject.model.order_info;
import com.ankush.stockManagementProject.model.product_info;
import com.ankush.stockManagementProject.model.stockuser;

@Component
public class MyStockDAOImp1 implements MyStockDAO{

	@Autowired 
	SessionFactory sf;
	
	HttpSession ss;

	//======================================Register section======================================

	@Override
	public boolean regUser(stockuser rdto) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(stockuser.class);
		cr.add(Restrictions.eq("email", rdto.getEmail()));
		stockuser dto=(stockuser) cr.uniqueResult();
		if(dto==null) {
			ss.save(rdto);
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
	//======================================Register section======================================


	//======================================Login section======================================

		@Override
		public boolean login(HttpServletRequest req) {
			String pw=req.getParameter("password");
			String email=req.getParameter("email");
			Session ss=sf.openSession();
			Criteria cr =ss.createCriteria(stockuser.class);
			cr.add(Restrictions.eq("password",pw));
			cr.add(Restrictions.eq("email",email));
			stockuser dto=(stockuser) cr.uniqueResult();
			ss.beginTransaction().commit();
			ss.close();
			if(dto!=null) {
				return true;
			}else {
				return false;
			}
		}
		//======================================Login section======================================


		//======================================Add product section======================================
		@Override
		public boolean addproduct(product_info pdto) {
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(product_info.class);
			cr.add(Restrictions.eq("pname", pdto.getPname()));
			cr.add(Restrictions.eq("company",pdto.getCompany()));
			product_info dto=(product_info) cr.uniqueResult();
			if(dto==null) {
			ss.save(pdto);
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
		//======================================Add product section======================================
		
		//======================================stock section======================================

		@Override
		public List<product_info> stock() {
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(product_info.class);
			List<product_info> plist=cr.list();
			
			return plist;
		}
		//======================================stock section======================================

		//======================================Update section======================================
		
		@Override
		public List<product_info> updatelink(HttpServletRequest req) {
			Session ss=sf.openSession();
			product_info pdto=ss.load(product_info.class,Integer.parseInt(req.getParameter("pid")) );
			pdto.setPname(req.getParameter("pname"));
			pdto.setPcategory(req.getParameter("pcategory"));
			pdto.setCompany(req.getParameter("company"));
			pdto.setQty((Integer.parseInt(req.getParameter("qty"))));
			pdto.setPrice(Double.parseDouble(req.getParameter("price")));
			ss.saveOrUpdate(pdto);
			ss.beginTransaction().commit();
			
			
			Criteria cr=ss.createCriteria(product_info.class);
			List<product_info> plist=cr.list();
			ss.close();
			return plist;
		}


		@Override
		public List<product_info> deletelink(HttpServletRequest req) {
			Session ss=sf.openSession();
			product_info pdto=ss.load(product_info.class,Integer.parseInt(req.getParameter("pid")) );
			ss.delete(pdto);
			ss.beginTransaction().commit();
			Criteria cr=ss.createCriteria(product_info.class);
			List<product_info> plist=cr.list();
			ss.close();
			return plist;
		}
		
		
		//======================================Update section======================================
		
		//======================================add to cart section======================================
		@Override
		public List<product_info> addtocart(int pid) {
			Session ss=sf.openSession();
			product_info pdto=ss.load(product_info.class,pid );
			double totalprice=pdto.getPrice();
			double totalgstprice =+totalprice*118/100.0;
			int updatedqty=pdto.getQty()-1;
			pdto.setQty(updatedqty);
			ss.saveOrUpdate(pdto);
			
			order_info odto= new order_info();
			odto.setTotalprice(totalprice);
			odto.setTotalPriceWithGst(totalgstprice);
			List<product_info> polist=new ArrayList<product_info>();
			polist.add(pdto);
			odto.setP_o_list(polist);
			ss.save(odto);
			ss.beginTransaction().commit();
			Criteria cr=ss.createCriteria(product_info.class);
			List<product_info> plist=cr.list();
			ss.close();
			return plist;

		}
		//======================================add to cart section======================================
		
		//======================================search link section======================================


		@Override
		public List<product_info> searchproduct(HttpServletRequest req) {
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(product_info.class);
//			cr.add(Restrictions.ilike("pname", req.getParameter("searchedproduct"),MatchMode.ANYWHERE));
			Criterion pname=Restrictions.ilike("pname", req.getParameter("searchedproduct"),MatchMode.ANYWHERE);
			Criterion pcategory=Restrictions.ilike("pcategory", req.getParameter("searchedproduct"),MatchMode.ANYWHERE);
			Criterion company=Restrictions.ilike("company", req.getParameter("searchedproduct"),MatchMode.ANYWHERE);
			
			Criterion result=Restrictions.disjunction().add(pname).add(pcategory).add(company);
			cr.add(result);
			
			List<product_info> plist=cr.list();
			
			return plist;
		}
		//======================================search link section======================================

		
		//======================================my cart section======================================

		
		@Override
		public List<order_info> mycart() {
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(order_info.class);
	
			 
			
			List<order_info>  olist=cr.list();
			
			return olist;
		}
		//======================================my cart section======================================

		

		//my dao end
}
