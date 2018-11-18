package com.oracle.g2;

public class Amplifier {
	double gain;

	public String getGain() {
		return "ss";
	}

	public String getDescription() {
		return "ss";
	}

	public static void main(String[] args) {
		inverting_amplifier in = new inverting_amplifier(100, 200);
		noninverting_amplifier no = new noninverting_amplifier(100, 200);
		voltage_divider_amplifier vo = new voltage_divider_amplifier(100, 200);
		System.out.println(in.getDescription());
		System.out.println(in.getGain());
		System.out.println(no.getDescription());
		System.out.println(no.getGain());
		System.out.println(vo.getDescription());
		System.out.println(vo.getGain());

	}
}
