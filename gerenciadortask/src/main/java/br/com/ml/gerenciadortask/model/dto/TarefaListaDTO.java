package br.com.ml.gerenciadortask.model.dto;

import java.time.LocalDate;
import java.util.List;
import br.com.ml.gerenciadortask.model.enums.FiltroStatus;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class TarefaListaDTO {


       private Long id;
    
        private String nome;

        private String filtroStatus;

        private LocalDate dataConclusao;
    
        private List<FiltroStatus> filtrosStatus ; 
    
}
        
