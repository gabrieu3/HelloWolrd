/**
 * @author Gabriel
 *
 */
package dao;

import util.ConexaoMySQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

import dto.LancamentoDto;

public class LancamentoDao {
	
	private String sql;
	
	public LancamentoDao(){
		
	}
	
	public void cadastrar(LancamentoDto dto){
		
		Connection conexao;
		PreparedStatement stmt;
		
		try{
			
			sql = "insert into lancamento(id,descricao,valor, dataCadastro, tipo) values(?,?,?,?,?)";
			conexao = ConexaoMySQL.getConexaoMySQL();
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, dto.getId()); 
			stmt.setString(2, dto.getDescricao());            
			stmt.setDouble(3, dto.getValor());            
			stmt.setDate(4, dto.getDataCadastro());
			stmt.setString(5, dto.getTipo());
			stmt.execute();            
			stmt.close(); 

			ConexaoMySQL.FecharConexao();
			
		}catch(SQLException s){
			System.err.print(s.getMessage());
		}
	}
	
	public List<LancamentoDto> consultar(){
		Connection conexao;
		PreparedStatement stmt;
		List<LancamentoDto> ll = new LinkedList();;
		try{
			
			sql = "select id,descricao,valor, dataCadastro, tipo from lancamento";
			conexao = ConexaoMySQL.getConexaoMySQL();
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();            
			 
			while (rs.next()) {
			  int id = rs.getInt("id");
			  double valor = rs.getDouble("valor");
			  String descricao = rs.getString("descricao");
			  String tipo = rs.getString("tipo");
			  Date dataCadastro = rs.getDate("dataCadastro");
			  

			  //Assuming you have a user object
			  LancamentoDto l = new LancamentoDto(id,descricao,dataCadastro, tipo, valor);

			  ll.add(l);
			}
			stmt.close();
			ConexaoMySQL.FecharConexao();
			
			
		}catch(SQLException s){
			System.err.print(s.getMessage());
		}
		return ll;
	}
	
	public void alterar(LancamentoDto dto){
		Connection conexao;
		PreparedStatement stmt;
		
		try{
			sql = "update lancamento set "
					+ "descricao = '" + dto.getDescricao() + "'"
					+ " ,valor = " +dto.getValor() 
					+ " ,dataCadastro = '" +dto.getDataCadastro() + "'" 
					+ " ,tipo = '" +dto.getTipo() + "'"
					+ " where id =" + dto.getId();
			
			conexao = ConexaoMySQL.getConexaoMySQL();
			stmt = conexao.prepareStatement(sql);
			stmt.execute();  
			stmt.close();
		}catch(SQLException s){
			System.err.print(s.getMessage());
		}
		
		ConexaoMySQL.FecharConexao();
	}
	
	public void remover(LancamentoDto dto){
		Connection conexao;
		PreparedStatement stmt;
		
		try{
			sql = "delete from lancamento where id = " + dto.getId();
			System.out.println(sql);
			conexao = ConexaoMySQL.getConexaoMySQL();
			stmt = conexao.prepareStatement(sql);
			stmt.execute();  
			stmt.close();
		}catch(SQLException s){
			System.err.print(s.getMessage());
		}
		
		ConexaoMySQL.FecharConexao();
	}
	
	public List<LancamentoDto> filtrar(LancamentoDto dto){
		Connection conexao;
		PreparedStatement stmt;
		List<LancamentoDto> ll = new LinkedList();;
		try{
			
			sql = "select id,descricao,valor, dataCadastro, tipo from lancamento where (id = " + dto.getId() + " or " + dto.getId() + " = 0)"
																				 + " and (descricao = '" + dto.getDescricao() + "' or '" + dto.getDescricao() + "' = '0')"
																				 + " and (valor = " + dto.getValor() + " or " + dto.getValor() + " = 0)"
																				 + " and (tipo = '" + dto.getTipo() + "' or '" + dto.getTipo() + "' = '0')";	
			System.out.println(sql);
			conexao = ConexaoMySQL.getConexaoMySQL();
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();            
			 
			while (rs.next()) {
			  int id = rs.getInt("id");
			  double valor = rs.getDouble("valor");
			  String descricao = rs.getString("descricao");
			  String tipo = rs.getString("tipo");
			  Date dataCadastro = rs.getDate("dataCadastro");
			  

			  //Assuming you have a user object
			  LancamentoDto l = new LancamentoDto(id,descricao,dataCadastro, tipo, valor);

			  ll.add(l);
			}
			stmt.close();
			ConexaoMySQL.FecharConexao();
			
			
		}catch(SQLException s){
			System.err.print(s.getMessage());
		}
		return ll;
	}
}