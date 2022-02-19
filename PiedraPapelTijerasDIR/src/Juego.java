import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

public class Juego extends JFrame implements ActionListener {
	private JRadioButton opc1, opc2;
	private JLabel j1, j2, nom1, nom2, bal1, ap2, bal2, ap1, mbal1, mbal2, punt1, punt2, enpunt1, enpunt2, gana;
	private ButtonGroup bg;
	private Tiro j1d1, j1d2, j2d1, j2d2;
	private JTextField map1, map2;
	private JButton start;
	private double monto1, monto2, apuesta1, apuesta2;

	public Juego() {
		JOptionPane.showMessageDialog(null, "El juego consiste en dos jugadores, "
				+ "los cuales tendrán dos lanzamientos de dados, realizaran una apuesta y el que"
				+ " obtenga la mayor puntuación, resultado de la suma de los dos lanzamientos, "
				+ "GANA LA APUESTA TOTAL"
				,"¡Bienvenido!", JOptionPane.INFORMATION_MESSAGE);
		setTitle("!!! Apuesta y Gana !!!");
		String nomjug1 = JOptionPane.showInputDialog("Ingresa el nombre del jugador 1:");
		String nomjug2 = JOptionPane.showInputDialog("Ingresa el nombre del jugador 2:");
		String montoini = JOptionPane.showInputDialog("Ingresa el monto inicial de apuesta:");
		setLayout(null);

		j1 = new JLabel("Jugador 1");
		j1.setBounds(70, 30, 100, 30);
		add(j1);
		nom1 = new JLabel(nomjug1);
		nom1.setBounds(140, 30, 100, 30);
		add(nom1);
		j2 = new JLabel("Jugador 2");
		j2.setBounds(280, 30, 100, 30);
		add(j2);
		nom2 = new JLabel(nomjug2);
		nom2.setBounds(350, 30, 100, 30);
		add(nom2);
		bal1 = new JLabel("Balance");
		bal1.setBounds(70, 70, 100, 30);
		add(bal1);
		mbal1 = new JLabel(montoini);
		mbal1.setBounds(140, 70, 100, 30);
		add(mbal1);
		ap1 = new JLabel("Apuesta:");
		ap1.setBounds(70, 110, 100, 30);
		add(ap1);
		bal2 = new JLabel("Balance");
		bal2.setBounds(280, 70, 100, 30);
		add(bal2);
		mbal2 = new JLabel(montoini);
		mbal2.setBounds(350, 70, 100, 30);
		add(mbal2);
		ap2 = new JLabel("Apuesta:");
		ap2.setBounds(280, 110, 100, 30);
		add(ap2);
		map1 = new JTextField();
		map1.setBounds(140, 110, 100, 30);
		add(map1);
		map2 = new JTextField();
		map2.setBounds(350, 110, 100, 30);
		add(map2);
		enpunt1 = new JLabel("" + nomjug1 + ":");
		enpunt1.setBounds(120, 160, 120, 30);
		add(enpunt1);
		punt1 = new JLabel("");
		punt1.setBounds(200, 160, 120, 30);
		add(punt1);
		enpunt2 = new JLabel("" + nomjug2 + ":");
		enpunt2.setBounds(320, 160, 120, 30);
		add(enpunt2);
		punt2 = new JLabel("");
		punt2.setBounds(400, 160, 120, 30);
		add(punt2);
		gana = new JLabel("");
		gana.setBounds(205, 200, 200, 30);
		add(gana);
		bg = new ButtonGroup();
		opc1 = new JRadioButton("Salir");
		opc1.setBounds(70, 240, 100, 30);
		add(opc1);
		bg.add(opc1);
		opc2 = new JRadioButton("Nueva Ronda");
		opc2.setBounds(280, 240, 150, 30);
		add(opc2);
		bg.add(opc2);
		start = new JButton("Aceptar");
		start.setBounds(150, 290, 200, 30);
		add(start);
		start.addActionListener(this);

		j1d1 = new Tiro();
		j1d2 = new Tiro();
		j2d1 = new Tiro();
		j2d2 = new Tiro();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start && opc2.isSelected() == true) {
			comenzar();
		}
		if (e.getSource() == start && opc1.isSelected() == true) {
			System.exit(0);
		}
	}

	public void comenzar() {
		String cadm1 = mbal1.getText();
		monto1 = Double.parseDouble(cadm1);
		String cadm2 = mbal2.getText();
		monto2 = Double.parseDouble(cadm2);
		String cadap1 = map1.getText();
		apuesta1 = Double.parseDouble(cadap1);
		String cadap2 = map2.getText();
		apuesta2 = Double.parseDouble(cadap2);
		j1d1.Lanzar();
		j1d2.Lanzar();
		j1d2.Lanzar();
		j2d2.Lanzar();
		double mf1, mf2;
		int res1 = j1d1.getValor() + j1d2.getValor();
		int res2 = j2d1.getValor() + j2d2.getValor();
		punt1.setText("" + res1);
		punt2.setText("" + res2);
			if (res1 == res2) {
				gana.setText("Es un empate");
			} else if (res1 > res2) {
				gana.setText("Gana Jugador 1");
				mf1 = monto1 + apuesta1;
				mf2 = monto2 - apuesta2;
				mbal1.setText("" + mf1);
				mbal2.setText("" + mf2);
			} else {
				gana.setText("Gana Jugador 2");
				mf2 = monto2 + apuesta1;
				mf1 = monto1 - apuesta2;
				mbal1.setText("" + mf1);
				mbal2.setText("" + mf2);
			}
			
	}

	public static void main(String[] ar) {
		Juego ejec = new Juego();
		ejec.setBounds(540, 180, 500, 380);
		ejec.setVisible(true);
		ejec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
