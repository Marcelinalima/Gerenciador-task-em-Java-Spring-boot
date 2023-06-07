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

    
    @Autowired
    @Getter
    private TarefaRepository repository;

    public TarefaDto salvar(TarefaInserirDto tarefaDto) {
        return tarefa2TarefaDtoBuilder(
            getRepository()
            .save(
             dto2TarefaBuilder(tarefaDto)
             )
        );
    }


    public Tarefa dto2TarefaBuilder(TarefaInserirDto tarefaInserirDto){
            return Tarefa.builder()
             .nome(tarefaInserirDto.getNome())
             .status(tarefaInserirDto.getStatus())
             .filtrosStatus(tarefaInserirDto.getFiltrosStatus())
             .dataConclusao(tarefaInserirDto.getDataConclusao())
             .build();

        }
        public TarefaDto tarefa2TarefaDtoBuilder(Tarefa tarefa){
            return TarefaDto.builder()
              .id(tarefa.getId())
              .status(tarefa.getStatus())
              .filtroStatus(tarefa.getFiltroStatus())
              .dataConclusao(tarefa.getDataConclusao())
              .build();
        }
    }
        /* private List<TarefaListaDTO> listaTarefa2ListaTarefaListaDTO(List<Tarefa>Tarefas) {
            return tarefas.stream().map(tarefa -> new TarefaListaDTO(tarefa.getId(), tarefa.getNome(),
                    tarefa.getSexo(),tarefa.get(), pesquisa.getGenerosFilme()))
                    .collect(Collectors.toList());
        }
        public List<PesquisaListaDTO> findAll() {
            return listaPesquisa2ListaPesquisaListaDTO(repository.findAll());
        }
    }     */


    