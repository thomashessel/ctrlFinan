package br.com.ths.ctrlFinan.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ths.ctrlFinan.Entities.Lancamento;
import br.com.ths.ctrlFinan.Repositories.LancamentoRepository;
import br.com.ths.ctrlFinan.dtos.LancamentoDTO;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repositorio;
	
	public List<LancamentoDTO> findAllLancamento(){
		List<Lancamento> result = repositorio.findAll();	
		return result.stream().map(x -> new LancamentoDTO(x)).toList();
	}
}
