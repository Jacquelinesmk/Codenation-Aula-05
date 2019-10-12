package br.com.controller;

import br.com.entity.Conta;
import br.com.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping("/conta")
    public ResponseEntity<Conta> addConta(@RequestBody Conta conta){
        try{
            return new ResponseEntity<>((Conta)contaService.add(conta), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/conta/{id}")
    public ResponseEntity<Conta> getConta(@PathVariable(value = "id") long id){
        try{
            return new ResponseEntity<>((Conta)contaService.get(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/conta")
    public ResponseEntity<Conta> updateConta(@RequestBody Conta conta){
        try{
            return new ResponseEntity<>((Conta)contaService.update(conta), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /*
    @PatchMapping("/conta/{id}")
    public @ResponseBody
    ResponseEntity<BigDecimal> patch(){
        return new ResponseEntity<BigDecimal>()
    }
    */

}
