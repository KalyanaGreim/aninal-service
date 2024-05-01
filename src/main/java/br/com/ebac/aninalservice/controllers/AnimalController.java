package br.com.ebac.aninalservice.controllers;

import br.com.ebac.aninalservice.entidades.Animal;
import br.com.ebac.aninalservice.repositorios.AnimalRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private AnimalRepository repository;

    public AnimalController(AnimalRepository repository){
        this.repository = repository;
    }

    @GetMapping
    private List<Animal> findAll(){
        return repository.findAll();
    }

    @PostMapping
    private Animal create(@RequestBody Animal animal){
        return repository.save(animal);
    }

    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted() {
        return repository.findNotAdopted();
    }

    @GetMapping("/adopted")
    private List<Animal> findAdopted() {
        return repository.findAdopted();
    }

    @GetMapping("/resgates-por-funcionario")
    private List<Object[]> contarResgatesPorFuncionarioNoPeriodo(@RequestParam String nomeReceber,
                                                                 @RequestParam String dataInicio,
                                                                 @RequestParam String dataFim) {
        LocalDate inicio = LocalDate.parse(dataInicio);
        LocalDate fim = LocalDate.parse(dataFim);

        // Limitar o intervalo a 1 ano
        if (inicio.plusYears(1).isBefore(fim)) {
            throw new IllegalArgumentException("Intervalo máximo permitido é de 1 ano.");
        }

        return repository.contarAnimaisPorFuncionarioNoPeriodo(nomeReceber, inicio, fim);
    }



}
