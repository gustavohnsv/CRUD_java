package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.ConnectionBuilder;
import cryptography.Cryptography;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignUpUserScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelConfirmaSenha;
	private JLabel labelInsiraSenha;
	private JTextField txtUsername;
	private JLabel labelUsuario;
	private JButton btnCadastrarUsuario;
	private JButton btnVoltar;
	private JPasswordField txtConfirmPassword;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpUserScreen frame = new SignUpUserScreen();
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
	public SignUpUserScreen() {
		setTitle("Cadastro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel ladoEsquerdo = new JPanel();
		ladoEsquerdo.setBackground(new Color(0, 52, 89));
		ladoEsquerdo.setBounds(464, 0, 320, 441);
		contentPane.add(ladoEsquerdo);
		ladoEsquerdo.setLayout(null);
		
		JLabel imageLogo = new JLabel("");
		imageLogo.setHorizontalAlignment(SwingConstants.CENTER);
		imageLogo.setIcon(new ImageIcon("C:\\Users\\Pichau\\eclipse-workspace\\CRUD_J\\assets\\freelogo.png"));
		imageLogo.setBounds(10, 111, 300, 219);
		ladoEsquerdo.add(imageLogo);
		
		JPanel ladoDireito = new JPanel();
		ladoDireito.setBackground(new Color(255, 255, 255));
		ladoDireito.setBounds(0, 0, 464, 441);
		contentPane.add(ladoDireito);
		ladoDireito.setLayout(null);
		
		JLabel labalCadastro = new JLabel("CADASTRO");
		labalCadastro.setFont(new Font("Segoe UI", Font.BOLD, 48));
		labalCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		labalCadastro.setBounds(10, 11, 444, 52);
		ladoDireito.add(labalCadastro);
		
		labelConfirmaSenha = new JLabel("Confirme a senha:");
		labelConfirmaSenha.setFont(new Font("Roboto", Font.PLAIN, 24));
		labelConfirmaSenha.setBounds(56, 249, 351, 29);
		ladoDireito.add(labelConfirmaSenha);
		
		labelInsiraSenha = new JLabel("Insira uma senha:");
		labelInsiraSenha.setFont(new Font("Roboto", Font.PLAIN, 24));
		labelInsiraSenha.setBounds(56, 162, 351, 29);
		ladoDireito.add(labelInsiraSenha);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Roboto", Font.PLAIN, 32));
		txtUsername.setColumns(10);
		txtUsername.setBounds(56, 103, 351, 48);
		ladoDireito.add(txtUsername);
		
		labelUsuario = new JLabel("Insira o nome de usuário:");
		labelUsuario.setFont(new Font("Roboto", Font.PLAIN, 24));
		labelUsuario.setBounds(56, 74, 351, 29);
		ladoDireito.add(labelUsuario);
		
		btnCadastrarUsuario = new JButton("Cadastrar");
		btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtUsername.getText().equals("") || new String (txtPassword.getPassword()).equals("") || new String (txtConfirmPassword.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente.");
				} else {
				
					try {
						Connection con = ConnectionBuilder.connectDB();
						String sql = "insert into userdata(username, keyword) values (?, ?)";
						PreparedStatement stmt = con.prepareStatement(sql);
						stmt.setString(1, txtUsername.getText());
						if (!new String(txtPassword.getPassword()).equals(new String(txtConfirmPassword.getPassword()))) {
							JOptionPane.showMessageDialog(null, "As senhas não coincidem.");
						} else {
							
							Cryptography cryptoPassword = new Cryptography(new String (txtPassword.getPassword()), Cryptography.MD5); // Trecho do código responsável por criptografar senha 
							stmt.setString(2, cryptoPassword.toCryptography());
							
							stmt.execute();
							JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
							stmt.close();
							con.close();
							LoginScreen exibir = new LoginScreen();
							exibir.setVisible(true);
							setVisible(false);
						}
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Falha na conexão, tente novamente mais tarde.");
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnCadastrarUsuario.setFocusable(false);
		btnCadastrarUsuario.setForeground(new Color(255, 255, 255));
		btnCadastrarUsuario.setBackground(new Color(0, 126, 167));
		btnCadastrarUsuario.setFont(new Font("Roboto", Font.BOLD, 18));
		btnCadastrarUsuario.setBounds(56, 361, 156, 49);
		ladoDireito.add(btnCadastrarUsuario);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginScreen exibir = new LoginScreen();
				exibir.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setFocusable(false);
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(0, 126, 167));
		btnVoltar.setFont(new Font("Roboto", Font.BOLD, 18));
		btnVoltar.setBounds(251, 361, 156, 49);
		ladoDireito.add(btnVoltar);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setFont(new Font("Roboto", Font.PLAIN, 32));
		txtConfirmPassword.setBounds(56, 276, 351, 48);
		ladoDireito.add(txtConfirmPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Roboto", Font.PLAIN, 32));
		txtPassword.setBounds(56, 190, 351, 48);
		ladoDireito.add(txtPassword);
	}
}
