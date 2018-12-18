package com.valentin.morpion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private String signe_x;
	private String signe_o;
	private String nom_Joueur_1,nom_Joueur_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		nom_Joueur_1="";
		nom_Joueur_2="";
		signe_x="";
		signe_o="";
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 218, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(304, 218, 116, 22);
		frame.getContentPane().add(textField_2);
		
		JLabel lblJoueur = new JLabel("joueur 1");
		lblJoueur.setBounds(12, 189, 56, 16);
		frame.getContentPane().add(lblJoueur);
		
		JLabel lblJoueur_1 = new JLabel("joueur 2");
		lblJoueur_1.setBounds(304, 189, 56, 16);
		frame.getContentPane().add(lblJoueur_1);
		
		JLabel label_x = new JLabel("X");
		label_x.setForeground(Color.BLUE);
		label_x.setFont(new Font("Impact", Font.PLAIN, 20));
		label_x.setBounds(80, 189, 56, 16);
		frame.getContentPane().add(label_x);
		
		JLabel label_o = new JLabel("O");
		label_o.setForeground(Color.RED);
		label_o.setFont(new Font("Impact", Font.PLAIN, 20));
		label_o.setBounds(372, 189, 56, 16);
		frame.getContentPane().add(label_o);
		
		JButton btnNewButton = new JButton("GO!");
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textField_1.getText().equalsIgnoreCase("") && !textField_2.getText().equalsIgnoreCase("")  )
				{
					nom_Joueur_1=textField_1.getText();
					nom_Joueur_2=textField_2.getText();
					signe_x=label_x.getText();
					signe_o=label_o.getText();
					Joueur joueur_1 = new Joueur(nom_Joueur_1,signe_x);
					Joueur joueur_2 = new Joueur(nom_Joueur_2,signe_o);
					Menu.this.frame.setVisible(false);
					Morpion window = new Morpion(joueur_1, joueur_2, Menu.this.frame);
					
				}
			}
		});
		btnNewButton.setBounds(167, 217, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("bienvenue dans le morpion");
		lblNewLabel.setBounds(132, 13, 174, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblChoisirLeNom = new JLabel("choisir le nom des joueurs");
		lblChoisirLeNom.setBounds(132, 96, 180, 16);
		frame.getContentPane().add(lblChoisirLeNom);
		
		
	}
}
