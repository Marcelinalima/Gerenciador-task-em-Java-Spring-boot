
package br.com.ml.gerenciadortask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import br.com.ml.gerenciadortask.model.dto.TarefaInserirDTO;
import br.com.ml.gerenciadortask.model.entidades.Tarefa;
import br.com.ml.gerenciadortask.service.TarefaService;
import jakarta.validation.Valid;
import lombok.Getter;



@Controller
@RequestMapping("/tarefas")
public class TarefaController{
 
    @Autowired
    @Getter
    private TarefaService TarefaService;
    
   

    @GetMapping("/form-tarefa")
    public String formTarefa(Model model){
        model.addAttribute("tarefa", new Tarefa());
    
        return "form-tarefa";

    }
    
    @PostMapping("/save")
    public String salvarTarefa(@ModelAttribute("tarefa") @Valid TarefaInserirDTO tarefa) throws Exception{
      
        getTarefaService().salvar(tarefa);
        return "form-tarefa";
    }
   



}