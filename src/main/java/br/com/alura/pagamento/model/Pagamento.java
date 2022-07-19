package br.com.alura.pagamento.model;

import br.com.alura.pagamento.enuns.StatusPagamento;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull @Positive
	private BigDecimal valor;

	@NotBlank  @Size(max=100)
	private String cpfCliente;

	@Column(nullable=false)
	private Long pedidoId;

	@Enumerated(EnumType.STRING)
	private StatusPagamento statusPagamento = StatusPagamento.EM_ANDAMENTO;

	public Pagamento() {
	}

	public Pagamento(Long id, @NotNull @Positive BigDecimal valor, @NotBlank @Size(max = 100) String cpfCliente,
			Long pedidoId) {
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

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	@Override
	public String toString() {
		return "Pagamento [cpfCliente=" + cpfCliente + ", id=" + id + ", pedidoId=" + pedidoId + ", valor=" + valor
				+ "]";
	}

}
