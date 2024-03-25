package conectionClass;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class LoginScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtUser;
	private JLabel labelSenha;
	private JLabel labelUsuario;
	private JLabel labelEntrada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Pichau\\Downloads\\login.png"));
		setTitle("Tela de acesso");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 222, 248));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(77, 167, 130, 36);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setForeground(new Color(0, 255, 128));
		btnLogin.setFont(new Font("Roboto", Font.BOLD, 18));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtUser.getText().equals("") || new String (txtPassword.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente.");
				} else {
				
					try {
						Connection con = ConnectionBuilder.connectDB();
						String sql = "select * from userdata where username=? and keyword=?";
						PreparedStatement stmt = con.prepareStatement(sql);
						stmt.setString(1, txtUser.getText());
						stmt.setString(2, new String (txtPassword.getPassword()));
						ResultSet rs = stmt.executeQuery();
						
						if (rs.next()) {
							JOptionPane.showMessageDialog(null, "Bem vindo ao sistema.");
							SignUpScreen exibir = new SignUpScreen();
							exibir.setVisible(true);
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "Usuário/Senha inválido(s).");
						}
						stmt.close();
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnLogin.setBounds(87, 236, 109, 36);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(77, 84, 129, 36);
		txtUser.setColumns(10);
		contentPane.add(txtUser);
		contentPane.add(txtPassword);
		contentPane.add(btnLogin);
		
		labelSenha = new JLabel("Senha:");
		labelSenha.setFont(new Font("Roboto", Font.BOLD, 14));
		labelSenha.setLabelFor(txtPassword);
		labelSenha.setBounds(77, 142, 129, 14);
		contentPane.add(labelSenha);
		
		labelUsuario = new JLabel("Usuário:");
		labelUsuario.setFont(new Font("Roboto", Font.BOLD, 14));
		labelUsuario.setLabelFor(txtUser);
		labelUsuario.setBounds(77, 59, 129, 14);
		contentPane.add(labelUsuario);
		
		labelEntrada = new JLabel("Tela de Acesso Principal");
		labelEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		labelEntrada.setFont(new Font("Arial", Font.BOLD, 20));
		labelEntrada.setBounds(10, 11, 264, 36);
		contentPane.add(labelEntrada);
	}
}
