package pacoteTarefas.controller;

import pacoteTarefas.model.Tarefa;
import pacoteTarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repositorioTarefa;

    //EndPoint - Para Criar uma nova taref
    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        //salva a tarefa criada
        return repositorioTarefa.save(tarefa);
    }

    //EndPoint - Para Consultar todas as tarefas
    @GetMapping
    public List<Tarefa> listarTarefas() {
        //Retorna todas as tarefas do repositorio
        return repositorioTarefa.findAll();
    }

    //EndPoint - Para Consultar uma tarefa pelo ID da tarefa
    @GetMapping("/{ id }")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = repositorioTarefa.findById(id);
        //condição que verifica se a tarefa existe
        if (tarefa.isPresent()) {
            return ResponseEntity.ok(tarefa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // EndPoint - Para Atualizar uma tarefa
    @PutMapping(" /{ id } ")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa detalhesTarefa) {
        Optional<Tarefa> tarefaOptional = repositorioTarefa.findById(id);
        //condição que verifica se a tarefa existe para atualiza-la
        if (tarefaOptional.isPresent()) {
            Tarefa tarefa = tarefaOptional.get();
            tarefa.setNome(detalhesTarefa.getNome());
            tarefa.setDataEntrega(detalhesTarefa.getDataEntrega());
            tarefa.setResponsavel(detalhesTarefa.getResponsavel());
            Tarefa tarefaAtualizada = repositorioTarefa.save(tarefa);
            //retorna status positivo da alteração
            return ResponseEntity.ok(tarefaAtualizada);
        } else {
            //retorna nao encontou tarefa
            return ResponseEntity.notFound().build();
        }
    }

    // EndPoint - para Remover uma tarefa
    @DeleteMapping(" /{ id }")
    public ResponseEntity<Void> removerTarefa(@PathVariable Long id) {
        Optional<Tarefa> tarefaOptional = repositorioTarefa.findById(id);
        //condição que verifica se a tarefa existe para removela do repositório
        if (tarefaOptional.isPresent()) {
            repositorioTarefa.deleteById(id);
            //retona status positivo de exclusão do repositorio
            return ResponseEntity.noContent().build();
        } else {
            //retona status de tarefa nao encontrada
            return ResponseEntity.notFound().build();
        }
    }
}