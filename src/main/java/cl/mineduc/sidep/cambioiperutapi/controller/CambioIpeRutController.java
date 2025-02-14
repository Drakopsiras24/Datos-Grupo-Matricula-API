package cl.mineduc.sidep.cambioiperutapi.controller;

import cl.mineduc.sidep.cambioiperutapi.model.CambioIpeRutModel;
import cl.mineduc.sidep.cambioiperutapi.services.CambioIpeRutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cambio-ipe-rut")
@RequiredArgsConstructor
public class CambioIpeRutController {

    private final CambioIpeRutService cambioIpeRutService;

    @PostMapping
    public ResponseEntity<Void> actualizarIpePorRut(@RequestBody CambioIpeRutModel model) {
        cambioIpeRutService.actualizarIpePorRut(model);
        return ResponseEntity.ok().build();
    }
}
