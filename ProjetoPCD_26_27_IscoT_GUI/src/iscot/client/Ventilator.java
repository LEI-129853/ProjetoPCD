package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.HistoryPanel;
import iscot.client.gui.VentilatorIcon;
import iscot.enums.Areas;

public class Ventilator {

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 3) {
			System.err.println("Invalid arguments!");
			return;
		}
		Areas area = Utils.lerArea(args[2]);
		if (area == null) return;

		JFrame janela = new JFrame("Ventilador em " + area);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel painel = new JPanel(new BorderLayout());
		VentilatorIcon ventilador = new VentilatorIcon();
		HistoryPanel historico = new HistoryPanel();
		painel.add(ventilador, BorderLayout.CENTER);
		painel.add(historico, BorderLayout.SOUTH);

		janela.setContentPane(painel);
		janela.setLocation(600, 400);
		janela.pack();
		janela.setVisible(true);

		// Fase 1: ordens hardcoded para testar a GUI
		Thread.sleep(3000);
		ventilador.setLigado(true);
		historico.adicionar("Ventilação ligada");

		Thread.sleep(3000);
		ventilador.setLigado(false);
		historico.adicionar("Ventilação desligada");
	}
}