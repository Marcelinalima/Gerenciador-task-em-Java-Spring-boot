package br.com.ml.gerenciadortask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ml.gerenciadortask.model.dto.TarefaDto;
import br.com.ml.gerenciadortask.model.dto.TarefaInserirDto;
import br.com.ml.gerenciadortask.model.entidades.Tarefa;
import br.com.ml.gerenciadortask.repository.TarefaRepository;
import lombok.Getter;


@Service
public class TarefaService {

    @Autowired @Getter
    private TarefaRepository repository;

    public TarefaDto salvar( TarefaInserirDto tarefaDto){
        return tarefa2TarefaDtoBuilder(
        getRepository()
        .save(
            dto2TarefaBuilder(tarefaDto))
            );

    }
    public Tarefa dto2TarefaBuilder(TarefaInserirDto tarefaInserirDto){
         return Tarefa.builder()
            .descricao(tarefaInserirDto.getDescricao())
            .status(tarefaInserirDto.getStatus())
            .dataConclusao(tarefaInserirDto.getDataConclusao())
            .build();
    
        
    }
   
    public TarefaDto tarefa2TarefaDtoBuilder(Tarefa tarefa){
        return TarefaDto.builder()
          .id(tarefa.getId())
          .descricao(tarefa.getDescricao())
          .status(tarefa.getStatus())
          .dataConclusao(tarefa.getDataConclusao())
          .build();
    }
}    

    
