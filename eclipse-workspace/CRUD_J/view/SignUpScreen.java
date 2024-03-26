package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.ConnectionBuilder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SignUpScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNameCar;
	private JTextField txtModelYear;
	private JTextField txtBrandName;
	private JTextField txtCarColor;
	private JLabel labelMarca;
	private JLabel labelModelo;
	private JLabel labelNome;
	private JLabel labelCor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpScreen frame = new SignUpScreen();
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
	public SignUpScreen() {
		setTitle("Cadastro de veículos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSignInCar = new JButton("Cadastrar");
		btnSignInCar.setFocusable(false);
		btnSignInCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtNameCar.getText().equals("") || txtBrandName.getText().equals("") || 
						txtModelYear.getText().equals("") || txtCarColor.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar, há campos inválidos.");
				} else {
					try {
						Connection con = ConnectionBuilder.connectDB();
						String sql = "insert into cars(carName,brandName,modelYear,carColor) values (?, ?, ?, ?)";
						PreparedStatement stmt = con.prepareStatement(sql);
						stmt.setString(1, txtNameCar.getText());
						stmt.setString(2, txtBrandName.getText());
						stmt.setString(3, txtModelYear.getText());
						stmt.setString(4, txtCarColor.getText());
						stmt.execute();
						
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
						txtNameCar.setText(" ");
						txtBrandName.setText(" ");
						txtModelYear.setText(" ");
						txtCarColor.setText(" ");
							
						stmt.close();
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnSignInCar.setBounds(56, 191, 120, 47);
		contentPane.add(btnSignInCar);
		
		txtNameCar = new JTextField();
		txtNameCar.setBounds(36, 44, 140, 35);
		contentPane.add(txtNameCar);
		txtNameCar.setColumns(10);
		
		txtModelYear = new JTextField();
		txtModelYear.setColumns(10);
		txtModelYear.setBounds(36, 123, 140, 35);
		contentPane.add(txtModelYear);
		
		txtBrandName = new JTextField();
		txtBrandName.setColumns(10);
		txtBrandName.setBounds(246, 44, 140, 35);
		contentPane.add(txtBrandName);
		
		txtCarColor = new JTextField();
		txtCarColor.setColumns(10);
		txtCarColor.setBounds(246, 123, 140, 35);
		contentPane.add(txtCarColor);
		
		labelMarca = new JLabel("Marca do carro:");
		labelMarca.setLabelFor(txtBrandName);
		labelMarca.setBounds(246, 15, 140, 14);
		contentPane.add(labelMarca);
		
		labelModelo = new JLabel("Ano de lançamento:");
		labelModelo.setLabelFor(txtModelYear);
		labelModelo.setBounds(36, 94, 140, 14);
		contentPane.add(labelModelo);
		
		labelNome = new JLabel("Nome do carro:");
		labelNome.setLabelFor(txtNameCar);
		labelNome.setBounds(36, 15, 140, 14);
		contentPane.add(labelNome);
		
		labelCor = new JLabel("Cor do carro:");
		labelCor.setLabelFor(txtCarColor);
		labelCor.setBounds(246, 94, 140, 14);
		contentPane.add(labelCor);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFocusable(false);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (dialogResult == 0) {
					System.exit(0);
				}
			}
		});
		btnSair.setBounds(246, 191, 120, 47);
		contentPane.add(btnSair);
	}
}
