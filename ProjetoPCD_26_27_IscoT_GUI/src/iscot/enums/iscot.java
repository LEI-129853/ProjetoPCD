package iscot.enums;

import java.util.Arrays;

public class iscot {

	public static void main(String[] args) {
		if (args.length != 4) {
			System.err.println("Uso: iscot IP PORT Area Tipo");
			return;
		}
		String ip = args[0];
		int port;
		try {
			port = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.err.println("Erro ao obter port");
			return;
		}
		Areas area = null;
		for (Areas a : Areas.values()) {
			if (a.name().equalsIgnoreCase(args[2])) {
				area = a;
				break;
			}
		}
		if (area == null) {
			System.err.println("Área inválida. Válidas: " + Arrays.toString(Areas.values()));
			return;
		}

		Type type = null;
		for (Type t : Type.values()) {
			if (t.name().equalsIgnoreCase(args[3])) {
				type = t;
				break;
			}
		}
		if (type == null) {
			System.err.println("Tipo inválido. Válidos: " + Arrays.toString(Type.values()));
			return;
		}

		System.out.println(ip + " " + port + " " + area + " " + type);
	}
	
}
