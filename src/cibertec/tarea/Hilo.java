package cibertec.tarea;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hilo extends Thread{
	
	private JPanel panel;
	private JLabel lbl;
	
	public Hilo(JLabel lbl, JPanel panel) {
		this.lbl = lbl;
		this.panel = panel;
	}

	@Override
	public void run() {
		try {
			boolean bandera = true;
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
			while(true){
				colorear();
				setearFecha(sdf);
				bandera = parpadear(bandera); //Va a parpadear el "lbl" cada 0.5 segundos.
				sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean parpadear(boolean bandera) {
		bandera = !bandera;
		lbl.setVisible(bandera);
		return bandera;
	}

	private void setearFecha(SimpleDateFormat sdf) {
		Date fecha = new Date();
		lbl.setText(sdf.format(fecha));
	}

	private void colorear() {
		Color colorPanel = null;
		Color colorLabel = null;
		int r,g,b,r1,g1,b1;
		r = aleatorio();
		g = aleatorio();
		b = aleatorio();
		colorPanel = new Color(r, g, b);
		
		r1 = aleatorio();
		g1 = aleatorio();
		b1 = aleatorio();
		colorLabel = new Color(r1, g1, b1);
		
		colorearControles(colorPanel, colorLabel);
	}

	private void colorearControles(Color colorPanel, Color colorLabel) {
		lbl.setForeground(colorLabel);
		panel.setBackground(colorPanel);
	}
	
	
	public int aleatorio(){
		int num = 0;
		num = (int)(Math.random()*(255 - 0 +1)+0);
		return num;
	}

}
