package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private static BLFacade appFacadeInterface;

	
	public static BLFacade getBusinessLogic(){
		return appFacadeInterface;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aukeratu egin beharreko eragiketa");
		lblNewLabel.setBounds(112, 50, 252, 20);
		contentPane.add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("Dibisak saldu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a=new DibisakSaldu();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(131, 118, 162, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dibisak erosi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a=new DibisakErosi();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(131, 169, 162, 29);
		contentPane.add(btnNewButton_1);
	}

	public static void setBussinessLogic (BLFacade afi){
		appFacadeInterface=afi;
	}

}
