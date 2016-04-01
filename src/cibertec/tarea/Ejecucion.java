package cibertec.tarea;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

@SuppressWarnings("serial")
public class Ejecucion extends JFrame {

	private JPanel contentPane;
	private JLabel lblTiempo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejecucion frame = new Ejecucion();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejecucion() {
		setTitle("Reloj Huachafo");
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTiempo = new JLabel("");
		this.lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 65));
		lblTiempo.setBounds(10, 101, 414, 87);
		contentPane.add(lblTiempo);
		
		Hilo ht = new Hilo(lblTiempo,contentPane);
		//Hilo ht = new Hilo(lblTiempo, contentPane);
		ht.start();
	}
	
	
}
