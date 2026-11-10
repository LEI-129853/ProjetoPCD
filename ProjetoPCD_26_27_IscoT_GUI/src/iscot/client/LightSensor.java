package iscot.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.events.LightSensorEvent;
import iscot.events.SensorEvent;

public class LightSensor {

	
	private static void publicar(SensorEvent evento) {
		System.out.println("Publicado: " + evento);
	}
	
	
	public static void main(String[] args) {
		if(args.length!=3) {
			System.err.println("Invalid arguments!");
		}
		else {
			// TODO connect to the server

			// TODO register with the server
			Areas area = Utils.lerArea(args[2]);
			   if (area == null) return;
			

			JFrame janela = new JFrame("Luz em "+area);
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			
			JPanel painel=new JPanel();
			painel.setLayout(new BorderLayout());
			SensorControl sensorControl= new SensorControl( "☀", "Luz - "+area, "lux",
				    0, 1000, 10, 500,
				    valor -> { publicar(new LightSensorEvent(area, valor));
				    });
			painel.add(sensorControl,BorderLayout.CENTER);
			janela.setContentPane(painel);
			janela.setLocation(600, 400);
			janela.setMinimumSize(janela.getSize());
			janela.pack();
			janela.setVisible(true);
			
		}

	}

}
