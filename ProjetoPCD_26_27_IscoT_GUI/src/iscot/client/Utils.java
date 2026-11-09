package iscot.client;

import java.util.Arrays;
import iscot.enums.Areas;

public class Utils {
	public static Areas lerArea(String s) {
		for (Areas a : Areas.values()) {
			if (a.name().equalsIgnoreCase(s)) {
				return a;
			}
		}
		System.err.println("Área inválida. Válidas: " + Arrays.toString(Areas.values()));
		return null;
	}
}
