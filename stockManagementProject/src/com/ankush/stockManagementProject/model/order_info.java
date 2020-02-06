package com.ankush.stockManagementProject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SecondaryTable;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class order_info {
	@Id
	@GenericGenerator(name = "auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int oid;
	private double totalprice;
	private double totalPriceWithGst;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "order_history_info",joinColumns =@JoinColumn(name="oid"),inverseJoinColumns =@JoinColumn(name="pid") )
	private List<product_info> p_o_list;
	
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public double getTotalPriceWithGst() {
		return totalPriceWithGst;
	}
	public void setTotalPriceWithGst(double totalgstprice) {
		this.totalPriceWithGst = totalgstprice;
	}
	public int getOid() {
		return oid;
	}
	public List<product_info> getP_o_list() {
		return p_o_list;
	}
	public void setP_o_list(List<product_info> p_o_list) {
		this.p_o_list = p_o_list;
	}
	
	
	
}
