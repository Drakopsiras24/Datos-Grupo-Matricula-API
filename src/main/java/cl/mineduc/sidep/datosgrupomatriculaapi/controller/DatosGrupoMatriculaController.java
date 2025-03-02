package cl.mineduc.sidep.datosgrupomatriculaapi.controller;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.*;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.AsistenteService;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.CursoService;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.GrupoService;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.MatriculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class DatosGrupoMatriculaController {

    private final GrupoService grupoService;

    @PostMapping
    public ResponseEntity<Void> crearCurso(@RequestBody @Valid GrupoCommandModel curso) {
        this.grupoService.crearCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/asistente")
    public ResponseEntity<Void> agregarAsistentes(@RequestBody @Valid AsistenteCommandModel model) {
        this.grupoService.saveAsistentes(model);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> actualizarCurso(@RequestBody GrupoCommandModel model) {
        this.grupoService.update(model);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{rbd}")
    public ResponseEntity<List<GrupoQueryModel>> obtenerCurso(@PathVariable Integer rbd) {
        return ResponseEntity.ok(this.grupoService.findByRbd(rbd));
    }

    @GetMapping("/{rbd}/grado/{grado}/letra/{letra}")
    public ResponseEntity<List<GrupoQueryModel>> obtenerCursoConParametros(
            @PathVariable Integer rbd,
            @PathVariable Long grado,
            @PathVariable String letra) {
        return ResponseEntity.ok(this.grupoService.findByRbdAndGradoAndLetra(rbd, grado, letra));
    }

}
