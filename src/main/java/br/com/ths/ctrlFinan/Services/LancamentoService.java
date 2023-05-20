package br.com.ths.ctrlFinan.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ths.ctrlFinan.Entities.ItensLancamento;
import br.com.ths.ctrlFinan.Entities.Lancamento;
import br.com.ths.ctrlFinan.Repositories.ItensLancamentoRepository;
import br.com.ths.ctrlFinan.Repositories.LancamentoRepository;
import br.com.ths.ctrlFinan.dtos.LancamentoComObjItemDTO;
import br.com.ths.ctrlFinan.dtos.LancamentoSemObjItemDTO;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repositorio;
	@Autowired
	private ItensLancamentoRepository itensRepositorio;
	
	public List<LancamentoComObjItemDTO> findAllLancamento(){
		List<Lancamento> result = repositorio.findAll();	
		return result.stream().map(x -> new LancamentoComObjItemDTO(x)).toList();
		
	}
	
	public LancamentoComObjItemDTO salvaNovoLancamento(Lancamento lancamento) {

		Optional<ItensLancamento> findById = itensRepositorio.findById(lancamento.getIdItemLancamento().getId());
		
		if(findById.isPresent()) {
			ItensLancamento itensLancamento = findById.get();
			lancamento.setIdItemLancamento(itensLancamento);
			return new LancamentoComObjItemDTO( repositorio.save(lancamento));
		}
		return null;		
	}
	
	public LancamentoSemObjItemDTO salvaNovoLancamento(LancamentoSemObjItemDTO lancamento) {
		Optional<ItensLancamento> itenlancamento =itensRepositorio.findById(lancamento.getIdItemLancamento());
		if(itenlancamento.isPresent()) {
			Lancamento result = new Lancamento(lancamento.getId(),lancamento.getAno(),lancamento.getMes(),
					lancamento.getDataLancamento(),lancamento.getValorLancamento(),itenlancamento.get());
			return new LancamentoSemObjItemDTO(repositorio.save(result));
		}
		return null;
	}
}
