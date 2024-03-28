package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import connection.ConnectionBuilder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class SignUpScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel right;
	private JPanel left;
	private JTextField txtDocumentID;
	private JTextField txtOwnerID;
	private JTextField txtBrandCar;
	private JTextField txtModelCar;
	private JTextField txtCarColor;
	private final ButtonGroup selectRegister = new ButtonGroup();
	private JTextField txtOwnerName;
	private final ButtonGroup selectDocument = new ButtonGroup();
	private JLabel imagemLogoFundo;

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
	 * @throws ParseException 
	 */
	public SignUpScreen() throws ParseException {
		setTitle("Cadastro de veículos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel footer = new JPanel();
		footer.setBackground(new Color(0, 23, 31));
		footer.setBounds(0, 471, 1008, 90);
		contentPane.add(footer);
		footer.setLayout(null);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Roboto", Font.BOLD, 12));
		btnSair.setBounds(868, 21, 130, 47);
		footer.add(btnSair);
		btnSair.setBackground(new Color(0, 126, 167));
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setFocusable(false);
		
		JButton btnCadastrarVeiculo = new JButton("Cadastrar veículo");
		btnCadastrarVeiculo.setFont(new Font("Roboto", Font.BOLD, 12));
		btnCadastrarVeiculo.setBounds(698, 21, 160, 47);
		footer.add(btnCadastrarVeiculo);
		btnCadastrarVeiculo.setForeground(new Color(255, 255, 255));
		btnCadastrarVeiculo.setBackground(new Color(0, 126, 167));
		btnCadastrarVeiculo.setFocusable(false);
		
		JButton btnBuscarID = new JButton("Buscar por ID");
		btnBuscarID.setFont(new Font("Roboto", Font.BOLD, 12));
		btnBuscarID.setForeground(Color.WHITE);
		btnBuscarID.setFocusable(false);
		btnBuscarID.setBackground(new Color(0, 126, 167));
		btnBuscarID.setBounds(57, 21, 120, 48);
		footer.add(btnBuscarID);
		
		JButton btnAtualizarCadastro = new JButton("Atualizar cadastro");
		btnAtualizarCadastro.setFont(new Font("Roboto", Font.BOLD, 12));
		btnAtualizarCadastro.setForeground(Color.WHITE);
		btnAtualizarCadastro.setFocusable(false);
		btnAtualizarCadastro.setBackground(new Color(0, 126, 167));
		btnAtualizarCadastro.setBounds(358, 21, 160, 47);
		footer.add(btnAtualizarCadastro);
		
		JButton btnCadastrarProprietrio = new JButton("Cadastrar proprietário");
		btnCadastrarProprietrio.setFont(new Font("Roboto", Font.BOLD, 11));
		btnCadastrarProprietrio.setForeground(Color.WHITE);
		btnCadastrarProprietrio.setFocusable(false);
		btnCadastrarProprietrio.setBackground(new Color(0, 126, 167));
		btnCadastrarProprietrio.setBounds(528, 22, 160, 47);
		footer.add(btnCadastrarProprietrio);
		
		JRadioButton rdbtnCadastrarVeiculo = new JRadioButton("Cadastrando veículo");
		rdbtnCadastrarVeiculo.setFocusable(false);
		rdbtnCadastrarVeiculo.setBackground(new Color(0, 23, 31));
		rdbtnCadastrarVeiculo.setForeground(new Color(255, 255, 255));
		selectRegister.add(rdbtnCadastrarVeiculo);
		rdbtnCadastrarVeiculo.setSelected(true);
		rdbtnCadastrarVeiculo.setFont(new Font("Roboto", Font.BOLD, 12));
		rdbtnCadastrarVeiculo.setBounds(183, 21, 169, 23);
		footer.add(rdbtnCadastrarVeiculo);
		
		JRadioButton rdbtnCadastrarDono = new JRadioButton("Cadastrando proprietário");
		rdbtnCadastrarDono.setFocusable(false);
		rdbtnCadastrarDono.setBackground(new Color(0, 23, 31));
		rdbtnCadastrarDono.setForeground(new Color(255, 255, 255));
		selectRegister.add(rdbtnCadastrarDono);
		rdbtnCadastrarDono.setFont(new Font("Roboto", Font.BOLD, 11));
		rdbtnCadastrarDono.setBounds(183, 45, 169, 23);
		footer.add(rdbtnCadastrarDono);
		
		JSpinner spID = new JSpinner();
		spID.setModel(new SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(1)));
		spID.setFont(new Font("Roboto", Font.PLAIN, 18));
		spID.setBounds(10, 21, 48, 47);
		footer.add(spID);
		
		right = new JPanel();
		right.setBackground(new Color(0f, 0f, 0f, 0f));
		right.setBounds(496, 21, 512, 451);
		contentPane.add(right);
		right.setLayout(null);
		
		JLabel labelMarcaVeiculo = new JLabel("Marca do veículo:");
		labelMarcaVeiculo.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelMarcaVeiculo.setBounds(31, 46, 176, 14);
		right.add(labelMarcaVeiculo);
		
		txtBrandCar = new JTextField();
		txtBrandCar.setFont(new Font("Roboto", Font.PLAIN, 22));
		txtBrandCar.setColumns(10);
		txtBrandCar.setBounds(31, 61, 176, 48);
		right.add(txtBrandCar);
		
		JLabel labelModeloVeiculo = new JLabel("Modelo do veículo:");
		labelModeloVeiculo.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelModeloVeiculo.setBounds(305, 46, 176, 14);
		right.add(labelModeloVeiculo);
		
		txtModelCar = new JTextField();
		txtModelCar.setFont(new Font("Roboto", Font.PLAIN, 22));
		txtModelCar.setColumns(10);
		txtModelCar.setBounds(305, 61, 176, 48);
		right.add(txtModelCar);
		
		txtCarColor = new JTextField();
		txtCarColor.setFont(new Font("Roboto", Font.PLAIN, 22));
		txtCarColor.setColumns(10);
		txtCarColor.setBounds(31, 155, 176, 48);
		right.add(txtCarColor);
		
		JLabel labelCorVeiculo = new JLabel("Cor do veículo:");
		labelCorVeiculo.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelCorVeiculo.setBounds(31, 141, 176, 14);
		right.add(labelCorVeiculo);
		
		JLabel labelAnoModelo = new JLabel("Ano do modelo:");
		labelAnoModelo.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelAnoModelo.setBounds(305, 141, 176, 14);
		right.add(labelAnoModelo);
		
		MaskFormatter maskYEAR = new MaskFormatter("####");
		JFormattedTextField txtModelYear = new JFormattedTextField(maskYEAR);
		txtModelYear.setFont(new Font("Roboto", Font.PLAIN, 22));
		txtModelYear.setBounds(305, 155, 176, 48);
		right.add(txtModelYear);
		
		JLabel labelNomeDono = new JLabel("Nome do proprietário:");
		labelNomeDono.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelNomeDono.setBounds(31, 268, 176, 14);
		right.add(labelNomeDono);
		
		txtOwnerName = new JTextField();
		txtOwnerName.setEditable(false);
		txtOwnerName.setFont(new Font("Roboto", Font.PLAIN, 22));
		txtOwnerName.setColumns(10);
		txtOwnerName.setBounds(31, 281, 176, 48);
		right.add(txtOwnerName);
		
		JLabel lblDocumentoDoProprietrio = new JLabel("Documento do proprietário");
		lblDocumentoDoProprietrio.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblDocumentoDoProprietrio.setBounds(305, 268, 176, 14);
		right.add(lblDocumentoDoProprietrio);
		
		MaskFormatter maskCPF = new MaskFormatter("###.###.###-##");
		MaskFormatter maskCNPJ = new MaskFormatter("##.###.###/####.##");
		JFormattedTextField txtOwnerDocument = new JFormattedTextField(maskCPF);
		txtOwnerDocument.setEditable(false);
		txtOwnerDocument.setFont(new Font("Roboto", Font.PLAIN, 22));
		txtOwnerDocument.setBounds(305, 281, 176, 48);
		right.add(txtOwnerDocument);
		
		JRadioButton rdbtnCPF = new JRadioButton("O documento é CPF.");
		rdbtnCPF.setEnabled(false);
		rdbtnCPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnCPF.isSelected()) {
					maskCNPJ.uninstall();
					maskCPF.install(txtOwnerDocument);
				}
			}
		});
		selectDocument.add(rdbtnCPF);
		rdbtnCPF.setSelected(true);
		rdbtnCPF.setForeground(new Color(0, 0, 0));
		rdbtnCPF.setFont(new Font("Roboto", Font.BOLD, 12));
		rdbtnCPF.setFocusable(false);
		rdbtnCPF.setBackground(new Color(255, 255, 255));
		rdbtnCPF.setBounds(305, 336, 169, 23);
		right.add(rdbtnCPF);
		
		JRadioButton rdbtnCNPJ = new JRadioButton("O documento é CNPJ.");
		rdbtnCNPJ.setEnabled(false);
		rdbtnCNPJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnCNPJ.isSelected()) {
					maskCPF.uninstall();
					maskCNPJ.install(txtOwnerDocument);
				}
			}
		});
		selectDocument.add(rdbtnCNPJ);
		rdbtnCNPJ.setForeground(Color.BLACK);
		rdbtnCNPJ.setFont(new Font("Roboto", Font.BOLD, 12));
		rdbtnCNPJ.setFocusable(false);
		rdbtnCNPJ.setBackground(Color.WHITE);
		rdbtnCNPJ.setBounds(305, 362, 169, 23);
		right.add(rdbtnCNPJ);
		
		JPanel user = new JPanel();
		user.setBackground(new Color(0f, 0f, 0f, 0f));
		user.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		user.setForeground(new Color(255, 255, 255));
		user.setBounds(20, 256, 471, 185);
		right.add(user);
		user.setLayout(null);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setBounds(31, 46, 450, 380);
		right.add(rigidArea);
		
		left = new JPanel();
		left.setBackground(new Color(0f, 0f, 0f, 0f));
		left.setBounds(0, 21, 486, 451);
		contentPane.add(left);
		left.setLayout(null);
		
		txtDocumentID = new JTextField();
		txtDocumentID.setFont(new Font("Roboto", Font.PLAIN, 22));
		txtDocumentID.setEditable(false);
		txtDocumentID.setBounds(18, 61, 176, 48);
		left.add(txtDocumentID);
		txtDocumentID.setColumns(10);
		
		JLabel labelIDDocumento = new JLabel("ID Documentação:");
		labelIDDocumento.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelIDDocumento.setBounds(18, 47, 176, 14);
		left.add(labelIDDocumento);
		
		JLabel labelIDDono = new JLabel("ID Dono:");
		labelIDDono.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelIDDono.setBounds(292, 47, 176, 14);
		left.add(labelIDDono);
		
		txtOwnerID = new JTextField();
		txtOwnerID.setFont(new Font("Roboto", Font.PLAIN, 22));
		txtOwnerID.setBounds(292, 61, 176, 48);
		txtOwnerID.setColumns(10);
		left.add(txtOwnerID);
		
		JLabel labalRENAVAM = new JLabel("Código RENAVAM:");
		labalRENAVAM.setFont(new Font("Roboto", Font.PLAIN, 14));
		labalRENAVAM.setBounds(18, 141, 176, 14);
		left.add(labalRENAVAM);
		
		JLabel labelCRV = new JLabel("Número do CRV");
		labelCRV.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelCRV.setBounds(292, 141, 176, 14);
		left.add(labelCRV);
		
		MaskFormatter maskRENAVAM = new MaskFormatter("###########");
		JFormattedTextField txtRENAVAM = new JFormattedTextField(maskRENAVAM);
		txtRENAVAM.setFont(new Font("Roboto", Font.PLAIN, 22));
		txtRENAVAM.setBounds(18, 155, 176, 48);
		left.add(txtRENAVAM);
		
		MaskFormatter maskCRV = new MaskFormatter("############");
		JFormattedTextField txtCRV = new JFormattedTextField(maskCRV);
		txtCRV.setFont(new Font("Roboto", Font.PLAIN, 22));
		txtCRV.setBounds(292, 155, 176, 48);
		left.add(txtCRV);
		
		MaskFormatter maskOLDPLATE = new MaskFormatter("***-****/**");
		MaskFormatter maskNEWPLATE = new MaskFormatter("UUU#U##");
		JFormattedTextField txtCurrentPlate = new JFormattedTextField(maskNEWPLATE);
		txtCurrentPlate.setFont(new Font("Roboto", Font.PLAIN, 22));
		txtCurrentPlate.setBounds(19, 281, 176, 48);
		left.add(txtCurrentPlate);
		
		JLabel labelPlacaAtual = new JLabel("Placa atual (MERCOSUL):");
		labelPlacaAtual.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelPlacaAtual.setBounds(19, 267, 176, 14);
		left.add(labelPlacaAtual);
		
		JFormattedTextField txtLastPlate = new JFormattedTextField(maskOLDPLATE);
		txtLastPlate.setFont(new Font("Roboto", Font.PLAIN, 22));
		txtLastPlate.setBounds(291, 281, 176, 48);
		left.add(txtLastPlate);
		
		JLabel labelPlacaAntiga = new JLabel("Placa antiga/UF:");
		labelPlacaAntiga.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelPlacaAntiga.setBounds(291, 267, 176, 14);
		left.add(labelPlacaAntiga);
		
		JComboBox<String> cbSpecie = new JComboBox<String>();
		cbSpecie.setFont(new Font("Roboto", Font.PLAIN, 10));
		cbSpecie.setBounds(18, 378, 177, 48);
		left.add(cbSpecie);
		cbSpecie.setModel(new DefaultComboBoxModel<String>(new String[] {"PASSAGEIRO", "CARGA", "MISTO", "COMPETIÇÃO", "TRAÇÃO", "ESPECIAL", "COLEÇÃO"}));
		
		JComboBox<String> cbType = new JComboBox<String>();
		cbType.setFont(new Font("Roboto", Font.PLAIN, 10));
		cbType.setBounds(291, 378, 177, 48);
		left.add(cbType);
		cbType.setModel(new DefaultComboBoxModel<String>(new String[] {"OFICIAL", "REPRESENTAÇÃO DIPLOMÁTICA", "PARTICULAR", "ALUGUEL", "APRENDIZAGEM"}));
		
		JLabel labelEspecieVeiculo = new JLabel("Espécie do veículo:");
		labelEspecieVeiculo.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelEspecieVeiculo.setBounds(19, 365, 176, 14);
		left.add(labelEspecieVeiculo);
		
		JLabel labelTipoVeiculo = new JLabel("Tipo do veículo:");
		labelTipoVeiculo.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelTipoVeiculo.setBounds(291, 365, 176, 14);
		left.add(labelTipoVeiculo);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setBounds(18, 46, 450, 380);
		left.add(rigidArea_1);
		
		imagemLogoFundo = new JLabel("");
		imagemLogoFundo.setBounds(0, 0, 1008, 472);
		contentPane.add(imagemLogoFundo);
		imagemLogoFundo.setHorizontalAlignment(SwingConstants.CENTER);
		imagemLogoFundo.setIcon(new ImageIcon("C:\\Users\\Pichau\\eclipse-workspace\\CRUD_J\\assets\\freelogoCINZA.png"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(240, 240, 240));
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.setBounds(0, 0, 1009, 22);
		contentPane.add(menuBar);
		
		JMenu menuHotKeys = new JMenu("Teclas de atalho");
		menuHotKeys.setBackground(new Color(255, 255, 255));
		menuBar.add(menuHotKeys);
		
		JMenuItem mnItemLimpar = new JMenuItem("Limpar campos");
		mnItemLimpar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		menuHotKeys.add(mnItemLimpar);
		
		JMenuItem mnItemCadastrar = new JMenuItem("Cadastrar");
		mnItemCadastrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		menuHotKeys.add(mnItemCadastrar);
		btnCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtOwnerID.getText().equals("") || txtRENAVAM.getText().equals("") || txtCRV.getText().equals("") || txtCurrentPlate.getText().equals("") || txtLastPlate.getText().equals("") || 
						txtBrandCar.getText().equals("") || txtModelCar.getText().equals("") || txtCarColor.getText().equals("") || txtModelYear.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente.");
				} else {
					try {
						Connection con = ConnectionBuilder.connectDB();
						String sql = "insert into carDocumentation(RENAVAM, CRV, currentPlate, lastPlate, speciesCar, typeCar, carBrand, carModel, carColor, modelYear, ownerID) values ("
								+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
						PreparedStatement stmt = con.prepareStatement(sql);
						stmt.setString(1, txtRENAVAM.getText());
						stmt.setString(2, txtCRV.getText());
						stmt.setString(3, txtCurrentPlate.getText());
						stmt.setString(4, txtLastPlate.getText());
						stmt.setString(5, (String) cbSpecie.getSelectedItem());
						stmt.setString(6, (String) cbType.getSelectedItem());
						stmt.setString(7, txtBrandCar.getText());
						stmt.setString(8, txtModelCar.getText());
						stmt.setString(9, txtCarColor.getText());
						stmt.setString(10, txtModelYear.getText());
						stmt.setString(11, txtOwnerID.getText());
						stmt.execute();
						JOptionPane.showMessageDialog(null, "Documentação cadastrada com sucesso!");
						stmt.close();
						con.close();
						txtRENAVAM.setText("");
						txtCRV.setText("");
						txtCurrentPlate.setText("");
						txtLastPlate.setText("");
						cbSpecie.setSelectedItem("");
						cbType.setSelectedItem("");
						txtBrandCar.setText("");
						txtModelCar.setText("");
						txtCarColor.setText("");
						txtModelYear.setText("");
						txtOwnerID.setText("");
						} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Falha na conexão, tente novamente mais tarde.");
						e1.printStackTrace();
						}
				}	
						
			}
		});
		btnCadastrarProprietrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtOwnerName.getText().equals("") || txtOwnerDocument.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente.");
				} else {
					try {
						Connection con = ConnectionBuilder.connectDB();
						String sql = "insert into ownerData(nameOwner, documentOwner) values (?, ?)";
						PreparedStatement stmt = con.prepareStatement(sql);
						stmt.setString(1, txtOwnerName.getText());
						stmt.setString(2, txtOwnerDocument.getText());
						stmt.execute();
						JOptionPane.showMessageDialog(null, "Proprietário cadastrado com sucesso!");
						stmt.close();
						con.close();
						txtOwnerName.setText("");
						txtOwnerDocument.setText("");
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Falha na conexão, tente novamente mais tarde.");
						e1.printStackTrace();
					}
				}
					
			}
		});
		btnBuscarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = ConnectionBuilder.connectDB();
					String sql = "select cardocumentation.id_Document, cardocumentation.RENAVAM, cardocumentation.CRV, cardocumentation.currentPlate, cardocumentation.lastPlate,\r\n"
							+ "cardocumentation.speciesCar, cardocumentation.typeCar, cardocumentation.carBrand, cardocumentation.carModel, cardocumentation.carColor, cardocumentation.modelYear,\r\n"
							+ "ownerdata.id_Owner, ownerdata.nameOwner, ownerdata.documentOwner from cardocumentation, ownerdata where id_Document=?;";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1, (int) spID.getValue());
					ResultSet rs = stmt.executeQuery();
					if (rs.next()) {
						txtDocumentID.setText(rs.getString("id_Document"));
						txtOwnerID.setText(rs.getString("id_Owner"));
						txtRENAVAM.setText(rs.getString("RENAVAM"));
						txtCRV.setText(rs.getString("CRV"));
						txtCurrentPlate.setText(rs.getString("currentPlate"));
						txtLastPlate.setText(rs.getString("lastPlate"));
						cbSpecie.setSelectedItem(rs.getString("speciesCar"));
						cbType.setSelectedItem(rs.getString("typeCar"));
						txtBrandCar.setText(rs.getString("carBrand"));
						txtModelCar.setText(rs.getString("carModel"));
						txtCarColor.setText(rs.getString("carColor"));
						txtModelYear.setText(rs.getString("modelYear"));
						txtOwnerName.setText(rs.getString("nameOwner"));
						txtOwnerDocument.setText(rs.getString("documentOwner"));
						JOptionPane.showMessageDialog(null, "ID do Documento: " + rs.getString("id_Document") + "\nNome do proprietário: " + rs.getString("nameOwner"));
					}
					else {
						JOptionPane.showMessageDialog(null, "Documentação não encontrada.");
					}
					stmt.close();
					con.close();
					} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Falha na conexão, tente novamente mais tarde.");
					e1.printStackTrace();
				}
				
			}
		});
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (dialogResult == 0) {
					System.exit(0);
				}
			}
		});
		rdbtnCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnCadastrarVeiculo.isSelected()) {
					txtOwnerID.setEditable(true);
					txtBrandCar.setEditable(true);
					txtModelCar.setEditable(true);
					txtCarColor.setEditable(true);
					txtModelYear.setEditable(true);
					txtRENAVAM.setEditable(true);
					txtCRV.setEditable(true);
					txtCurrentPlate.setEditable(true);
					txtLastPlate.setEditable(true);
					cbSpecie.setEnabled(true);
					cbType.setEnabled(true);
					txtOwnerName.setEditable(false);
					txtOwnerDocument.setEditable(false);
					rdbtnCPF.setEnabled(false);
					rdbtnCNPJ.setEnabled(false);
					txtOwnerName.setText("");
					txtOwnerDocument.setText("");
				}
			}
		});
		rdbtnCadastrarDono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnCadastrarDono.isSelected()) {
					txtOwnerID.setEditable(false);
					txtBrandCar.setEditable(false);
					txtModelCar.setEditable(false);
					txtCarColor.setEditable(false);
					txtModelYear.setEditable(false);
					txtRENAVAM.setEditable(false);
					txtCRV.setEditable(false);
					txtCurrentPlate.setEditable(false);
					txtLastPlate.setEditable(false);
					cbSpecie.setEnabled(false);
					cbType.setEnabled(false);
					txtOwnerName.setEditable(true);
					txtOwnerDocument.setEditable(true);
					rdbtnCPF.setEnabled(true);
					rdbtnCNPJ.setEnabled(true);
					txtDocumentID.setText("");
					txtRENAVAM.setText("");
					txtCRV.setText("");
					txtCurrentPlate.setText("");
					txtLastPlate.setText("");
					cbSpecie.setSelectedItem("");
					cbType.setSelectedItem("");
					txtBrandCar.setText("");
					txtModelCar.setText("");
					txtCarColor.setText("");
					txtModelYear.setText("");
					txtOwnerID.setText("");
				}
			}
		});
		mnItemLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDocumentID.setText("");
				txtRENAVAM.setText("");
				txtCRV.setText("");
				txtCurrentPlate.setText("");
				txtLastPlate.setText("");
				cbSpecie.setSelectedItem("");
				cbType.setSelectedItem("");
				txtBrandCar.setText("");
				txtModelCar.setText("");
				txtCarColor.setText("");
				txtModelYear.setText("");
				txtOwnerID.setText("");
				txtOwnerName.setText("");
				txtOwnerDocument.setText("");
			}
		});
	}
}
