package com.ads4s_a_poo.ads4s_a_poo.repository;

import com.ads4s_a_poo.ads4s_a_poo.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
}
