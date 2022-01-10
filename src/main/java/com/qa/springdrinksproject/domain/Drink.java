package com.qa.springdrinksproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Drink {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private int amount;
	
	@Column
	private boolean alcoholic;
	
	//default
	public Drink() {
		
	}

	//testing
	public Drink(long id, String name, int amount, boolean alcoholic) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.alcoholic = alcoholic;
	}
	
	//creating
	public Drink(String name, int amount, boolean alcoholic) {
		super();
		this.name = name;
		this.amount = amount;
		this.alcoholic = alcoholic;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isAlcoholic() {
		return alcoholic;
	}

	public void setAlcoholic(boolean alcoholic) {
		this.alcoholic = alcoholic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (alcoholic ? 1231 : 1237);
		result = prime * result + amount;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drink other = (Drink) obj;
		if (alcoholic != other.alcoholic)
			return false;
		if (amount != other.amount)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



}

