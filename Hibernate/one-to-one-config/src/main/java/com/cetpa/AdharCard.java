package com.cetpa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AdharCard
{	
	@Id
	private int aid;
	private String cardno;
	@OneToOne(cascade= CascadeType.ALL)
	private Person person;
	public AdharCard() 
	{
		
	}
	public AdharCard(int aid, String cardno, Person person) {
		super();
		this.aid = aid;
		this.cardno = cardno;
		this.person = person;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
		
}
