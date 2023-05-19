package br.com.ths.ctrlFinan.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ths.ctrlFinan.Entities.ItensLancamento;
import br.com.ths.ctrlFinan.Entities.Lancamento;
import br.com.ths.ctrlFinan.Repositories.ItensLancamentoRepository;
import br.com.ths.ctrlFinan.Repositories.LancamentoRepository;
import br.com.ths.ctrlFinan.dtos.LancamentoDTO;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repositorio;
	@Autowired
	private ItensLancamentoRepository itensRepositorio;
	
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
		Optional<ItensLancamento> findById = itensRepositorio.findById(lancamento.getIdItemLancamento().getId());
		
		if(findById.isPresent()) {
			ItensLancamento itensLancamento = findById.get();
			lancamento.setIdItemLancamento(itensLancamento);
			return new LancamentoDTO( repositorio.save(lancamento));
		}
		return null;
		
	}
	
}
