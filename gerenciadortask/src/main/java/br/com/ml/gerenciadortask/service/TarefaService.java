package br.com.ml.gerenciadortask.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ml.gerenciadortask.exceptions.ObjetoNaoEncontradoException;
import br.com.ml.gerenciadortask.model.dto.TarefaDto;
import br.com.ml.gerenciadortask.model.dto.TarefaInserirDto;
import br.com.ml.gerenciadortask.model.dto.TarefaListaDTO;
import br.com.ml.gerenciadortask.model.entidades.Tarefa;
import br.com.ml.gerenciadortask.repository.TarefaRepository;
import lombok.Getter;
@Service

public class TarefaService {
    @Autowired
    @Getter
    private TarefaRepository repository;

    public TarefaDto salvar(TarefaInserirDto tarefaDto) {
        return tarefaTarefaDtoBuilder(
            getRepository()
            .save(
             dtoTarefaBuilder(tarefaDto)  )
        );
    }
    public List<TarefaListaDTO> findAll() {
        return listaTarefaListaTarefaListaDTO(repository.findAll());
    }
    
    // Converte um DTO para uma Tarefa
    private Tarefa dtoTarefaBuilder(TarefaInserirDto tarefaInserirDto){
            return Tarefa.builder()
             .id(tarefaInserirDto.getId())
             .nome(tarefaInserirDto.getNome())
             .filtrosStatus(tarefaInserirDto.getFiltrosStatus())
             .dataConclusao(tarefaInserirDto.getDataConclusao())
             .build();

        }
    //Converte uma pesquisa em uma TarefaDto   
    private TarefaDto tarefaTarefaDtoBuilder(Tarefa tarefa){
            return TarefaDto.builder()
              .id(tarefa.getId())
              .nome(tarefa.getNome())
              .filtrosStatus(tarefa.getFiltrosStatus())
              .dataConclusao(tarefa.getDataConclusao())
              .build();
        }

         private List<TarefaListaDTO> listaTarefaListaTarefaListaDTO(List<Tarefa> tarefas){
            return tarefas.stream().map(tarefa -> new TarefaListaDTO(tarefa.getId(), tarefa.getNome(), tarefa.getFiltroStatus(),
            tarefa.getDataConclusao(), null))
            .collect(Collectors.toList());

        }
        public void removerPeloId(Long id) {
            repository.deleteById(id);
        }
        public Tarefa procurarPeloId(Long id) throws ObjetoNaoEncontradoException {
            return  repository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não o no banco de dados"));

        }
        
    }    
        
       
        


    