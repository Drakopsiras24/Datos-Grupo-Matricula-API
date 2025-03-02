package cl.mineduc.sidep.datosgrupomatriculaapi.controller;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaUnidadEducativaCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaUnidadEducativaQueryModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.MatriculaUnidadEducativaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matricula-unidad-educativa")
@RequiredArgsConstructor
public class MatriculaUnidadEducativaController {

    private final MatriculaUnidadEducativaService  matriculaUnidadEducativaService;

    @PostMapping("")
    ResponseEntity<Void> save(@RequestBody @Valid MatriculaUnidadEducativaCommandModel model) {
        this.matriculaUnidadEducativaService.save(model);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/rbd/{rbd}")
    ResponseEntity<List<MatriculaUnidadEducativaQueryModel>> findAll(
            @PathVariable("rbd") Integer rbd,
            @RequestParam(name = "run", required = false) Integer run) {
        return ResponseEntity.ok(this.matriculaUnidadEducativaService.findAll(rbd, run));
    }

}
