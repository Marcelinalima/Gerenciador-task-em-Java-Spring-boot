package br.com.ml.gerenciadortask.model.entidades;

import java.time.LocalDate;
import java.util.List;
import br.com.ml.gerenciadortask.model.enums.FiltroStatus;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder 
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true )
@Entity

public class Tarefa {

   @Id
   @GeneratedValue( strategy = GenerationType.IDENTITY)
   @EqualsAndHashCode.Include
   @Getter
    private Long id;

    @Getter
    @Setter
    private String nome;
    
    @Getter
    @Setter
    private String filtroStatus;

    @Getter
    @Setter
    private LocalDate dataConclusao;
     

    @Getter
    @Setter
    @ElementCollection(targetClass = FiltroStatus.class, fetch = FetchType.LAZY)
    @JoinTable(name = "tarefa_status", joinColumns = @JoinColumn(name ="tarefa_id"))
    @JoinColumn(name = "tarefa_id")

    @Column(name = "ex_Status", nullable = false)
    private List<FiltroStatus> filtrosStatus;


}