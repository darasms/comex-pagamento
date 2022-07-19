package br.com.alura.pagamento.controller;

import br.com.alura.pagamento.dto.PagamentoDto;
import br.com.alura.pagamento.http.PedidoClient;
import br.com.alura.pagamento.model.Pagamento;
import br.com.alura.pagamento.repository.PagamentoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pagamentos")
class PagamentoController {

	private final PagamentoRepository pagamentoRepository;

	private final PedidoClient pedidoClient;

	public PagamentoController(PagamentoRepository pagamentoRepository, PedidoClient pedidoClient) {
		this.pagamentoRepository = pagamentoRepository;
		this.pedidoClient = pedidoClient;
	}

	@GetMapping("/{id}")
	PagamentoDto detalha(@PathVariable("id") Long id) {
		Pagamento pagamento = pagamentoRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return new PagamentoDto(pagamento);
	}

	@PostMapping
	ResponseEntity<PagamentoDto> cria(@RequestBody Pagamento pagamento, UriComponentsBuilder uriBuilder) {
		Pagamento salvo = pagamentoRepository.save(pagamento);
		URI path = uriBuilder.path("/pagamentos/{id}").buildAndExpand(salvo.getId()).toUri();
		return ResponseEntity.created(path).body(new PagamentoDto(salvo));
	}


	@PatchMapping("/confirmar/{id}")
	ResponseEntity<Void> confirmarPagamento(@PathVariable Long id){
		pedidoClient.atualizarPagamento(id);
		System.out.println(">>>>>>   PASSEI AQUI");
		return ResponseEntity.ok().build();
	}

}