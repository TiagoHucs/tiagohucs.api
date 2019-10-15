package com.example.controller;

import com.example.controller.mapper.OrcamentoMapper;
import com.example.controller.model.OrcamentoVO;
import com.example.model.Orcamento;
import com.example.service.ClienteService;
import com.example.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/orcamentos")
public class OrcamentoController {

    @Autowired
    private OrcamentoService service;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private OrcamentoMapper mapper;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<OrcamentoVO>> list(){
        try {
            List<OrcamentoVO> result = mapper.mapAsList(service.list());
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody OrcamentoVO vo) {

        try {
            service.save(mapper.map(vo));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Void> update( @RequestBody Orcamento orcamento) {

        try {
            service.save(orcamento);
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