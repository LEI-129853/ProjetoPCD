package iscot.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.events.GroundMoistureSensorEvent;
import iscot.events.SensorEvent;

public class GroundMoistureSensor {

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
			

			JFrame janela = new JFrame("Humidade do solo em " + area);
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			
			// Criar os componentes gráficos
			JPanel painel=new JPanel();
			painel.setLayout(new BorderLayout());
			SensorControl sensorControl= new SensorControl("🌱", "Humidade do solo - " + area, "%",
					 0, 100, 1, 50,
				    valor -> { publicar(new GroundMoistureSensorEvent(area, valor));
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
