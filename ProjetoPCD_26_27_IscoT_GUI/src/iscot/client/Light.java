package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.HistoryPanel;
import iscot.client.gui.LightIcon;
import iscot.enums.Areas;

public class Light {

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 3) {
			System.err.println("Invalid arguments!");
			return;
		}
		Areas area = Utils.lerArea(args[2]);
		if (area == null) return;

		JFrame janela = new JFrame("Luz em " + area);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel painel = new JPanel(new BorderLayout());
		LightIcon luz = new LightIcon();
		HistoryPanel historico = new HistoryPanel();
		painel.add(luz, BorderLayout.CENTER);
		painel.add(historico, BorderLayout.SOUTH);

		janela.setContentPane(painel);
		janela.setLocation(600, 400);
		janela.pack();
		janela.setVisible(true);

		// Fase 1: ordens hardcoded para testar a GUI
		Thread.sleep(3000);
		luz.setLigada(true);
		historico.adicionar("Lâmpada ligada");

		Thread.sleep(3000);
		luz.setLigada(false);
		historico.adicionar("Lâmpada desligada");
	}
}