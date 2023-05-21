package br.com.ths.ctrlFinan.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ths.ctrlFinan.Services.SubItemLancamentoService;
import br.com.ths.ctrlFinan.dtos.SubItemLancamentoDTO;

@RestController
@RequestMapping(value="/subitenslancamento")
public class SubItemLancamentoController {
	
	@Autowired
	private SubItemLancamentoService service;
	
	@GetMapping
	public List<SubItemLancamentoDTO> findAllSubItens(){
		return service.findAllSubItens();
	}

	@GetMapping (value="/{id}")
	public SubItemLancamentoDTO findByIdSubItem(Long id) {
		return service.findByIdSubItens(id);
	}
	@PostMapping (value="/novo")
	@ResponseStatus(HttpStatus.CREATED)
	public SubItemLancamentoDTO novoSubItemLancamento(@RequestBody SubItemLancamentoDTO subItemLancamentoDto) {
		return service.saveSubItens(subItemLancamentoDto);
	}
	
	@PutMapping (value="/{id}/atualiza")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public SubItemLancamentoDTO atualizaSubItemLancamento(@RequestBody SubItemLancamentoDTO subItemLancamentoDto,@PathVariable Long id) {
		return service.atualizaSubItens(subItemLancamentoDto, id);
	}
	
	@DeleteMapping(value="/{id}/deleta")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void deletaSubItemLancamento(@PathVariable Long id) {
		service.deletaSubItens(id);
	}
}
