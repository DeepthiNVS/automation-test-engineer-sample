package com.att.demo.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Billing",
description = "Billing domain domain object")


public class Billing implements Serializable {

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	
	private String first_name;
	public String getFirst_name() {
		return first_name;
	}

	@ApiModelProperty(
            access = "public",
            name = "first_name",
            required = true,
            value = "account name (String)")
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	@ApiModelProperty(
            access = "public",
            name = "last_name",
            required = false,
            value = "account name (String)")

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
	@ApiModelProperty(
            access = "public",
            		name = "bill_invoice_number",
            required = true,
            value = "an identifier for the account (long)")
	

	public long getBill_invoice_number() {
		return bill_invoice_number;
	}

	public void setBill_invoice_number(long bill_invoice_number) {
		this.bill_invoice_number = bill_invoice_number;
	}
	
	
	@ApiModelProperty(
            access = "public",
            name = "Bill_amt",
            required = true,
            value = "an identifier for the account (long)")
	
	

	public long getBill_amt() {
		return bill_amt;
	}
	
	

	public void setBill_amt(long bill_amt) {
		this.bill_amt = bill_amt;
	}

//	public String getPay_due_dt() {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//		return pay_due_dt;
//	}

//	public void setPay_due_dt(Date pay_due_dt) {
//		Date now = new Date();		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//		this.pay_due_dt = ;
//	}

	private String last_name;
	private long bill_invoice_number;
	private long bill_amt;
	private String pay_due_dt;
	

	
	
	/**
     * Default Constructor 
     * 
     */
	public Billing() {
		super();
	}
	
	public Billing(long id, String name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.bill_invoice_number =bill_invoice_number;
		this.bill_amt = bill_amt;
		//this.pay_due_dt= pay_due_dt;
	}
	
	
	
	

	

	
	

	

	@Override
	public String toString() {
		return "Billing [first_name=" + first_name + ", last_nbame=" + last_name + ",bill_invoice_number ="+bill_invoice_number+
				",bill_amt ="+bill_amt+"]";
	}


}
