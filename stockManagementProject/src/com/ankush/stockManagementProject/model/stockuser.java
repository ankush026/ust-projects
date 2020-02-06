package com.ankush.stockManagementProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class stockuser {

	@Id
	@GenericGenerator(name = "auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int uid;
//	@Column(unique=true)
	private String un;
//	private String num;
	@Column(unique=true)
	private String email;
	private String password;
//	private String secques;
//	private String secansw;
	 
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(referencedColumnName="uid")
//	private List<Mail_info> infolist;


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getUn() {
		return un;
	}


	public void setUn(String un) {
		this.un = un;
	}


//	public String getNum() {
//		return num;
//	}
//
//
//	public void setNum(String num) {
//		this.num = num;
//	}


//	public String getAddress() {
//		return address;
//	}
//
//
//	public void setAddress(String address) {
//		this.address = address;
//	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


//	public List<Mail_info> getInfolist() {
//		return infolist;
//	}


//	public void setInfolist(List<Mail_info> infolist) {
//		this.infolist = infolist;
//	}


//	public String getSecques() {
//		return secques;
//	}
//
//
//	public void setSecques(String secques) {
//		this.secques = secques;
//	}
//
//
//	public String getSecansw() {
//		return secansw;
//	}
//
//
//	public void setSecansw(String secansw) {
//		this.secansw = secansw;
//	}
//	  
	  
	
}
