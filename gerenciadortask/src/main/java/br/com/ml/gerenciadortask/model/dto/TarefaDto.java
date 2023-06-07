package br.com.ml.gerenciadortask.model.dto;

import java.time.LocalDate;
import java.util.List;


import br.com.ml.gerenciadortask.model.enums.FiltroStatus;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TarefaDto {

 @Id
    private Long id;


    private String nome;

    private String status;

    private FiltroStatus filtroStatus ;
    
    private LocalDate dataConclusao;

    private List<FiltroStatus> filtrosStatus;
    
}