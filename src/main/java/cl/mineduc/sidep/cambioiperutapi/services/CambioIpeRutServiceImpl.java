package cl.mineduc.sidep.cambioiperutapi.services;

import cl.mineduc.sidep.cambioiperutapi.mappers.PersonaMapper;
import cl.mineduc.sidep.cambioiperutapi.model.CambioIpeRutModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CambioIpeRutServiceImpl implements CambioIpeRutService {

    private final PersonaMapper personaMapper;

    @Transactional
    @Override
    public void actualizarIpePorRut(CambioIpeRutModel model) {
        personaMapper.updateIpeToRut(model.getIpe(), model.getRut(), model.getDv());
    }
}
