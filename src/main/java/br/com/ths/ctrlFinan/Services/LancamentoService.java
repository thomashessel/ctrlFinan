package br.com.ths.ctrlFinan.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public List<LancamentoComObjItemDTO> findAllLancamento(){
		List<Lancamento> result = repositorio.findAll();	
		return result.stream().map(x -> new LancamentoComObjItemDTO(x)).toList();	
	}
	@Transactional
	public LancamentoSemObjItemDTO findByIdLancamento(Long id) {
		Optional<Lancamento> result = repositorio.findById(id);	
		return result.isEmpty()? null :new LancamentoSemObjItemDTO(result.get());
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
	@Transactional
	public void atualizaLancamento(LancamentoSemObjItemDTO lancamento) {
		Optional<ItensLancamento> itenlancamento =itensRepositorio.findById(lancamento.getIdItemLancamento());
		if(itenlancamento.isPresent()) {
			Lancamento result = new Lancamento(lancamento.getId(),lancamento.getAno(),lancamento.getMes(),
					lancamento.getDataLancamento(),lancamento.getValorLancamento(),itenlancamento.get());
//			return new LancamentoSemObjItemDTO(repositorio.save(result));
		}
//		return null;
	}
	@Transactional
	public void deletaLancamento (Long id) {
		repositorio.deleteById(id);
	}
}
