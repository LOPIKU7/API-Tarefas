package pacoteTarefas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

//classe responsavel pelos metodos get() e set() dos dados das tarefas
@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataEntrega;
    private String responsavel;

    public Tarefa() {
    }

    //anexa aos atributos os dados dos parametros da funçao
    public Tarefa(String nome, LocalDate dataEntrega, String responsavel) {
        this.nome = nome;
        this.dataEntrega = dataEntrega;
        this.responsavel = responsavel;
    }

    //get do ID da tarefa
    public Long getId() {
        return id;
    }

    //set do ID da tarefa
    public void setId(Long id) {
        this.id = id;
    }

    //get do titulo da tarefa
    public String getNome() {
        return nome;
    }

    //set do titulo da tarefa
    public void setNome(String nome) {
        this.nome = nome;
    }

    //get data de entrega da tarefa
    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    //set data de entrega da tarefa
    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    //get do responsavel pela tarefa
    public String getResponsavel() {
        return responsavel;
    }

    //set do responsavel pela tarefa
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}