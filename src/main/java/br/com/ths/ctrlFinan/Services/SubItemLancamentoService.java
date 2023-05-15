package br.com.ths.ctrlFinan.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ths.ctrlFinan.Entities.SubItemLancamento;
import br.com.ths.ctrlFinan.Repositories.SubItemLancamentoRepository;
import br.com.ths.ctrlFinan.dtos.SubItemLancamentoDTO;

@Service
public class SubItemLancamentoService {

	@Autowired
	private SubItemLancamentoRepository repos;
	
	public List<SubItemLancamentoDTO> findAllSubItens(){
		List<SubItemLancamento> result = repos.findAll();
		return result.stream().map(x -> new SubItemLancamentoDTO(x)).toList();
	}
}
