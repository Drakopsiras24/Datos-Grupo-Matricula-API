package cl.mineduc.sidep.datosgrupomatriculaapi.controller;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.GradoCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GradoQueryModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.GradoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/grado")
@RequiredArgsConstructor
public class GradoController {

    private final GradoService gradoService;

    @PostMapping("")
    public ResponseEntity<Void> save(@RequestBody @Valid GradoCommandModel m) {
        this.gradoService.save(m);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<GradoQueryModel>> findAll(
            @RequestParam(value = "rbd", required = false) Integer rbd,
            @RequestParam(value = "tipo", required = false) Long tipo) {
        return ResponseEntity.ok(this.gradoService.findAll(rbd, tipo));
    }

}
