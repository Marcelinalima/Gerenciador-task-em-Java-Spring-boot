package br.com.ml.gerenciadortask.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ml.gerenciadortask.model.dto.TarefaDTO;
import br.com.ml.gerenciadortask.model.dto.TarefaInserirDTO;
import br.com.ml.gerenciadortask.model.dto.TarefaSalvoDTO;
import br.com.ml.gerenciadortask.model.entidades.Tarefa;
import br.com.ml.gerenciadortask.repository.TarefaRepository;
import br.com.ml.gerenciadortask.service.TarefaService;
import jakarta.validation.Valid;
import lombok.Getter;

@Service
public class TarefaServiceImpl implements TarefaService{

    @Autowired
    @Getter
    private TarefaRepository tarefaRepository;

    @Override
    public TarefaSalvoDTO salvar(TarefaDTO dto) {
        Tarefa tarefa = new Tarefa();
        TarefaSalvoDTO tarefaSalvoDTO = new TarefaSalvoDTO();
        
        BeanUtils.copyProperties(dto, tarefa );
        tarefa = getTarefaRepository().save(tarefa);
        BeanUtils.copyProperties(tarefa, tarefaSalvoDTO );
         return null;
    }

    @Override
    public void salvar(@Valid TarefaInserirDTO tarefa) {
       
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    
   

    

    
    
}