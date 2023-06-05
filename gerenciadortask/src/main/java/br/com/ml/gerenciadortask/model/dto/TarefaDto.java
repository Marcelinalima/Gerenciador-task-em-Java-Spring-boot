package br.com.ml.gerenciadortask.model.dto;



import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class TarefaDto {

    private Long id;

    private String descricao;

    private String status;
    
    private LocalDate dataConclusao;
    
}