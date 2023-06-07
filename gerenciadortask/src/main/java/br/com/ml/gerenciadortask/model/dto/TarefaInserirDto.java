package br.com.ml.gerenciadortask.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.ml.gerenciadortask.model.enums.FiltroStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class TarefaInserirDto {

    
    @NotBlank(message = "Nome não pode ser vazio")
    @Size(min = 5, max = 100, message = "Nome deve ter no mínimo 5 e no máximo 100 caracteres")
    private String nome;
    
    @NotBlank(message = "Status não pode ser vazio")
    private String status;
    
    

    @NotNull(message = " DataConclusão precisa ser preenchido")
    private LocalDate dataConclusao;

    
    @NotNull(message = "Status precisa ser preenchido")
    private List<FiltroStatus> filtrosStatus = new ArrayList<>();

}