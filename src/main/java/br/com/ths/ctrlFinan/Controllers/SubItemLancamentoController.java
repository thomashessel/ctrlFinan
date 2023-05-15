package br.com.ths.ctrlFinan.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ths.ctrlFinan.Services.SubItemLancamentoService;
import br.com.ths.ctrlFinan.dtos.SubItemLancamentoDTO;

@RestController
@RequestMapping(value="/subitenslancamento")
public class SubItemLancamentoController {
	
	@Autowired
	private SubItemLancamentoService service;
	
	@GetMapping
	public List<SubItemLancamentoDTO> findAllItensLancamento(){
		return service.findAllSubItens();
	}

}
