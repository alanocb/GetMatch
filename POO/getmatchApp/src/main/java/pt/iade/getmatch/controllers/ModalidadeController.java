package pt.iade.getmatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.getmatch.Repository.ModalidadeRepository;
import pt.iade.getmatch.models.Modalidade;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/modalidade")
public class ModalidadeController {

    @Autowired
    private ModalidadeRepository modalidadeRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Modalidade> getModalidades() {
        return modalidadeRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Modalidade> getModalidade(@PathVariable("id") int id) {

        return modalidadeRepository.findById(id);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Modalidade saveModalidade(@RequestBody Modalidade user) {
        return modalidadeRepository.save(user);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteModalidade(@PathVariable("id") int id) {

        modalidadeRepository.deleteById(id);
    }

}