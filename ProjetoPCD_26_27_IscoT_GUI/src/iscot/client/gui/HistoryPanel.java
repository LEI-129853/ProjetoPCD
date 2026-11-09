package iscot.client.gui;

import java.awt.BorderLayout;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class HistoryPanel extends JPanel {
	
	private static final DateTimeFormatter HORA = DateTimeFormatter.ofPattern("HH:mm:ss");
	private final JTextArea area = new JTextArea(6, 25);
		
	public HistoryPanel() {
		super(new BorderLayout());
		area.setEditable(false);
		setBorder(BorderFactory.createTitledBorder("Historico"));
		add(new JScrollPane(area), BorderLayout.CENTER);
	}
	
	public void adicionar(String acao) {
		String linha = acao + " - " + LocalTime.now().format(HORA) + "\n";
		SwingUtilities.invokeLater(() -> area.append(linha));
	}
}
