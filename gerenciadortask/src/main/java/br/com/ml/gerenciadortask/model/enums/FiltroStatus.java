package br.com.ml.gerenciadortask.model.enums;
import lombok.Getter;
import lombok.Setter;


public enum FiltroStatus {

    PENDENTE("Pendente"),
    PROGRESSO("Progresso"),
    CANCELADA("Cancelada"),
    CONCLUIDA("Concluída");

    @Getter @Setter
    private String descricao;
     
    FiltroStatus(String descricao){
        this.descricao = descricao;
    }
   

   }


