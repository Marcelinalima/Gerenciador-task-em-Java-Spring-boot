package br.com.ml.gerenciadortask.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return tarefa2TarefaDtoBuilder(
            getRepository()
            .save(
             dto2TarefaBuilder(tarefaDto)  )
        );
    }
    public List<TarefaListaDTO> findAll() {
        return listaTarefa2ListaTarefaListaDTO(repository.findAll());
    }


    private Tarefa dto2TarefaBuilder(TarefaInserirDto tarefaInserirDto){
            return Tarefa.builder()
             .nome(tarefaInserirDto.getNome())
             .status(tarefaInserirDto.getStatus())
             .filtrosStatus(tarefaInserirDto.getFiltrosStatus())
             .dataConclusao(tarefaInserirDto.getDataConclusao())
             .build();

        }
    private TarefaDto tarefa2TarefaDtoBuilder(Tarefa tarefa){
            return TarefaDto.builder()
              .id(tarefa.getId())
              .status(tarefa.getStatus())
              
              .dataConclusao(tarefa.getDataConclusao())
              .build();
        }
    
        private List<TarefaListaDTO> listaTarefa2ListaTarefaListaDTO(List<Tarefa> tarefas){
            return tarefas.stream().map(tarefa -> new TarefaListaDTO(tarefa.getId(), tarefa.getNome(),
            tarefa.getStatus(), tarefa.getFiltroStatus(), tarefa.getDataConclusao()))
            .collect(Collectors.toList());

        }
        public void deleteById(String id) {
            Long idTarefa =Long.parseLong(id);
            repository.deleteById(idTarefa);
        }
        public void removerPeloId(String id) {
        }
             
                    
        }
       
        


    