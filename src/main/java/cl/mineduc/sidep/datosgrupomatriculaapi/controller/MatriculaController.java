package cl.mineduc.sidep.datosgrupomatriculaapi.controller;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaQueryModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.MatriculaGrupoService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matricula")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaGrupoService matriculaGrupoService;

    @PostMapping("")
    public ResponseEntity<Void> save(@RequestBody @Valid MatriculaCommandModel model) {
        this.matriculaGrupoService.save(model);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/rbd/{rbd}/rut/{rut}")
    public ResponseEntity<List<MatriculaQueryModel>> findAll(
            @PathVariable("rbd") Integer rbd,
            @PathVariable("rut") Integer rut) {
        return ResponseEntity.ok(this.matriculaGrupoService.findAll(rbd, rut));
    }

}
