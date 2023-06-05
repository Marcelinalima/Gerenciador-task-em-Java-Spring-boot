package br.com.ml.gerenciadortask.model.entidades;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true )
@Entity
@Table(name = "TAREFA")
public class Tarefa {

   @EqualsAndHashCode.Include
   @Getter
   @Id
   @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String descricao;

    @Getter
    @Setter
    private String  status;

    @Getter
    @Setter
    private LocalDate dataConclusao;
    

}