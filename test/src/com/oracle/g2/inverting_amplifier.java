package com.oracle.g2;

public class inverting_amplifier extends Amplifier {
	double R1;
	double R2;

	public inverting_amplifier(double r1, double r2) {
		super();
		R1 = r1;
		R2 = r2;
	}

	@Override
	public String getGain() {
		gain = -(R2 / R1);
		return "增益为:" + gain;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "这是一个反相放大器.";
	}
}
