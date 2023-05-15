package br.com.ths.ctrlFinan.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ths.ctrlFinan.Services.ItensLancamentoService;
import br.com.ths.ctrlFinan.dtos.ItensLancamentoDTO;

@RestController
@RequestMapping(value="/itenslancamento")
public class ItensLancamentoController {
	
	@Autowired
	private ItensLancamentoService service;
	
	@GetMapping
	public List<ItensLancamentoDTO> findAllItensLancamento(){
		return service.findAll();
	}

}
