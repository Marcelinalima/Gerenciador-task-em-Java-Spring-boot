package br.com.ml.gerenciadortask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ml.gerenciadortask.model.entidades.Tarefa;
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

    Tarefa findByIdAndNome(Long id, String nome);
 

    
}
    
