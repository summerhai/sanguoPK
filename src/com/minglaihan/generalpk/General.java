package com.minglaihan.generalpk;

import java.sql.Blob;

import android.R.integer;

public class General {
	public int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	public int getCaptain() {
		return captain;
	}

	public void setCaptain(int captain) {
		this.captain = captain;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String name;
	public String sex;
	public int captain;
	public int force;
	public int intelligence;
	public String introduction;
	
	public General() {
	}
	
	public General(String name, String sex,int captain,int force,int intelligence,String introduction) {
		this.name = name;
		this.sex = sex;

		this.captain = captain;
		this.force = force;
		this.intelligence = intelligence;
		this.introduction = introduction;
	}

}
