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

import br.com.ths.ctrlFinan.Services.ItensLancamentoService;
import br.com.ths.ctrlFinan.dtos.ItensLancamentoDTO;
import br.com.ths.ctrlFinan.dtos.LancamentoSemObjItemDTO;

@RestController
@RequestMapping(value="/itenslancamento")
public class ItensLancamentoController {
	
	@Autowired
	private ItensLancamentoService service;
	
	@GetMapping
	public List<ItensLancamentoDTO> findAllItensLancamento(){
		return service.findAll();
	}
	@GetMapping (value="/{id}")
	public ItensLancamentoDTO findById(@PathVariable Long id){
		return service.findByIdItem(id);
	}
	@PostMapping (value="/novo")
	@ResponseStatus(HttpStatus.CREATED)
	public ItensLancamentoDTO novoItemLancamento(@RequestBody ItensLancamentoDTO lancamento) {
		return service.salvaItemLancamento(lancamento);
	}
	@PutMapping (value="/{id}/atualiza")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ItensLancamentoDTO atualizaItemLancamento(@PathVariable Long id,@RequestBody ItensLancamentoDTO lancamento) {
		return service.atualizaItemLancamento(lancamento, id);
	}
	
	@DeleteMapping(value="/{id}/deleta")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void deletaLancamento(@PathVariable Long id) {
		service.deletaItemLancamento(id);
	}
}
