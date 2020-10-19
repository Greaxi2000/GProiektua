package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.Bezero;
import domain.Dibisa;
import domain.Kontua;
import domain.Sukurtsal;

public class DibisakSaldu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private JLabel lblKontua;
	private JComboBox comboBox_1;
	private JLabel lblSukurtsal;
	private JComboBox comboBox_2;
	private JLabel lblDibisa;
	private JLabel lblKopurua;
	private JButton btnTransakzioaEgin;
	
	JButton btnNewButton;

	
	
	private DefaultComboBoxModel<Integer> sukurtsalInfo = new DefaultComboBoxModel<Integer>();
    private Collection<Sukurtsal> sukurtsalCollection;
	private Integer selectedSukurtsal;
	
	private DefaultComboBoxModel<String> dibisaInfo = new DefaultComboBoxModel<String>();
    private Collection<Dibisa> dibisaCollection;
	private String selectedDibisa;
	
	private Collection<Kontua> kontuCollection;
	private DefaultComboBoxModel<Integer> kontuInfo = new DefaultComboBoxModel<Integer>();
	private Integer selectedKontu;
	private JTextField textField_1;
	private JLabel lblTransakzioaEgokiGauzatu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DibisakSaldu frame = new DibisakSaldu();
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
	public DibisakSaldu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(113, 16, 285, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
	
		
		JLabel lblNan = new JLabel("NAN");
		lblNan.setBounds(45, 19, 69, 20);
		contentPane.add(lblNan);
		
		btnNewButton = new JButton("Sartu nan");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BLFacade bl=MainGUI.getBusinessLogic();
				//Nan-aren bidez lortu bezeroa
				Bezero bez = bl.getUser(textField.getText());
				kontuCollection = bez.getKontuak();
				kontuInfo.removeAllElements();
				for (Kontua v : kontuCollection)  kontuInfo.addElement(v.getID());

				sukurtsalCollection = bl.getSukurtsalak();
				sukurtsalInfo.removeAllElements();
				for (Sukurtsal v : sukurtsalCollection)  sukurtsalInfo.addElement(v.getID());
				
				dibisaCollection = bl.getDibisak();
				dibisaInfo.removeAllElements();
				for (Dibisa v : dibisaCollection)  dibisaInfo.addElement(v.getMota());
			
				btnTransakzioaEgin.setEnabled(true);
			}
		});
		btnNewButton.setBounds(433, 15, 115, 29);
		contentPane.add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setBounds(113, 58, 285, 26);
		contentPane.add(comboBox);
		comboBox.setModel(kontuInfo);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
					selectedKontu = (Integer) comboBox.getSelectedItem();
					
							
			}

			
			
		});
		
		lblKontua = new JLabel("Kontua");
		lblKontua.setBounds(29, 61, 69, 20);
		contentPane.add(lblKontua);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(113, 127, 285, 26);
		contentPane.add(comboBox_1);
		comboBox_1.setModel(sukurtsalInfo);
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
					selectedSukurtsal = (Integer) comboBox_1.getSelectedItem();
					
							
			}
		});
		lblSukurtsal = new JLabel("Sukurtsal");
		lblSukurtsal.setBounds(15, 130, 69, 20);
		contentPane.add(lblSukurtsal);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(113, 169, 285, 26);
		contentPane.add(comboBox_2);
		comboBox_2.setModel(dibisaInfo);
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
					selectedDibisa = (String) comboBox_2.getSelectedItem();
							
			}
		});
		
		lblDibisa = new JLabel("Dibisa");
		lblDibisa.setBounds(15, 172, 69, 20);
		contentPane.add(lblDibisa);
		
		
		lblKopurua = new JLabel("Kopurua");
		lblKopurua.setBounds(413, 172, 69, 20);
		contentPane.add(lblKopurua);
		
		btnTransakzioaEgin = new JButton("Transakzioa egin");
		btnTransakzioaEgin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BLFacade bl=MainGUI.getBusinessLogic();
			
				bl.dibisaSaldu(selectedKontu, selectedSukurtsal, selectedDibisa, Float.parseFloat(textField_1.getText()));
				
				btnTransakzioaEgin.setEnabled(false);
				lblTransakzioaEgokiGauzatu.setVisible(true);
			}
		});
		btnTransakzioaEgin.setBounds(210, 253, 188, 53);
		contentPane.add(btnTransakzioaEgin);
		btnTransakzioaEgin.setEnabled(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(477, 169, 91, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				btnTransakzioaEgin.setEnabled(true);
				lblTransakzioaEgokiGauzatu.setVisible(false);
				
				JFrame a=new MainGUI();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnAtzera.setBounds(444, 265, 104, 29);
		contentPane.add(btnAtzera);
		
		
		
		lblTransakzioaEgokiGauzatu = new JLabel("Transakzioa egoki gauzatu da");
		lblTransakzioaEgokiGauzatu.setBounds(194, 310, 256, 20);
		contentPane.add(lblTransakzioaEgokiGauzatu);
		lblTransakzioaEgokiGauzatu.setVisible(false);
		
	}
}


