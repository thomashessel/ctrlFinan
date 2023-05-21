package br.com.ths.ctrlFinan.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ths.ctrlFinan.Entities.ItensLancamento;
import br.com.ths.ctrlFinan.Entities.SubItemLancamento;
import br.com.ths.ctrlFinan.Repositories.ItensLancamentoRepository;
import br.com.ths.ctrlFinan.Repositories.SubItemLancamentoRepository;
import br.com.ths.ctrlFinan.dtos.SubItemLancamentoDTO;

@Service
public class SubItemLancamentoService {

	@Autowired
	private SubItemLancamentoRepository repos;
	@Autowired
	private ItensLancamentoRepository reposItem;
	
	@Transactional
	public List<SubItemLancamentoDTO> findAllSubItens(){
		List<SubItemLancamento> result = repos.findAll();
		return result.stream().map(x -> new SubItemLancamentoDTO(x)).toList();
	}
	@Transactional
	public SubItemLancamentoDTO findByIdSubItens(Long idSubItem){
		Optional<SubItemLancamento> result = repos.findById(idSubItem);	
		return result.isEmpty()? null :new SubItemLancamentoDTO(result.get());
	}
	@Transactional
	public SubItemLancamentoDTO saveSubItens(SubItemLancamentoDTO subItenDto) {
		Optional<ItensLancamento> item = reposItem.findById(subItenDto.getIdItensLancamento());
		if(!item.isEmpty()) {
			SubItemLancamento subItem = new SubItemLancamento(subItenDto.getId(),
					item.get(),
					subItenDto.getDescricaoSub(), 
					subItenDto.getDataLancada(), 
					subItenDto.getValorLancada());
			return new SubItemLancamentoDTO(repos.save(subItem));
		}
		return null;
	}
	@Transactional
	public SubItemLancamentoDTO atualizaSubItens(SubItemLancamentoDTO subItenDto, Long idSubItem) {
		if(repos.existsById(idSubItem)) {
			if(reposItem.existsById(subItenDto.getIdItensLancamento())) {
				Optional<ItensLancamento> itenlancamento =reposItem.findById(subItenDto.getIdItensLancamento());
				subItenDto.setId(idSubItem);
				SubItemLancamento subItem = new SubItemLancamento(subItenDto.getId(),
						itenlancamento.get(),
						subItenDto.getDescricaoSub(), 
						subItenDto.getDataLancada(), 
						subItenDto.getValorLancada());
				return new SubItemLancamentoDTO(repos.save(subItem));
			}
		}
		return null;
	}
	@Transactional
	public void deletaSubItens(Long idSubItem) {
		if(repos.existsById(idSubItem)) {
			repos.deleteById(idSubItem);
			}
		}
}
