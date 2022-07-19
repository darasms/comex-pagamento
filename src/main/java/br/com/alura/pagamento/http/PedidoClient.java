package br.com.alura.pagamento.http;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("ms-comex")
public interface PedidoClient {

    @RequestMapping(method = RequestMethod.PUT, value = "/api/pedidos/status_confirmado/{id}")
    void atualizarPagamento(@PathVariable Long id);
}
