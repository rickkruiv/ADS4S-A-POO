package com.ads4s_a_poo.ads4s_a_poo.controller;

import com.ads4s_a_poo.ads4s_a_poo.model.PessoaModel;
import com.ads4s_a_poo.ads4s_a_poo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaModel> criarPessoa(@RequestBody PessoaModel pessoa) {
        PessoaModel novaPessoa = pessoaService.salvar(pessoa);
        return ResponseEntity.ok(novaPessoa);
    }

    @GetMapping
    public ResponseEntity<List<PessoaModel>> listarPessoas() {
        return ResponseEntity.ok(pessoaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaModel> buscarPessoa(@PathVariable Long id) {
        Optional<PessoaModel> pessoa = pessoaService.buscarPorId(id);
        return pessoa.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaModel> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaModel dadosAtualizados) {
        Optional<PessoaModel> pessoaExistente = pessoaService.buscarPorId(id);

        if (pessoaExistente.isPresent()) {
            PessoaModel pessoa = pessoaExistente.get();
            pessoa.setNome(dadosAtualizados.getNome());
            pessoa.setEmail(dadosAtualizados.getEmail());
            pessoa.setCpf(dadosAtualizados.getCpf());
            pessoa.setDataNascimento(dadosAtualizados.getDataNascimento());

            PessoaModel pessoaAtualizada = pessoaService.salvar(pessoa);
            return ResponseEntity.ok(pessoaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        Optional<PessoaModel> pessoa = pessoaService.buscarPorId(id);

        if (pessoa.isPresent()) {
            pessoaService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
