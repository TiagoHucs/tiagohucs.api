package com.hucs.negocio.cliente;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService service;

    @Autowired
    private MapperFacade mapper;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<ClienteVO>> list() {
        List<ClienteVO> result = mapper.mapAsList(service.list(), ClienteVO.class);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody ClienteVO clienteVO) {
        service.save(mapper.map(clienteVO, Cliente.class));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody ClienteVO clienteVO) {
        service.save(mapper.map(clienteVO, Cliente.class));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClienteVO> get(@PathVariable("id") Long id) {
        ClienteVO vo = mapper.map(service.findById(id), ClienteVO.class);
        if (vo == null)
            throw new RuntimeException("Não encontrado");
        return ResponseEntity.status(HttpStatus.OK).body(vo);
    }

    @RequestMapping(value = "/tipos", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<TipoCliente>> tipos() {
        ArrayList<TipoCliente> tipos = new ArrayList<>();
        for (ETipoCliente tipoEnum : ETipoCliente.values()) {
            tipos.add(TipoCliente.builder()
                    .codigo(tipoEnum.getCodigo())
                    .descricao(tipoEnum.getDescricao())
                    .build());
        }
        return ResponseEntity.status(HttpStatus.OK).body(tipos);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResponseEntity<Long> count() {
        Long result = service.count();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
