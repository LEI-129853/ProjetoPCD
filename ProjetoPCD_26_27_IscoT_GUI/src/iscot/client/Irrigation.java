package iscot.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.HistoryPanel;
import iscot.client.gui.IrrigationIcon;
import iscot.enums.Areas;

public class Irrigation {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		if (args.length != 3) {
			System.err.println("Invalid arguments!");
			return;
		}
		Areas area = Utils.lerArea(args[2]);
		if (area == null) return;

		JFrame janela = new JFrame("Rega em " + area);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel painel = new JPanel(new BorderLayout());
		IrrigationIcon rega = new IrrigationIcon();
		HistoryPanel historico = new HistoryPanel();
		painel.add(rega, BorderLayout.CENTER);
		painel.add(historico, BorderLayout.SOUTH);

		janela.setContentPane(painel);
		janela.setLocation(600, 400);
		janela.pack();
		janela.setVisible(true);

		// Fase 1: ordens hardcoded para testar a GUI
		Thread.sleep(3000);
		rega.setAtiva(true);
		historico.adicionar("Rega ligada");

		Thread.sleep(3000);
		rega.setAtiva(false);
		historico.adicionar("Rega desligada");

	}

}
