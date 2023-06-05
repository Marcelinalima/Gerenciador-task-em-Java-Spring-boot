package br.com.ml.gerenciadortask.service;

import br.com.ml.gerenciadortask.model.dto.TarefaDTO;
import br.com.ml.gerenciadortask.model.dto.TarefaInserirDTO;
import br.com.ml.gerenciadortask.model.dto.TarefaSalvoDTO;
import jakarta.validation.Valid;

public interface TarefaService {

        TarefaSalvoDTO salvar (TarefaDTO dto);

        void salvar(@Valid TarefaInserirDTO tarefa);

    }
    