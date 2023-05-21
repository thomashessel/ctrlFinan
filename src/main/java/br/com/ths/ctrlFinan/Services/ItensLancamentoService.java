package br.com.ths.ctrlFinan.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ths.ctrlFinan.Entities.ItensLancamento;
import br.com.ths.ctrlFinan.Repositories.ItensLancamentoRepository;
import br.com.ths.ctrlFinan.dtos.ItensLancamentoDTO;

@Service
public class ItensLancamentoService {
	
	@Autowired
	private ItensLancamentoRepository repositorio;
	@Transactional
	public List<ItensLancamentoDTO> findAll(){
		List<ItensLancamento> result = repositorio.findAll();	
		return result.stream().map(x -> new ItensLancamentoDTO(x)).toList();
	}
	@Transactional
	public ItensLancamentoDTO findByIdItem(Long idItemLancamento){
		Optional<ItensLancamento> result = repositorio.findById(idItemLancamento);	
		return result.isEmpty()? null :new ItensLancamentoDTO(result.get());
	}
	
	@Transactional
	public ItensLancamentoDTO salvaItemLancamento(ItensLancamentoDTO itemLancamentoDto) {		
		ItensLancamento result = new ItensLancamento(
				itemLancamentoDto.getId(), 
				itemLancamentoDto.getDescricao(), 
				itemLancamentoDto.getTpLancamento(), 
				itemLancamentoDto.getStatusValorFixo(), 
				itemLancamentoDto.getValorFixo(), 
				itemLancamentoDto.getValorPrevisto(), 
				itemLancamentoDto.getValorReal(), 
				itemLancamentoDto.getStatusDataFixa(), 
				itemLancamentoDto.getDiaFixo());
		return new ItensLancamentoDTO(repositorio.save(result));
	
	}
	@Transactional
	public ItensLancamentoDTO atualizaItemLancamento(ItensLancamentoDTO itemLancamentoDto, Long idItemLancamento) {
		if(repositorio.existsById(idItemLancamento)) {			
			itemLancamentoDto.setId(idItemLancamento);
			ItensLancamento result = new ItensLancamento(
					itemLancamentoDto.getId(), 
					itemLancamentoDto.getDescricao(), 
					itemLancamentoDto.getTpLancamento(), 
					itemLancamentoDto.getStatusValorFixo(), 
					itemLancamentoDto.getValorFixo(), 
					itemLancamentoDto.getValorPrevisto(), 
					itemLancamentoDto.getValorReal(), 
					itemLancamentoDto.getStatusDataFixa(), 
					itemLancamentoDto.getDiaFixo());
			return new ItensLancamentoDTO(repositorio.save(result));
		}
	return null;
	}
	@Transactional
	public void deletaItemLancamento (Long idItemLancamento) {
		if(repositorio.existsById(idItemLancamento)) {
		repositorio.deleteById(idItemLancamento);
		}
	}
}
