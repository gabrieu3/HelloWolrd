package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dto.LancamentoDto;

public class LancamentoModel extends AbstractTableModel {
	 
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String colunas[]={"ID","Descrição","Valor","Tipo","Data de Cadastro"};
	private final List<LancamentoDto> lancamentos;
	 
	   public LancamentoModel(List<LancamentoDto> lancamentos) {
	     this.lancamentos = lancamentos;
	   }
	 
	   @Override
	   public int getColumnCount() {
	     return colunas.length;
	   }
	 
	   @Override
	   public int getRowCount() {
	     return lancamentos.size();
	   }
	   
	   @Override
	    public String getColumnName(int columnIndex) {
	        return colunas[columnIndex];
	    }
	 
	   @Override
	   public Object getValueAt(int rowIndex, int columnIndex) {
		   LancamentoDto n = lancamentos.get(rowIndex);
	     
	     switch (columnIndex) {
	     case 0:
	       return n.getId();
	     case 1:
	       return n.getDescricao();
	     case 2:
	       return n.getValor();
	     case 3:
		       return n.getTipo();
	     case 4:
		       return n.getDataCadastro();
	     }
	     return null;
	   }
}