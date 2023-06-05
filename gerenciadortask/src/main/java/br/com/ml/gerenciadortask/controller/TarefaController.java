
package br.com.ml.gerenciadortask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ml.gerenciadortask.model.dto.TarefaInserirDto;
import br.com.ml.gerenciadortask.model.entidades.Tarefa;
import br.com.ml.gerenciadortask.service.TarefaService;
import jakarta.validation.Valid;
import lombok.Getter;


@Controller
@RequestMapping("/tarefas")
public class TarefaController{
    
    @Autowired @Getter
    private TarefaService service;

    @GetMapping("/form-tarefas")
    public String loadFormulario(Model model){
        model.addAttribute("tarefa", new Tarefa());
        return "form-tarefa";

    }
    @PostMapping
    public String salvar( @ModelAttribute("tarefa") @Valid TarefaInserirDto tarefa) throws Exception{
        getService().salvar(tarefa);
        return "form-tarefa";
    }
   



}