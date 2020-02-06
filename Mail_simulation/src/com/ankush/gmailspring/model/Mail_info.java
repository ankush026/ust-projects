package com.ankush.gmailspring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Mail_info {
	@Id
	@GenericGenerator(name = "auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int infid;
	private String uinbox;
	private String usent;
	private String udraft;
	private String udelete;
	private String uto;
	private String usub;
	
	

	public String getUto() {
		return uto;
	}



	public void setUto(String uto) {
		this.uto = uto;
	}



	public int getInfid() {
		return infid;
	}



	public void setInfid(int infid) {
		this.infid = infid;
	}



	public String getUinbox() {
		return uinbox;
	}



	public void setUinbox(String uinbox) {
		this.uinbox = uinbox;
	}



	public String getUsent() {
		return usent;
	}



	public void setUsent(String usent) {
		this.usent = usent;
	}



	public String getUdraft() {
		return udraft;
	}



	public void setUdraft(String udraft) {
		this.udraft = udraft;
	}



	public String getUdelete() {
		return udelete;
	}



	public void setUdelete(String udelete) {
		this.udelete = udelete;
	}



	public String getUsub() {
		return usub;
	}



	public void setUsub(String usub) {
		this.usub = usub;
	}



	
	  
}
