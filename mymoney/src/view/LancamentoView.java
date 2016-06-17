package view;

import java.awt.Color;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParsePosition;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.LancamentoModel;
import controller.LancamentoController;
import dto.LancamentoDto;

public class LancamentoView {

	
	
	
	public LancamentoView(){
		JLabel idLabel = new JLabel("ID:");
		JLabel valorLabel = new JLabel("Valor:");
		JLabel dataCadastroLabel = new JLabel("Data de Cadastro:");
		JLabel descricaoLabel = new JLabel("Descrição:");
		JLabel tipoLabel = new JLabel("Tipo:");
		
		JTextField idTA = new JTextField(10);
		JTextField valorTA = new JTextField(10);
		JTextField dataCadastroTA = new JTextField(11);
		JTextField descricaoTA = new JTextField(30);
		JTextField tipoTA = new JTextField(20);
		
		JTable table = new JTable();
		// por padrão, vem sem bordas, então colocamos:
		table.setBorder(new LineBorder(Color.black));
		table.setGridColor(Color.black);
		table.setShowGrid(true);
		
		JScrollPane scroll = new JScrollPane(); 
		scroll.getViewport().setBorder(null);
		scroll.getViewport().add(table); 
		scroll.setSize(450, 450);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		
		botaoCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				LancamentoDto ld = new LancamentoDto(Integer.parseInt(idTA.getText()),
													 valorTA.getText(), 
													 new Date(88,1,2),
													 descricaoTA.getText(), 
													 Double.parseDouble(tipoTA.getText()));
				
				LancamentoController lc = new LancamentoController();
				lc.setDto(ld);
				System.out.println(lc.cadastrarLancamento());
			}
		});
		
		JButton botaoConsultar = new JButton("Consultar");
		
		botaoConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<LancamentoDto> lancamentos = new LancamentoController().consultarLancamentos();
				LancamentoModel lm = new LancamentoModel(lancamentos);
				table.setModel(lm);
				
			}
		});
		
		
		

	
		
		
		JPanel painel = new JPanel();
		
		painel.add(idLabel);
		painel.add(idTA);
		
		painel.add(valorLabel);
		painel.add(valorTA);
		
		painel.add(dataCadastroLabel);
		painel.add(dataCadastroTA);
		
		painel.add(descricaoLabel);
		painel.add(descricaoTA);
		
		painel.add(tipoLabel);
		painel.add(tipoTA);
		
		
		painel.add(botaoCadastrar);
		painel.add(botaoConsultar);
		
		painel.add(scroll);
		
		JFrame janela = new JFrame("Argentum");
		
		/**
		 * Aparece do tamanho da tela do computador e quando minimizar fica centralizado
		 */
		janela.setLocationRelativeTo(null);
		janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		janela.add(painel);
		janela.pack();
		janela.setVisible(true);
	}
	
	
}
