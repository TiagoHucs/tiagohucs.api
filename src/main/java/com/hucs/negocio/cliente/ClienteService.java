package com.hucs.negocio.cliente;

import com.hucs.negocio.email.EmailService;
import com.hucs.negocio.orcamento.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private OrcamentoService orcamentoService;

    @Autowired
    private EmailService emailService;

    public List<Cliente> list() {
        return repository.findAll();
    }

    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    public Cliente findById(Long id) {
        return repository.findById(id).get();
    }

    public void delete(Long clienteId) {
        //TODO: deve ir para um validator
        if (orcamentoService.contarOrcamentosDoCliente(clienteId) > 0)
            throw new HttpServerErrorException(HttpStatus.FORBIDDEN, "Cliente com orçamentos associados");
        repository.deleteById(clienteId);
    }

    public long count() {
        return repository.count();
    }

    ;
}
