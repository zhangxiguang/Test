package com.oracle.g2;

public class noninverting_amplifier extends Amplifier {
	double R1;
	double R2;

	public noninverting_amplifier(double r1, double r2) {
		super();
		R1 = r1;
		R2 = r2;
	}

	@Override
	public String getGain() {
		gain = 1 + (R2 / R1);
		return "增益为:" + gain;
	}

	@Override
	public String getDescription() {
		return "这是一个同相放大器.";
	}

}
