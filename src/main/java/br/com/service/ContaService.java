package br.com.service;

import br.com.entity.Conta;
import br.com.interfaces.Contrato;
import br.com.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ContaService implements Contrato {

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public Object add(Object object) {
        return contaRepository.save((Conta)object);
    }

    @Override
    public Object get(long id) {
        return contaRepository.findById(id);
    }

    @Override
    public Object update(Object object) {
        return contaRepository.save((Conta)object);
    }
}
