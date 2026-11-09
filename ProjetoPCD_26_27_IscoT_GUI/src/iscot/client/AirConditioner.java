package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.ACIcon;
import iscot.client.gui.HistoryPanel;
import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;
import iscot.events.AreaTemperatureOrderEvent;
import iscot.events.HighLevelOrderEvent;

public class AirConditioner {

	private final Areas area;
	private final ACIcon ac = new ACIcon();
	private final HistoryPanel historico = new HistoryPanel();

	public AirConditioner(Areas area) {
		this.area = area;

		JFrame janela = new JFrame("Ar condicionado em " + area);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel painel = new JPanel(new BorderLayout());
		painel.add(ac, BorderLayout.CENTER);
		painel.add(historico, BorderLayout.SOUTH);

		janela.setContentPane(painel);
		janela.setLocation(600, 400);
		janela.pack();
		janela.setVisible(true);
	}

	public void aplicarOrdem(HighLevelOrderEvent ordem) {
		if (ordem.getArea() != area) {
			return;
		}
		if (ordem instanceof AreaTemperatureOrderEvent) {
			AreaTemperatureOrderEvent o = (AreaTemperatureOrderEvent) ordem;
			ac.setModo(o.getModo());
			historico.adicionar("AC: " + o.getModo());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 3) {
			System.err.println("Invalid arguments!");
			return;
		}
		Areas area = Utils.lerArea(args[2]);
		if (area == null) return;

		AirConditioner airConditioner = new AirConditioner(area);

		Thread.sleep(3000);
		airConditioner.aplicarOrdem(new AreaTemperatureOrderEvent(area, AirConditioningMode.Frio));

		Thread.sleep(3000);
		airConditioner.aplicarOrdem(new AreaTemperatureOrderEvent(Areas.Garden, AirConditioningMode.Aquecimento));

		Thread.sleep(3000);
		airConditioner.aplicarOrdem(new AreaTemperatureOrderEvent(area, AirConditioningMode.Aquecimento));

		Thread.sleep(3000);
		airConditioner.aplicarOrdem(new AreaTemperatureOrderEvent(area, AirConditioningMode.Desligado));
	}
}