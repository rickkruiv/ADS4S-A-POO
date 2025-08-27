package com.ads4s_a_poo.ads4s_a_poo.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity( name = "TBL_PESSOA" )
@Table( name = "PESSOA" )
public class PessoaModel {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long Id;

}
