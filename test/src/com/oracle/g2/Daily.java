package com.oracle.g2;

class Daily extends Appointment {
	public Daily(String description) {
		super(description);
	}

	public boolean occursOn(int year, int month, int day) {
		return true;
	}
}
