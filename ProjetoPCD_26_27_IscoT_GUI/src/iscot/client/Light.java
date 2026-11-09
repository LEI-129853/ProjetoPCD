package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.HistoryPanel;
import iscot.client.gui.LightIcon;
import iscot.enums.Areas;
import iscot.events.AreaLightingOrderEvent;
import iscot.events.HighLevelOrderEvent;

public class Light {

	private final Areas area;
	private final LightIcon luz = new LightIcon();
	private final HistoryPanel historico = new HistoryPanel();

	public Light(Areas area) {
		this.area = area;

		JFrame janela = new JFrame("Luz em " + area);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel painel = new JPanel(new BorderLayout());
		painel.add(luz, BorderLayout.CENTER);
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
		if (ordem instanceof AreaLightingOrderEvent) {
			AreaLightingOrderEvent o = (AreaLightingOrderEvent) ordem;
			luz.setLigada(o.isLigar());
			historico.adicionar(o.isLigar() ? "Lâmpada ligada" : "Lâmpada desligada");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 3) {
			System.err.println("Invalid arguments!");
			return;
		}
		Areas area = Utils.lerArea(args[2]);
		if (area == null) return;

		Light light = new Light(area);

		Thread.sleep(3000);
		light.aplicarOrdem(new AreaLightingOrderEvent(area, true));

		Thread.sleep(3000);
		light.aplicarOrdem(new AreaLightingOrderEvent(Areas.Garden, false));

		Thread.sleep(3000);
		light.aplicarOrdem(new AreaLightingOrderEvent(area, false));
	}
}