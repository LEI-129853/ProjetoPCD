package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.HistoryPanel;
import iscot.client.gui.IrrigationIcon;
import iscot.enums.Areas;
import iscot.events.AreaIrrigationOrderEvent;
import iscot.events.HighLevelOrderEvent;

public class Irrigation {

	private final Areas area;
	private final IrrigationIcon rega = new IrrigationIcon();
	private final HistoryPanel historico = new HistoryPanel();

	public Irrigation(Areas area) {
		this.area = area;

		JFrame janela = new JFrame("Rega em " + area);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel painel = new JPanel(new BorderLayout());
		painel.add(rega, BorderLayout.CENTER);
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
		if (ordem instanceof AreaIrrigationOrderEvent) {
			AreaIrrigationOrderEvent o = (AreaIrrigationOrderEvent) ordem;
			rega.setAtiva(o.isLigar());
			historico.adicionar(o.isLigar() ? "Rega ligada" : "Rega desligada");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 3) {
			System.err.println("Invalid arguments!");
			return;
		}
		Areas area = Utils.lerArea(args[2]);
		if (area == null) return;

		Irrigation irrigation = new Irrigation(area);

		
		Thread.sleep(3000);
		irrigation.aplicarOrdem(new AreaIrrigationOrderEvent(area, true));

		Thread.sleep(3000);
		irrigation.aplicarOrdem(new AreaIrrigationOrderEvent(Areas.Kitchen, false));

		Thread.sleep(3000);
		irrigation.aplicarOrdem(new AreaIrrigationOrderEvent(area, false));
	}
}