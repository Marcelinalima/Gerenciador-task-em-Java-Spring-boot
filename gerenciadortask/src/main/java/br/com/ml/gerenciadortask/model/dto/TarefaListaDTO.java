package br.com.ml.gerenciadortask.model.dto;

import java.time.LocalDate;
import java.util.List;
import br.com.ml.gerenciadortask.model.enums.FiltroStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TarefaListaDTO {

        public TarefaListaDTO(Long id2, String nome2, String status2, FiltroStatus filtroStatus2,
                        LocalDate dataConclusao2) {
        }

        private Long id;
    
        private String nome;
    
        private String status;
        
        private FiltroStatus filtroStatus;

        private LocalDate dataConclusao;
    
        private List<FiltroStatus> filtrosStatus ; 
    
}