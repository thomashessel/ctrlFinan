package br.com.ths.ctrlFinan.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ths.ctrlFinan.Entities.ItensLancamento;
import br.com.ths.ctrlFinan.Repositories.ItensLancamentoRepository;
import br.com.ths.ctrlFinan.dtos.ItensLancamentoDTO;

@Service
public class ItensLancamentoService {
	
	@Autowired
	private ItensLancamentoRepository repositorio;
	
	public List<ItensLancamentoDTO> findAll(){
		List<ItensLancamento> result = repositorio.findAll();	
		return result.stream().map(x -> new ItensLancamentoDTO(x)).toList();
	}

}
