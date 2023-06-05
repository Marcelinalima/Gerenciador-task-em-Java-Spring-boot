package br.com.ml.gerenciadortask.model.dto;

import java.time.LocalDate;

import jakarta.persistence.Id;

import lombok.Data;

@Data
public class TarefaDTO {

 @Id
    private Long id;

    private String descricao;

    private String status;
    
    private LocalDate dataConclusao;
    
}