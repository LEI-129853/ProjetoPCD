package iscot.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.ACIcon;
import iscot.client.gui.HistoryPanel;
import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;

public class AirConditioner {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		if (args.length != 3) {
			System.err.println("Invalid arguments!");
			return;
		}
		Areas area = Utils.lerArea(args[2]);
		if (area == null) return;

		JFrame janela = new JFrame("Ar condicionado em " + area);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel painel = new JPanel(new BorderLayout());
		ACIcon ac = new ACIcon();
		HistoryPanel historico = new HistoryPanel();
		painel.add(ac, BorderLayout.CENTER);
		painel.add(historico, BorderLayout.SOUTH);

		janela.setContentPane(painel);
		janela.setLocation(600, 400);
		janela.pack();
		janela.setVisible(true);

		// Fase 1: ordens hardcoded para testar a GUI
		Thread.sleep(3000);
		ac.setModo(AirConditioningMode.Frio);
		historico.adicionar("AC em modo Frio");

		Thread.sleep(3000);
		ac.setModo(AirConditioningMode.Aquecimento);
		historico.adicionar("AC em modo Aquecimento");
		
		Thread.sleep(3000);
		ac.setModo(AirConditioningMode.Desligado);
		historico.adicionar("AC desligado");
	}

}
