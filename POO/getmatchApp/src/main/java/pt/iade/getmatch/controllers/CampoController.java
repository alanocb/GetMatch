package pt.iade.getmatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iade.getmatch.Repository.CampoRepository;
import pt.iade.getmatch.dto.ErrorResponse;
import pt.iade.getmatch.dto.SuccessResponse;
import pt.iade.getmatch.dto.request.CampoRequest;
import pt.iade.getmatch.models.Campo;

import java.util.List;

@RestController
@RequestMapping(path = "/api/campo")
public class CampoController {

    @Autowired
    private CampoRepository campoRepository;

    @GetMapping
    public List<Campo> getCampos() {
        return campoRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCampoById(@PathVariable int id) {
        var campo = this.campoRepository.findById(id);

        if (!campo.isPresent()) {
            var errorResponse = new ErrorResponse();
            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
            errorResponse.setMessage("Campo não encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        return ResponseEntity.ok(campo.get());
    }

    @PostMapping
    public ResponseEntity<?> saveCampo(@RequestBody CampoRequest campoRequest) {
        var campoTelefoneExist = this.campoRepository.findByTelefone(campoRequest.getTelefone());

        if (campoTelefoneExist.isPresent()) {
            var errorResponse = new ErrorResponse();
            errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            errorResponse.setMessage("Campo com numero: " + campoRequest.getTelefone() + " existente");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        if (campoRequest.getTelefone() >= 10e8 || campoRequest.getTelefone() <= 9e8) {
            var errorResponse = new ErrorResponse();
            errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            errorResponse.setMessage("Numero de telefone invalido");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        var campo = new Campo();
        campo.setName(campoRequest.getNome());
        campo.setLocalizacao(campoRequest.getLocalizacao());
        campo.setEndereco(campoRequest.getEndereco());
        campo.setTelefone(campoRequest.getTelefone());
        campo.setTipoCampo(campoRequest.getTipoCampo());
        campo.setLongitude(campoRequest.getLongitude());
        campo.setLatitude(campoRequest.getLatitude());

        this.campoRepository.save(campo);

        var successResponse = new SuccessResponse();
        successResponse.setStatus(HttpStatus.OK.value());
        successResponse.setMessage("Campo adicionado com sucesso!");
        return ResponseEntity.ok(successResponse);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteCampo(@PathVariable("id") int id) {
        var campo = this.campoRepository.findById(id);

        if (!campo.isPresent()) {
            var errorResponse = new ErrorResponse();
            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
            errorResponse.setMessage("Campo não encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        this.campoRepository.deleteById(id);

        var successResponse = new SuccessResponse();
        successResponse.setStatus(HttpStatus.OK.value());
        successResponse.setMessage("Campo eliminado com sucesso!");
        return ResponseEntity.ok(successResponse);
    }


}
