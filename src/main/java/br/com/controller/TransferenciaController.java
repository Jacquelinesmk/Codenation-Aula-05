package br.com.controller;

import br.com.entity.Transferencia;
import br.com.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransferenciaController {


    @Autowired
    private TransferenciaService transferenciaService;

    @PostMapping(value = "/transferencia")
    public ResponseEntity<Transferencia> addPessoa(@RequestBody Transferencia transferencia){
        try {
            return new ResponseEntity<>((Transferencia) transferenciaService.add(transferencia), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/transferencia/{id}")
    public ResponseEntity<Transferencia> getPessoa(@PathVariable(value = "id") long id){
        try{
            return new ResponseEntity<>((Transferencia)transferenciaService.get(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/transferencia")
    public ResponseEntity<Transferencia> updatePessoa(Transferencia transferencia){
        try{
            return new ResponseEntity<>((Transferencia) transferenciaService.update(transferencia), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
