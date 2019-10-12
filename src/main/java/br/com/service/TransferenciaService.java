package br.com.service;

import br.com.entity.Transferencia;
import br.com.interfaces.Contrato;
import br.com.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService implements Contrato {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Override
    public Object add(Object object) {
        return transferenciaRepository.save((Transferencia) object);
    }

    @Override
    public Object get(long id) {
        return transferenciaRepository.findById(id);
    }

    @Override
    public Object update(Object object) {
        return transferenciaRepository.save((Transferencia) object);
    }
}
