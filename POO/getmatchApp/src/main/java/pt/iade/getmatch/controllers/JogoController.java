package pt.iade.getmatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iade.getmatch.Repository.JogoRepository;
import pt.iade.getmatch.Repository.ModalidadeRepository;
import pt.iade.getmatch.Repository.ParticipanteJogoRepository;
import pt.iade.getmatch.Repository.UserRepository;
import pt.iade.getmatch.dto.ErrorResponse;
import pt.iade.getmatch.dto.SuccessResponse;
import pt.iade.getmatch.dto.request.JogoRequest;
import pt.iade.getmatch.models.Jogo;
import pt.iade.getmatch.models.ParticipanteJogo;

import java.util.List;

@RestController
@RequestMapping(path = "/api/jogo")
public class JogoController {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModalidadeRepository modalidadeRepository;

    @Autowired
    private ParticipanteJogoRepository participanteJogoRepository;

    @GetMapping
    public List<Jogo> getJogos() {
        return jogoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> saveJogo(@RequestBody JogoRequest jogoRequest) {
        var user = this.userRepository.findById(jogoRequest.getIdUser());
        if (!user.isPresent()) {
            var errorResponse = new ErrorResponse();
            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
            errorResponse.setMessage("Usuario nao existente");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        var modalidade = this.modalidadeRepository.findById(jogoRequest.getIdModalidade());
        if (!modalidade.isPresent()) {
            var errorResponse = new ErrorResponse();
            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
            errorResponse.setMessage("Modalidade nao encontrada");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        var jogo = new Jogo();
        jogo.setUser(user.get());
        jogo.setModalidade(modalidade.get());
        this.jogoRepository.save(jogo);

        for (int participante : jogoRequest.getParticipantes()) {
            var jogadorExiste = this.userRepository.findById(participante);
            if (jogadorExiste.isPresent()) {
                var participanteJogo = new ParticipanteJogo();
                participanteJogo.setJogoId(jogo.getId());
                participanteJogo.setUserId(participante);
                this.participanteJogoRepository.save(participanteJogo);
            }
        }

        var successResponse = new SuccessResponse();
        successResponse.setStatus(HttpStatus.OK.value());
        successResponse.setMessage("Jogo adicionado com sucesso!");
        return ResponseEntity.ok(successResponse);
    }

}
