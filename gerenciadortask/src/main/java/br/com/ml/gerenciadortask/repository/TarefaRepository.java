package br.com.ml.gerenciadortask.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.ml.gerenciadortask.model.entidades.Tarefa;



public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

     Optional<Tarefa> findById(Long id);

    
}