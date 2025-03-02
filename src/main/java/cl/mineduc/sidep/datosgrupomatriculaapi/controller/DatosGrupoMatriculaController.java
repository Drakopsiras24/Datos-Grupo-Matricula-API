package cl.mineduc.sidep.datosgrupomatriculaapi.controller;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.AsistenteCurso;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.Matricula;
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
@RequestMapping("/api-grupo-parv/v1/curso")
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

    // Ingresar asistentes a un curso
    @PostMapping("/asistente")
    public ResponseEntity<Void> agregarAsistentes(@RequestBody AsistenteCurso asistenteCurso) {
        for (AsistenteCurso.Asistente asistente : asistenteCurso.getAsistentes()) {
            asistenteService.agregarAsistentes(asistente);
        }
        return ResponseEntity.status(201).build(); // Devuelve un status 201 si los asistentes son agregados
    }

    // Actualizar los datos de un curso
    @PutMapping
    public ResponseEntity<Void> actualizarCurso(@RequestBody GrupoModel curso) {
        // Aquí puedes utilizar el rbd como el texto, y buscar el id correspondiente de la base de datos
        Integer id = cursoService.obtenerIdPorRbd(curso.getRbd()); // Método que obtiene el id por rbd

        // Asignamos el id al objeto antes de actualizarlo
        curso.setRbd(id);

        // Ahora actualizamos el curso con el id obtenido
        cursoService.actualizarCurso(curso);
        return ResponseEntity.ok().build(); // Devuelve un status 200 si el curso es actualizado
    }

    // Obtener los datos de un curso por su RBD
    @GetMapping("/{rbd}")
    public ResponseEntity<GrupoModel> obtenerCurso(@PathVariable int rbd) {
        GrupoModel curso = cursoService.obtenerCurso(rbd);
        if (curso == null) {
            return ResponseEntity.status(404).build(); // Devuelve un status 404 si no se encuentra el curso
        }
        return ResponseEntity.ok(curso); // Devuelve los datos del curso si se encuentra
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
