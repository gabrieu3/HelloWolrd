package controller;

import java.util.List;

import dao.LancamentoDao;
import dto.LancamentoDto;

public class LancamentoController {

	
	private LancamentoDto dto;
	
	public String cadastrarLancamento(){
		LancamentoDao dao = new LancamentoDao();
		dao.cadastrar(dto);
		return "Cadastrado";
	}
	
	public String alterarLancamento(){
		LancamentoDao dao = new LancamentoDao();
		dao.alterar(dto);
		return "Alterado";
	}
	
	public String removerLancamento(){
		LancamentoDao dao = new LancamentoDao();
		dao.remover(dto);
		return "Removido";
	}

	public LancamentoDto getDto() {
		return dto;
	}

	public void setDto(LancamentoDto dto) {
		this.dto = dto;
	}
	
	public List<LancamentoDto> consultarLancamentos(){
		LancamentoDao dao = new LancamentoDao();
		return dao.consultar();
	
	}
	
	public List<LancamentoDto> filtrarLancamentos(LancamentoDto dto){
		LancamentoDao dao = new LancamentoDao();
		return dao.filtrar(dto);
	
	}
	
	
	
	

	
}
