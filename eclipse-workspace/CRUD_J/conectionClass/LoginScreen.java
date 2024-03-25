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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class LoginScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtUser;
	private JLabel labelSenha;
	private JLabel labelUsuario;
	private JLabel labelEntrada;
	private JLabel imageLogo;

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
	
	public class MouseEventos extends MouseAdapter{

	    @Override
	    public void mouseClicked(MouseEvent e) {
	        super.mouseClicked(e);
	        SignUpUserScreen exibir = new SignUpUserScreen();
			exibir.setVisible(true);
			setVisible(false);
	    }
	    
	    @Override
	    public void mouseEntered(MouseEvent e) {
	        ((JLabel) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
	        ((JLabel) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	    }
	    
	}
	
	public LoginScreen() {
		setBackground(new Color(255, 255, 255));
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Roboto", Font.PLAIN, 32));
		txtPassword.setBounds(385, 230, 351, 48);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFocusable(false);
		btnLogin.setBackground(new Color(0, 126, 167));
		btnLogin.setForeground(new Color(255, 255, 255));
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
						JOptionPane.showMessageDialog(null, "Falha na conexão, tente novamente mais tarde.");
						e1.printStackTrace();
					}
				}
			}
		});
		btnLogin.setBounds(385, 340, 156, 49);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Roboto", Font.PLAIN, 32));
		txtUser.setBounds(385, 136, 351, 48);
		txtUser.setColumns(10);
		contentPane.add(txtUser);
		contentPane.add(txtPassword);
		contentPane.add(btnLogin);
		
		labelSenha = new JLabel("Senha:");
		labelSenha.setFont(new Font("Roboto", Font.PLAIN, 24));
		labelSenha.setLabelFor(txtPassword);
		labelSenha.setBounds(385, 195, 351, 24);
		contentPane.add(labelSenha);
		
		labelUsuario = new JLabel("Usuário:");
		labelUsuario.setFont(new Font("Roboto", Font.PLAIN, 24));
		labelUsuario.setLabelFor(txtUser);
		labelUsuario.setBounds(385, 101, 351, 24);
		contentPane.add(labelUsuario);
		
		labelEntrada = new JLabel("LOGIN");
		labelEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		labelEntrada.setFont(new Font("Segoe UI", Font.BOLD, 48));
		labelEntrada.setBounds(330, 11, 444, 52);
		contentPane.add(labelEntrada);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 52, 89));
		panel.setBounds(0, 0, 320, 441);
		contentPane.add(panel);
		panel.setLayout(null);
		
		imageLogo = new JLabel("");
		imageLogo.setHorizontalAlignment(SwingConstants.CENTER);
		imageLogo.setIcon(new ImageIcon("C:\\Users\\Pichau\\eclipse-workspace\\CRUD_J\\assets\\freelogo.png"));
		imageLogo.setBounds(10, 111, 300, 219);
		panel.add(imageLogo);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFocusable(false);
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Roboto", Font.BOLD, 18));
		btnSair.setBackground(new Color(0, 126, 167));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (dialogResult == 0) {
					System.exit(0);
				}
			}
		});
		btnSair.setBounds(580, 340, 156, 49);
		contentPane.add(btnSair);
		
		JLabel labelPergunta = new JLabel("Não possui uma conta?");
		labelPergunta.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelPergunta.setBounds(385, 282, 351, 24);
		contentPane.add(labelPergunta);
		
		JLabel labelRegistre = new JLabel("<html><u>Registre-se!</u>");
		labelRegistre.setForeground(new Color(0, 168, 232));
		labelRegistre.setFont(new Font("Roboto", Font.ITALIC, 14));
		labelRegistre.addMouseListener(new MouseEventos());
		labelRegistre.setBounds(535, 284, 201, 20);
		contentPane.add(labelRegistre);
	}
}
