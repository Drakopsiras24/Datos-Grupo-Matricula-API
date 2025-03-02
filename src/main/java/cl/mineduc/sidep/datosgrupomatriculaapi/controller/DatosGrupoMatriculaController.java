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

    private final CursoService cursoService;
    private final AsistenteService asistenteService;
    private final MatriculaService matriculaService;
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

    // Obtener los datos de un curso usando múltiples parámetros
    @GetMapping("/{rbd}/ensenanza/{ensenanza}/grado/{grado}/letra/{letra}")
    public ResponseEntity<GrupoModel> obtenerCursoConParametros(
            @PathVariable Integer rbd,
            @PathVariable Integer grado,
            @PathVariable String letra) {

        // Llama al servicio que gestiona la lógica de negocio para obtener los datos del curso
        GrupoModel curso = cursoService.obtenerCursoConParametros(rbd, grado, letra);

        if (curso == null) {
            return ResponseEntity.status(404).build(); // Devuelve 404 si no se encuentra el curso
        }
        return ResponseEntity.ok(curso); // Devuelve los datos del curso si se encuentra
    }

    // Eliminar un curso
    @Deprecated
    @DeleteMapping("/{rbd}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable int rbd) {
        boolean eliminado = cursoService.eliminarCurso(rbd);
        if (eliminado) {
            return ResponseEntity.ok().build(); // Devuelve un status 200 si el curso es eliminado
        }
        return ResponseEntity.status(404).build(); // Devuelve un status 404 si no se encuentra el curso
    }

    // Eliminar un asistente de un curso
    @DeleteMapping("/asistente")
    @Deprecated
    public ResponseEntity<Void> eliminarAsistente(@RequestBody AsistenteCurso.Asistente asistente) {
        Integer rutAsistente = asistente.getRut(); // Obtén el rut del asistente
        asistenteService.eliminarAsistente(rutAsistente);
        return ResponseEntity.status(200).build(); // Devuelve un status 200 si el asistente es eliminado
    }

    // Ingresar matrícula del alumno
    @PostMapping("/matricula")
    public ResponseEntity<Void> ingresarMatricula(@RequestBody Matricula matricula) {
        matriculaService.ingresarMatricula(matricula);
        return ResponseEntity.status(201).build(); // Devuelve un status 201 si la matrícula es creada
    }

    // Actualizar matrícula del alumno
    @PutMapping("/matricula")
    public ResponseEntity<Void> actualizarMatricula(@RequestBody Matricula matricula) {
        matriculaService.actualizarMatricula(matricula);
        return ResponseEntity.ok().build(); // Devuelve un status 200 si la matrícula es actualizada
    }

    // Obtener las matriculas por RBD y rut
    @GetMapping("/matricula/{rbd}/rut/{rut}")
    public ResponseEntity<List<Matricula>> obtenerMatricula(@PathVariable int rbd, @PathVariable int rut) {
        List<Matricula> matriculas = matriculaService.obtenerMatriculasPorRbdYRut(rbd, rut); // Debe ser una lista
        if (matriculas.isEmpty()) {
            return ResponseEntity.status(404).build(); // Devuelve un status 404 si no se encuentran matrículas
        }
        return ResponseEntity.ok(matriculas); // Devuelve la lista de matrículas
    }

    @Deprecated
    // Eliminar matrícula del alumno
    @DeleteMapping("/matricula")
    public ResponseEntity<Void> eliminarMatricula(@RequestParam int rbd, @RequestParam int rut) {
        matriculaService.eliminarMatricula(rbd, rut);
        return ResponseEntity.status(200).build(); // Devuelve un status 200 si la matrícula es eliminada
    }
}
