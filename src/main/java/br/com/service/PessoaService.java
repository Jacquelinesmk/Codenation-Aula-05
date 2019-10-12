package br.com.service;

import br.com.entity.Pessoa;
import br.com.interfaces.Contrato;
import br.com.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PessoaService implements Contrato {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Object add(Object object) {
        return pessoaRepository.save((Pessoa)object);

    }

    @Override
    public Object get(long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public Object update(Object object) {
        return pessoaRepository.save((Pessoa)object);
    }
}
