package br.com.ml.gerenciadortask.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.ml.gerenciadortask.model.enums.FiltroStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data

public class TarefaInserirDto {

    
    @NotBlank
   
    private String nome;
    
    
    private String status;
    
    private FiltroStatus filtroStatus ;

   
    private LocalDate dataConclusao;

    @NotNull(message = "filtros de Status precisa ser preenchido")
    
    private List<FiltroStatus> filtrosStatus = new ArrayList<>();

}