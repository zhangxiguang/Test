package com.oracle.g2;

public class voltage_divider_amplifier extends Amplifier {
	double R1;
	double R2;

	public voltage_divider_amplifier(double r1, double r2) {
		super();
		R1 = r1;
		R2 = r2;
	}

	@Override
	public String getGain() {
		gain = R2 / (R1 + R2);
		return "增益为:" + gain;
	}

	@Override
	public String getDescription() {
		return "这是一个分压放大器.";
	}

}
