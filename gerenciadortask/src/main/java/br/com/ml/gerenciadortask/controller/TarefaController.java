
package br.com.ml.gerenciadortask.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    

    @GetMapping("/new-tarefa")
    public String carregarFormulario(Model model){
        model.addAttribute("tarefa", new Tarefa());
        return "form-tarefa";
    }
    @GetMapping("/lista-tarefa")
    public String findAll(Model model){
      model.addAttribute("tarefas", service.findAll());
      return "lista-tarefa";

    }

      @PostMapping
      public String salvar( @ModelAttribute("tarefa") @Valid TarefaInserirDto tarefa, Errors errors ) throws Exception{
         if(!errors.hasErrors()){
          getService().salvar(tarefa);
         }
          return "form-tarefa";
      }
      @GetMapping("/delete")
      public String deletar(@PathParam("id") Long id){
        service.deleteById(id);
        return "/lista-tarefa";
      }
       
} 
   