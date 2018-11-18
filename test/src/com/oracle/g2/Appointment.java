package com.oracle.g2;

public class Appointment {
	public String description;
	public int year;
	public int month;
	public int day;

	public Appointment() {
		super();
	}

	public Appointment(String description) {
		super();
		this.description = description;
	}

	public Appointment(String description, int year, int month, int day) {
		super();
		this.description = description;
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public Appointment(String description, int month, int day) {
		super();
		this.description = description;
		this.month = month;
		this.day = day;
	}

	public Appointment(String description, int day) {
		super();
		this.description = description;
		this.day = day;
	}

	public boolean occursOn(int year, int month, int day) {
		if (this.year == year && this.month == month && this.day == day)
			return true;
		else
			return false;
	}
}
