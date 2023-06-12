
package br.com.ml.gerenciadortask.controller;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ml.gerenciadortask.exceptions.ObjetoNaoEncontradoException;
import br.com.ml.gerenciadortask.model.dto.TarefaDto;
import br.com.ml.gerenciadortask.model.dto.TarefaInserirDto;
import br.com.ml.gerenciadortask.model.entidades.Tarefa;
import br.com.ml.gerenciadortask.service.TarefaService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.Getter;

@Controller
@RequestMapping("/tarefas")
public class TarefaController{
     
    @Autowired @Getter
    private TarefaService service;
    

    @GetMapping("/formulario-tarefa")
    public String carregarFormulario(@PathParam("id") Long id, Model model) throws ObjetoNaoEncontradoException{
      if(Objects.nonNull(id)){
        Tarefa tarefa = service.procurarPeloId(id);
        model.addAttribute("tarefa", tarefa);
          return "form-tarefa";
      }
        model.addAttribute("tarefa", new TarefaInserirDto());
        return "form-tarefa";
    }
    @GetMapping
    public String procurarTodos(Model model){
      model.addAttribute("tarefas", service.findAll());
      return "lista-tarefa";

    }

      @PostMapping
      public String salvar( @ModelAttribute("tarefa") @Valid TarefaInserirDto tarefa,  Errors errors) throws Exception{ 
          if(!errors.hasErrors() && Objects.isNull(tarefa.getId())){
            TarefaDto tarefaSalva = getService().salvar(tarefa);
           tarefa.setId(tarefaSalva.getId());
           return "redirect:/tarefas/formulario-tarefa?id=" + tarefa.getId();
        }
        if(!errors.hasErrors() && Objects.isNull(tarefa.getId())){
            TarefaDto tarefaSalva = getService().salvar(tarefa);
           tarefa.setId(tarefaSalva.getId());

           return "redirect:/tarefas";
        }
          return "redirect:/tarefas";
      }
      @GetMapping("/remover")
      public String deletar(@PathParam("id") Long id){
        service.removerPeloId(id);
        return "/redirect:/tarefas";
      }
       
} 
   