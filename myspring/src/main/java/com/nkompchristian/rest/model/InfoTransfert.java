/**
 * 
 */
package com.nkompchristian.rest.model;

/**
 * @author TI-LT1055
 *
 */
//Dichiarazioni e Getter and Setter
public class InfoTransfert {

	private String executionDate;
	private String description;
	private String amount;
	private String currency;
	private String receiverName;
	
	public InfoTransfert() {
		// TODO Auto-generated constructor stub
	}

	public String getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

}
