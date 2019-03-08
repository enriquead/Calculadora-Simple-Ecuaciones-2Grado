package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;

import logica.Calculadora;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VCalculadora extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Calculadora c;
	private JPanel contentPane;
	private JTextField textFieldres1;
	private JTextField textField2;
	private JTextField textField1;
	private JTextField txt3;
	private JTextField textres2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MistAquaSkin");
					VCalculadora frame = new VCalculadora();
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
	public VCalculadora() {
		this.c = new Calculadora();
		setResizable(false);
		setTitle("Calculadora de ecuaciones de 2 grado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAceptar = new JButton("Calcular");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comprobarNoVacio()==true){
					calcularResultado();
				}
			}
		});
		btnAceptar.setBounds(240, 237, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnResetear = new JButton("Resetear");
		btnResetear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetAll();
			}
		});
		btnResetear.setBounds(339, 237, 89, 23);
		contentPane.add(btnResetear);
		
		JLabel lbl1 = new JLabel("Introduzca el primer coeficiente(x^2):");
		lbl1.setForeground(Color.BLACK);
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl1.setBounds(44, 24, 233, 14);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("Introduzca el segundo coeficiente(x) :");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl2.setBackground(Color.WHITE);
		lbl2.setForeground(Color.BLACK);
		lbl2.setBounds(44, 64, 233, 14);
		contentPane.add(lbl2);
		
		JLabel lblIntroduzcaElTercer = new JLabel("Introduzca el tercer coeficiente :");
		lblIntroduzcaElTercer.setForeground(Color.BLACK);
		lblIntroduzcaElTercer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIntroduzcaElTercer.setBounds(44, 107, 233, 14);
		contentPane.add(lblIntroduzcaElTercer);
		
		JLabel lblElResultado = new JLabel("Resultado 1:");
		lblElResultado.setForeground(Color.BLACK);
		lblElResultado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblElResultado.setBounds(44, 176, 86, 14);
		contentPane.add(lblElResultado);
		
		textFieldres1 = new JTextField();
		textFieldres1.setEditable(false);
		textFieldres1.setBounds(118, 173, 112, 20);
		contentPane.add(textFieldres1);
		textFieldres1.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setBounds(309, 104, 86, 20);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(309, 61, 86, 20);
		contentPane.add(textField2);
		
		textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setBounds(309, 21, 86, 20);
		contentPane.add(textField1);
		
		JLabel lblResultado = new JLabel("Resultado 2:");
		lblResultado.setForeground(Color.BLACK);
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResultado.setBounds(240, 176, 89, 14);
		contentPane.add(lblResultado);
		
		textres2 = new JTextField();
		textres2.setEditable(false);
		textres2.setBounds(321, 173, 113, 20);
		contentPane.add(textres2);
		textres2.setColumns(10);
	}
	public void calcularResultado(){
		textFieldres1.setText(String.valueOf(c.getRootA(Double.parseDouble(textField1.getText()), Double.parseDouble(textField2.getText()),Double.parseDouble(txt3.getText()))));
		textres2.setText(String.valueOf(c.getRootB(Double.parseDouble(textField1.getText()), Double.parseDouble(textField2.getText()),Double.parseDouble(txt3.getText()))));
	}
	public void resetAll(){
		textField1.setText("");
		textField2.setText("");
		txt3.setText("");
		textFieldres1.setText("");
		textres2.setText("");
	}
	public boolean comprobarNoVacio(){
	if(textField1.getText().isEmpty()||textField2.getText().isEmpty()||txt3.getText().isEmpty()){
		JOptionPane.showMessageDialog(this, "Los campos de los coeficientes no pueden estar vacíos.\nSi el coeficiente no aparece en la ecuación debe introducir un 0 ");
		return false;
	}
	return true;
	}
}
