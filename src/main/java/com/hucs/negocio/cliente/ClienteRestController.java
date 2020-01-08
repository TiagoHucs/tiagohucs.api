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
    public ResponseEntity<List<ClienteVO>> list(){
        try {
            List<ClienteVO> result = mapper.mapAsList(service.list(),ClienteVO.class);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save( @RequestBody ClienteVO clienteVO) {
        try {
            service.save(mapper.map(clienteVO,Cliente.class));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Void> update( @RequestBody ClienteVO clienteVO) {
        try {
            service.save(mapper.map(clienteVO,Cliente.class));
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

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClienteVO>  get(@PathVariable("id") Long id) {

        try {
            ClienteVO vo = mapper.map(service.findById(id),ClienteVO.class);
            return ResponseEntity.status(HttpStatus.OK).body(vo);
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
