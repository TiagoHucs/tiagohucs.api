package com.example.cliente;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    public ResponseEntity<List<ClienteVO>> list(){
        try {
            List<ClienteVO> result = mapper.mapAsList(service.list(),ClienteVO.class);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save( @RequestBody ClienteVO clienteVo) {
        try {
            service.save(mapper.map(clienteVo,Cliente.class));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Void> update( @RequestBody Cliente cliente) {

        try {
            service.save(cliente);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch(Exception e ) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @RequestMapping(value = "/tipos", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<TipoCliente>> tipos(){
        ArrayList<TipoCliente> tipos = new ArrayList<>();
        try {
            for (ETipoCliente tipoEnum: ETipoCliente.values()) {
                tipos.add(TipoCliente.builder()
                        .codigo(tipoEnum.getCodigo())
                        .descricao(tipoEnum.getDescricao())
                        .build());
            }
            return ResponseEntity.status(HttpStatus.OK).body(tipos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResponseEntity<Long> count() {
        try {
            Long result = service.count();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
