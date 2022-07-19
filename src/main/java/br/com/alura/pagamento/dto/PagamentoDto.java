package br.com.alura.pagamento.dto;

import br.com.alura.pagamento.model.Pagamento;

import java.math.BigDecimal;

public class PagamentoDto {

	private Long id;
	private BigDecimal valor;
	private String cpfCliente;
	private Long pedidoId;

	PagamentoDto() {
	}
	
	public PagamentoDto(Pagamento p) {
		this(p.getId(), p.getValor(), p.getCpfCliente(), p.getPedidoId());
	}

	PagamentoDto(Long id, BigDecimal valor, String cpfCliente, Long pedidoId) {
		this.id = id;
		this.valor = valor;
		this.cpfCliente = cpfCliente;
		this.pedidoId = pedidoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	@Override
	public String toString() {
		return "PagamentoDto [cpfCliente=" + cpfCliente + ", id=" + id + ", pedidoId=" + pedidoId + ", valor=" + valor
				+ "]";
	}

}
