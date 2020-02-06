package com.ankush.stockManagementProject.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankush.stockManagementProject.dao.MyStockDAO;
import com.ankush.stockManagementProject.model.order_info;
import com.ankush.stockManagementProject.model.product_info;
import com.ankush.stockManagementProject.model.stockuser;

@Component
public class MysServiceImp1 implements MyService {

	@Autowired
	MyStockDAO ms;

	@Override
	public boolean regUser(stockuser rdto) {

		return ms.regUser(rdto);
	}

	@Override
	public boolean login(HttpServletRequest req) {

		return ms.login(req);
	}

	@Override
	public boolean addproduct(product_info pdto) {
		
		return ms.addproduct(pdto);
	}

	@Override
	public List<product_info> stock() {

		return ms.stock();
	}

	@Override
	public List<product_info> updatelink(HttpServletRequest req) {
		
			return ms.updatelink(req);
	}

	@Override
	public List<product_info> deletelink(HttpServletRequest req) {
		
		return ms.deletelink(req);
	}

	@Override
	public List<product_info> addtocart(int pid) {
		// TODO Auto-generated method stub
		return ms.addtocart(pid);
	}

	@Override
	public List<product_info> searchproduct(HttpServletRequest req) {

		return ms.searchproduct(req);
	}

	@Override
	public List<order_info> mycart() {
		
		return ms.mycart();
	}
	

}
