package com.ankush.stockManagementProject.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ankush.stockManagementProject.model.order_info;
import com.ankush.stockManagementProject.model.product_info;
import com.ankush.stockManagementProject.model.stockuser;

public interface MyService {

boolean regUser(stockuser rdto);

boolean login(HttpServletRequest req);

boolean addproduct(product_info pdto);

List<product_info> stock();

List<product_info> updatelink(HttpServletRequest req);

List<product_info> deletelink(HttpServletRequest req);

List<product_info> addtocart(int pid);

List<product_info> searchproduct(HttpServletRequest req);

List<order_info> mycart();
}
