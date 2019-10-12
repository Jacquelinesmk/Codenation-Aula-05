package br.com.controller;

import br.com.entity.Pessoa;
import br.com.repository.PessoaRepository;
import br.com.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping(value = "/pessoa")
    public ResponseEntity<Pessoa> addPessoa(@RequestBody Pessoa pessoa){
        try {
           return new ResponseEntity<>((Pessoa)pessoaService.add(pessoa), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/pessoa/{id}")
    public ResponseEntity<Pessoa> getPessoa(@PathVariable(value = "id") long id){
        try{
            return new ResponseEntity<>((Pessoa)pessoaService.get(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/pessoa")
    public ResponseEntity<Pessoa> updatePessoa(Pessoa pessoa){
        try{
            return new ResponseEntity<>((Pessoa)pessoaService.update(pessoa), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
