package com.valentin.morpion;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class Morpion {
	private JOptionPane popup;
	private JFrame frame;
	private int tour_tot;
	private Joueur joueur1;
	private Joueur joueur2;
	private JButton boutton_11,boutton_21,boutton_31,boutton_12,boutton_22,boutton_32,boutton_13,boutton_23,boutton_33,boutton_restart;
	private String victoire;
	private int coupJoueur1,coupJoueur2;
	private JLabel label_tour;
	private int victoireJoueur1,victoireJoueur2;

	/**
	 * Create the application.
	 */
	public Morpion(Joueur joueur1, Joueur joueur2, JFrame f) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		popup = new JOptionPane();
		victoire="";
		coupJoueur1=0;
		coupJoueur2=0;
		victoireJoueur1=0;
		victoireJoueur2=0;
		tour_tot =0;
		frame = new JFrame();
		frame.setBounds(100, 100, 477, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 450, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {63, 100, 100, 100, 0};
		gridBagLayout.rowHeights = new int[] {87, 5, 10, 100, 100, 100, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		//label_tour.setText("au tour de "+Morpion.this.joueur1.nom_Joueur );
		label_tour = new JLabel("au tour de "+Morpion.this.joueur1.nom_Joueur );
		GridBagConstraints gbc_label_tour = new GridBagConstraints();
		gbc_label_tour.gridwidth = 2;
		gbc_label_tour.fill = GridBagConstraints.BOTH;
		gbc_label_tour.insets = new Insets(0, 0, 5, 5);
		gbc_label_tour.gridx = 1;
		gbc_label_tour.gridy = 0;
		frame.getContentPane().add(label_tour, gbc_label_tour);
		
		boutton_restart = new JButton("restart");
		boutton_restart.setEnabled(false);
		GridBagConstraints gbc_boutton_restart = new GridBagConstraints();
		gbc_boutton_restart.insets = new Insets(0, 0, 5, 0);
		gbc_boutton_restart.gridx = 3;
		gbc_boutton_restart.gridy = 0;
		frame.getContentPane().add(boutton_restart, gbc_boutton_restart);
		
		label_victoire1 = new JLabel("victoires "+Morpion.this.joueur1.nom_Joueur+"="+victoireJoueur1);
		GridBagConstraints gbc_label_victoire1 = new GridBagConstraints();
		gbc_label_victoire1.gridwidth = 2;
		gbc_label_victoire1.fill = GridBagConstraints.BOTH;
		gbc_label_victoire1.insets = new Insets(0, 0, 5, 5);
		gbc_label_victoire1.gridx = 1;
		gbc_label_victoire1.gridy = 1;
		frame.getContentPane().add(label_victoire1, gbc_label_victoire1);
		
		label_victoire2 = new JLabel("victoires "+Morpion.this.joueur2.nom_Joueur+"="+victoireJoueur2);
		GridBagConstraints gbc_label_victoire2 = new GridBagConstraints();
		gbc_label_victoire2.gridwidth = 2;
		gbc_label_victoire2.fill = GridBagConstraints.BOTH;
		gbc_label_victoire2.insets = new Insets(0, 0, 5, 5);
		gbc_label_victoire2.gridx = 1;
		gbc_label_victoire2.gridy = 2;
		frame.getContentPane().add(label_victoire2, gbc_label_victoire2);
		
		boutton_11 = new JButton("");
		GridBagConstraints gbc_boutton_11 = new GridBagConstraints();
		gbc_boutton_11.fill = GridBagConstraints.BOTH;
		gbc_boutton_11.insets = new Insets(0, 0, 5, 5);
		gbc_boutton_11.gridx = 1;
		gbc_boutton_11.gridy = 3;
		frame.getContentPane().add(boutton_11, gbc_boutton_11);
		
		boutton_21 = new JButton("");
		GridBagConstraints gbc_boutton_21 = new GridBagConstraints();
		gbc_boutton_21.fill = GridBagConstraints.BOTH;
		gbc_boutton_21.insets = new Insets(0, 0, 5, 5);
		gbc_boutton_21.gridx = 2;
		gbc_boutton_21.gridy = 3;
		frame.getContentPane().add(boutton_21, gbc_boutton_21);
		
		boutton_31 = new JButton("");
		GridBagConstraints gbc_boutton_31 = new GridBagConstraints();
		gbc_boutton_31.fill = GridBagConstraints.BOTH;
		gbc_boutton_31.insets = new Insets(0, 0, 5, 0);
		gbc_boutton_31.gridx = 3;
		gbc_boutton_31.gridy = 3;
		frame.getContentPane().add(boutton_31, gbc_boutton_31);
		
		boutton_12 = new JButton("");
		GridBagConstraints gbc_boutton_12 = new GridBagConstraints();
		gbc_boutton_12.fill = GridBagConstraints.BOTH;
		gbc_boutton_12.insets = new Insets(0, 0, 5, 5);
		gbc_boutton_12.gridx = 1;
		gbc_boutton_12.gridy = 4;
		frame.getContentPane().add(boutton_12, gbc_boutton_12);
		
		boutton_22 = new JButton("");
		GridBagConstraints gbc_boutton_22 = new GridBagConstraints();
		gbc_boutton_22.fill = GridBagConstraints.BOTH;
		gbc_boutton_22.insets = new Insets(0, 0, 5, 5);
		gbc_boutton_22.gridx = 2;
		gbc_boutton_22.gridy = 4;
		frame.getContentPane().add(boutton_22, gbc_boutton_22);
		
		boutton_32 = new JButton("");
		GridBagConstraints gbc_boutton_32 = new GridBagConstraints();
		gbc_boutton_32.fill = GridBagConstraints.BOTH;
		gbc_boutton_32.insets = new Insets(0, 0, 5, 0);
		gbc_boutton_32.gridx = 3;
		gbc_boutton_32.gridy = 4;
		frame.getContentPane().add(boutton_32, gbc_boutton_32);
		
		boutton_13 = new JButton("");
		GridBagConstraints gbc_boutton_13 = new GridBagConstraints();
		gbc_boutton_13.fill = GridBagConstraints.BOTH;
		gbc_boutton_13.insets = new Insets(0, 0, 0, 5);
		gbc_boutton_13.gridx = 1;
		gbc_boutton_13.gridy = 5;
		frame.getContentPane().add(boutton_13, gbc_boutton_13);
		
		boutton_23 = new JButton("");
		GridBagConstraints gbc_boutton_23 = new GridBagConstraints();
		gbc_boutton_23.fill = GridBagConstraints.BOTH;
		gbc_boutton_23.insets = new Insets(0, 0, 0, 5);
		gbc_boutton_23.gridx = 2;
		gbc_boutton_23.gridy = 5;
		frame.getContentPane().add(boutton_23, gbc_boutton_23);
		
		boutton_33 = new JButton("");
		GridBagConstraints gbc_boutton_33 = new GridBagConstraints();
		gbc_boutton_33.fill = GridBagConstraints.BOTH;
		gbc_boutton_33.gridx = 3;
		gbc_boutton_33.gridy = 5;
		frame.getContentPane().add(boutton_33, gbc_boutton_33);
		
		boutton_11.addActionListener(actionNumero);
		boutton_21.addActionListener(actionNumero);
		boutton_31.addActionListener(actionNumero);
		boutton_12.addActionListener(actionNumero);
		boutton_22.addActionListener(actionNumero);
		boutton_32.addActionListener(actionNumero);
		boutton_13.addActionListener(actionNumero);
		boutton_23.addActionListener(actionNumero);
		boutton_33.addActionListener(actionNumero);
		boutton_restart.addActionListener(reset);
		
		
	}
	public void test_win()
	{
		//test lignes
		if(boutton_11.getText().equals(boutton_21.getText())&& boutton_11.getText().equals(boutton_31.getText()) && !boutton_11.getText().equals(""))
		{
			victoire=boutton_11.getText();
		}
		else if(boutton_12.getText().equals(boutton_22.getText())&& boutton_12.getText().equals(boutton_32.getText()) && !boutton_12.getText().equals(""))
		{
			victoire=boutton_12.getText();
		}
		else if(boutton_13.getText().equals(boutton_23.getText())&& boutton_13.getText().equals(boutton_33.getText()) && !boutton_13.getText().equals(""))
		{
			victoire=boutton_11.getText();
		}
		//colonnes
		else if(boutton_11.getText().equals(boutton_12.getText())&& boutton_11.getText().equals(boutton_13.getText()) && !boutton_11.getText().equals(""))
		{
			victoire=boutton_11.getText();
		}
		else if(boutton_21.getText().equals(boutton_22.getText())&& boutton_21.getText().equals(boutton_23.getText()) && !boutton_21.getText().equals(""))
		{
			victoire=boutton_21.getText();
		}
		else if(boutton_31.getText().equals(boutton_32.getText())&& boutton_31.getText().equals(boutton_33.getText()) && !boutton_31.getText().equals(""))
		{
			victoire=boutton_21.getText();
		}
		//diagonales
		else if(boutton_11.getText().equals(boutton_22.getText())&& boutton_11.getText().equals(boutton_33.getText()) && !boutton_11.getText().equals(""))
		{
			victoire=boutton_22.getText();
		}
		else if(boutton_31.getText().equals(boutton_22.getText())&& boutton_31.getText().equals(boutton_13.getText()) && !boutton_31.getText().equals(""))
		{
			victoire=boutton_11.getText();
		}
		else if (!boutton_11.getText().equals("")&&!boutton_12.getText().equals("")&&!boutton_13.getText().equals("")&&!boutton_21.getText().equals("")&&!boutton_22.getText().equals("")&&!boutton_23.getText().equals("")&&!boutton_31.getText().equals("")&&!boutton_32.getText().equals("")&&!boutton_33.getText().equals(""))
		{
			victoire="0";
		}
		
		
	}
	ActionListener actionNumero = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JButton boutton =(JButton)arg0.getSource();
			if(boutton.getText().equals("")&& victoire.equals(""))
			{
				if(tour_tot%2==0)
				{
					label_tour.setText("au tour de "+Morpion.this.joueur2.nom_Joueur);
					boutton.setText(Morpion.this.joueur1.signe);
					boutton.setForeground(Color.blue);
				
					coupJoueur1++;
					test_win();
					if(victoire.equals(Morpion.this.joueur1.signe))
					{
						boutton_restart.setEnabled(true);
						victoireJoueur1++;
						label_victoire1.setText("victoires "+Morpion.this.joueur1.nom_Joueur+"="+victoireJoueur1);
						label_tour.setText("fin !" );
						popup.showMessageDialog(null,Morpion.this.joueur1.nom_Joueur + " a gagné en "+coupJoueur1+"coups !","information",popup.INFORMATION_MESSAGE);

					}
					else if(victoire.equals("0"))
					{
						boutton_restart.setEnabled(true);
						popup.showMessageDialog(null,"match nul !","information",popup.INFORMATION_MESSAGE);
						label_tour.setText("fin !" );
					}
				
				}
				else if(tour_tot%2==1)
				{	
					label_tour.setText("au tour de "+Morpion.this.joueur1.nom_Joueur );
					boutton.setText(Morpion.this.joueur2.signe);
					boutton.setForeground(Color.red);
				
					coupJoueur2++;
					test_win();
					if(victoire.equals(Morpion.this.joueur2.signe))
					{
						boutton_restart.setEnabled(true);
						victoireJoueur2++;
						label_victoire2.setText("victoires "+Morpion.this.joueur2.nom_Joueur+"="+victoireJoueur2);
						label_tour.setText("fin !" );
						popup.showMessageDialog(null,Morpion.this.joueur2.nom_Joueur + " a gagné en "+coupJoueur2+"coups !","information",popup.INFORMATION_MESSAGE);

					}
					else if(victoire.equals("0"))
					{
						boutton_restart.setEnabled(true);
						popup.showMessageDialog(null,"match nul !","information",popup.INFORMATION_MESSAGE);
						label_tour.setText("fin !" );
						
					}
				
				}
				tour_tot++;
			}
		}
		
	};
	ActionListener reset = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JButton boutton =(JButton)arg0.getSource();
			if(victoire.equals(Morpion.this.joueur1.signe))
			{
				tour_tot=0;
				victoire="";
				label_tour.setText(Morpion.this.joueur1.nom_Joueur+" commence !");
			}
			else if(victoire.equals(Morpion.this.joueur2.signe))
			{
				tour_tot=1;
				victoire="";
				label_tour.setText(Morpion.this.joueur2.nom_Joueur+" commence !");
			}
			else if (victoire.equals("0"))
			{
				if(tour_tot%2==0)
				{
					label_tour.setText(Morpion.this.joueur1.nom_Joueur+" commence !");
					tour_tot=0;
					victoire="";
				}
				else if(tour_tot%2==1)
				{
					label_tour.setText(Morpion.this.joueur2.nom_Joueur+" commence !");
					tour_tot=1;
					victoire="";
				}
				
			}
			
			coupJoueur1=0;
			coupJoueur2=0;
			boutton_11.setText("");
			boutton_21.setText("");
			boutton_31.setText("");
			boutton_12.setText("");
			boutton_22.setText("");
			boutton_32.setText("");
			boutton_13.setText("");
			boutton_23.setText("");
			boutton_33.setText("");
			boutton_restart.setEnabled(false);
			
		}
	};
	private JLabel label_victoire1;
	private JLabel label_victoire2;
	
}
