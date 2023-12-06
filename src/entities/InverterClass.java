package entities;

import functional_interfaces.StringModifier;

public class InverterClass implements StringModifier {
	@Override
	public String modify(String str) {
		String[] splitted = str.split("");
		String inverted = "";
		for (int i = splitted.length - 1; i >= 0; i--) {
			inverted += splitted[i];
		}
		return inverted;
	}
}
