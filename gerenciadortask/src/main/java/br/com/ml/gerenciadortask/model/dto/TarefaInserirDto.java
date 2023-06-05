package br.com.ml.gerenciadortask.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TarefaInserirDto {

    
     private String descricao;

    private String status;
    
    private LocalDate dataConclusao;
   

    
}