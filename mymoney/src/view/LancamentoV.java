package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import controller.LancamentoController;
import dto.LancamentoDto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;

import model.LancamentoModel;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LancamentoV {

	private JFrame frmLanamentos;
	private JTextField idTF;
	private JTextField tipoTF;
	private JTextField dataCadastroTF;
	private JTextField valorTF;
	private JTextField descricaoTF;
	private JTable table;
	private JScrollPane scroll; 
	private JPanel panel;
	private JButton btnFiltrar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LancamentoV window = new LancamentoV();
					window.frmLanamentos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LancamentoV() {
		initialize();
	}

	/**
	 * Carregar Frame
	 */
	private void carregaFrame(){
		frmLanamentos = new JFrame();
		frmLanamentos.setTitle("Lan\u00E7amentos");
		frmLanamentos.getContentPane().setBackground(Color.WHITE);
		frmLanamentos.setBounds(100, 100, 800, 600);
		frmLanamentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLanamentos.getContentPane().setLayout(null);
	}
	
	/**
	 * Carregar Labels
	 */
	private void carregaLabel(){
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(40, 75, 46, 14);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(176, 75, 46, 14);
		
		JLabel lblDataDeCadastro = new JLabel("Data de Cadastro:");
		lblDataDeCadastro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataDeCadastro.setBounds(344, 75, 126, 14);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setBounds(564, 75, 46, 14);
		
		JLabel lblDescri = new JLabel("Descri\u00E7\u00E3o:");
		lblDescri.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescri.setBounds(20, 103, 66, 14);
		
		frmLanamentos.getContentPane().add(lblId);

		frmLanamentos.getContentPane().add(lblTipo);

		frmLanamentos.getContentPane().add(lblDataDeCadastro);

		frmLanamentos.getContentPane().add(lblValor);

		frmLanamentos.getContentPane().add(lblDescri);
	}
	
	/**
	 * Carregar Text
	 */
	private void carregaText(){
		idTF = new JTextField();
		idTF.setBounds(96, 72, 86, 20);
		idTF.setColumns(10);
		
		tipoTF = new JTextField();
		tipoTF.setBounds(227, 72, 132, 20);
		tipoTF.setColumns(10);
		
		dataCadastroTF = new JTextField();
		dataCadastroTF.setBounds(480, 72, 86, 20);
		dataCadastroTF.setColumns(10);
		
		valorTF = new JTextField();
		valorTF.setBounds(620, 72, 86, 20);
		valorTF.setColumns(10);
		
		descricaoTF = new JTextField();
		descricaoTF.setBounds(96, 100, 610, 20);
		descricaoTF.setColumns(10);
		
		frmLanamentos.getContentPane().add(tipoTF);
		frmLanamentos.getContentPane().add(idTF);
		frmLanamentos.getContentPane().add(dataCadastroTF);
		frmLanamentos.getContentPane().add(valorTF);
		frmLanamentos.getContentPane().add(descricaoTF);
		
	}
	
	
	/**
	 * Carregar Button
	 */
	private void carregaButton(){
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(0, 0, 100, 61);
		
		JButton btnConsultar = new JButton("Atualizar");
		btnConsultar.setBounds(299, 0, 100, 61);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(100, 0, 100, 61);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(199, 0, 100, 61);
		
		panel.add(btnCadastrar);
		panel.add(btnConsultar);
		panel.add(btnAlterar);
		panel.add(btnDeletar);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LancamentoDto ld = new LancamentoDto(Integer.parseInt(((idTF.getText().equals(""))? "0" : idTF.getText()) ),
						((descricaoTF.getText().equals(""))? "0" : descricaoTF.getText())  , 
						 new Date(88,1,2),
						 ((tipoTF.getText().equals(""))? "0" : tipoTF.getText()) , 
						 Double.parseDouble(((valorTF.getText().equals(""))? "0" : valorTF.getText())));
				System.out.println("aqui");
				
				table.setModel(new LancamentoModel(new LancamentoController().filtrarLancamentos(ld)));
			}
		});
		btnFiltrar.setBounds(399, 0, 91, 61);
		panel.add(btnFiltrar);
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LancamentoDto ld = new LancamentoDto(Integer.parseInt(idTF.getText()),
													  descricaoTF.getText(), 
													 new Date(88,1,2),
													 tipoTF.getText(),
													 Double.parseDouble(valorTF.getText()));
				LancamentoController lc = new LancamentoController();
				lc.setDto(ld);
				JOptionPane.showMessageDialog(null,lc.alterarLancamento(),"Alterado Sucesso",JOptionPane.WARNING_MESSAGE);
				atualizaTabela();
			}
		});
		
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LancamentoDto ld = new LancamentoDto(Integer.parseInt(idTF.getText()),
													  descricaoTF.getText(), 
													 new Date(88,1,2),
													 tipoTF.getText(),
													 Double.parseDouble(valorTF.getText()));
				LancamentoController lc = new LancamentoController();
				lc.setDto(ld);
				JOptionPane.showMessageDialog(null,lc.removerLancamento(),"Removido Sucesso",JOptionPane.WARNING_MESSAGE);
				atualizaTabela();
			}
		});
		
		
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaTabela();
			}
		});
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LancamentoDto ld = new LancamentoDto(Integer.parseInt(idTF.getText()),
																	  descricaoTF.getText(), 
																	 new Date(88,1,2),
																	 tipoTF.getText(),
																	 Double.parseDouble(valorTF.getText()));

				LancamentoController lc = new LancamentoController();
				lc.setDto(ld);
				JOptionPane.showMessageDialog(null,lc.cadastrarLancamento(),"Cadastrado Sucesso",JOptionPane.WARNING_MESSAGE);
				atualizaTabela();
			}
		});
		
		
	}
	
	/**
	 * Carregar Table
	 */
	private void carregaTable(){
		table = new JTable();		
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idTF.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				tipoTF.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				dataCadastroTF.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				valorTF.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				descricaoTF.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
			}
		});
		table.setBounds(20, 561, 762, -330);
		
		scroll = new JScrollPane(); 
		
		scroll.setLocation(10, 125);
		scroll.getViewport().setBorder(null);
		scroll.setViewportView(table);
		scroll.setSize(772, 432);
		
		frmLanamentos.getContentPane().add(scroll);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 792, 61);
		frmLanamentos.getContentPane().add(panel);
		panel.setLayout(null);
	
		
	}
	
	private void atualizaTabela(){
		table.setModel(new LancamentoModel(new LancamentoController().consultarLancamentos()));
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		carregaFrame();
		
		carregaLabel();
		
		carregaText();
		
		carregaTable();
		
		carregaButton();
		
		atualizaTabela();
		
		
	}
}
