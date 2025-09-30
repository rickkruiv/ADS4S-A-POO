package com.ads4s_a_poo.ads4s_a_poo.service;

import com.ads4s_a_poo.ads4s_a_poo.model.PessoaModel;
import com.ads4s_a_poo.ads4s_a_poo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaModel salvar(PessoaModel pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<PessoaModel> listarTodas() {
        return pessoaRepository.findAll();
    }

    public Optional<PessoaModel> buscarPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }
}
