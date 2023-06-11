package br.com.ml.gerenciadortask.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.ml.gerenciadortask.model.enums.FiltroStatus;

import lombok.Data;

@Data
public class TarefaInserirDto {

    private  Long id;
   
    
    private String nome;
    
   
    private String status;
    
    

    
    private LocalDate dataConclusao;

    
    
    private List<FiltroStatus> filtrosStatus = new ArrayList<>();

}