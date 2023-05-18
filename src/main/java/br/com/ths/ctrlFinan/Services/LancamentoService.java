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
	
	public LancamentoDTO salvaNovoLancamento(Lancamento lancamento) {
		/*
		 * Lancamento result = new Lancamento( dto.getId(), dto.getAno(), dto.getMes(),
		 * dto.getDataLancamento(), dto.getValorLancamento(), dto.getIdItemLancamento()
		 * );
		 */
		return new LancamentoDTO( repositorio.save(lancamento));
		
	}
}
