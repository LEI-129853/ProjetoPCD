package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.HistoryPanel;
import iscot.client.gui.VentilatorIcon;
import iscot.enums.Areas;
import iscot.events.AreaVentilationOrderEvent;
import iscot.events.HighLevelOrderEvent;

public class Ventilator {

	private final Areas area;
	private final VentilatorIcon ventilador = new VentilatorIcon();
	private final HistoryPanel historico = new HistoryPanel();

	public Ventilator(Areas area) {
		this.area = area;

		JFrame janela = new JFrame("Ventilador em " + area);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel painel = new JPanel(new BorderLayout());
		painel.add(ventilador, BorderLayout.CENTER);
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
		if (ordem instanceof AreaVentilationOrderEvent) {
			AreaVentilationOrderEvent o = (AreaVentilationOrderEvent) ordem;
			ventilador.setLigado(o.isLigar());
			historico.adicionar(o.isLigar() ? "Ventilação ligada" : "Ventilação desligada");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 3) {
			System.err.println("Invalid arguments!");
			return;
		}
		Areas area = Utils.lerArea(args[2]);
		if (area == null) return;

		Ventilator ventilator = new Ventilator(area);

		Thread.sleep(3000);
		ventilator.aplicarOrdem(new AreaVentilationOrderEvent(area, true));

		Thread.sleep(3000);
		ventilator.aplicarOrdem(new AreaVentilationOrderEvent(Areas.Garden, false));

		Thread.sleep(3000);
		ventilator.aplicarOrdem(new AreaVentilationOrderEvent(area, false));
	}
}