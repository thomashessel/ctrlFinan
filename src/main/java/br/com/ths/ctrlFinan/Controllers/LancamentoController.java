package br.com.ths.ctrlFinan.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ths.ctrlFinan.Entities.Lancamento;
import br.com.ths.ctrlFinan.Services.LancamentoService;
import br.com.ths.ctrlFinan.dtos.LancamentoComObjItemDTO;
import br.com.ths.ctrlFinan.dtos.LancamentoSemObjItemDTO;


@RestController
@RequestMapping(value="/lancamentos")
public class LancamentoController {

	
	@Autowired
	private LancamentoService service;
	
	@GetMapping
	public List<LancamentoComObjItemDTO> findAll(){
		return service.findAllLancamento();
	}
	@GetMapping (value="/{id}")
	public LancamentoSemObjItemDTO findById(@PathVariable Long id){
		return service.findByIdLancamento(id);
	}
	
	@PostMapping (value="/novo")
	public LancamentoSemObjItemDTO SalvaNovoLancamento(@RequestBody LancamentoSemObjItemDTO lancamento) {
		return service.salvaNovoLancamento(lancamento);
	}
}
