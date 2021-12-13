package com.springAPI.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class CalcularImpostos {
	
	private final static Double LIMITE[] = { 1100.00D, 2203.48D, 3305.22D, 6433.57D };

	private final static Double ALIQUOTA[] = { 0.075D, 0.09D, 0.12D, 0.14D };

	public static Double ALIQ(int i) {
		return ALIQUOTA[i - 1];
	}

	public static Double LIM(int i) {
		return LIMITE[i - 1];
	}

	public static Double calcular(Double V) {

		Map<Integer, Double> faixa = new HashMap<Integer, Double>();
		if (V < LIM(1)) faixa.put(1, V); else faixa.put(1, LIM(1));
		for (int i = 2; i < 5; i++) {
			if (V > LIM(i - 1) && V <= LIM(i)) {
				faixa.put(i, V - LIM(i - 1));
			}
		}

		for (int i = 2; i < 5; i++) {
			if (V > LIM(i)) {
				faixa.put(i, LIM(i) - LIM(i - 1));
			}
			
		}

		Double IN = 0D;

		for (int i = 1; i < 5; i++) {

			if (i <= faixa.values().size()) {
				IN += faixa.get(i) * ALIQ(i);
			}
		}

		return round(IN);
	}

	public static Double truncate(Double valor) {
		BigDecimal bigvalor = new BigDecimal(valor);
		return bigvalor.setScale(2, RoundingMode.DOWN).doubleValue();
	}
	
	public static double round(double valor) {		
		return BigDecimal.valueOf(valor).setScale(2, RoundingMode.UP).doubleValue();
	}
}
