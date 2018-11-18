package com.oracle.g2;

class Monthly extends Appointment {
	public Monthly(String description, int day) {
		super(description, day);
	}

	public boolean occursOn(int year, int month, int day) {
		if (this.day == day)
			return true;
		else
			return false;
	}
}
