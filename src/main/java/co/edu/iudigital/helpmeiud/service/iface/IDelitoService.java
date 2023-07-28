package co.edu.iudigital.helpmeiud.service.iface;

import co.edu.iudigital.helpmeiud.dto.request.DelitoDTORequest;
import co.edu.iudigital.helpmeiud.dto.response.DelitoDTO;
import co.edu.iudigital.helpmeiud.exceptions.BadRequestException;
import co.edu.iudigital.helpmeiud.exceptions.RestException;

import java.util.List;

public interface IDelitoService {

    /**
     * Consulta todos los Delitos
     * @return
     */
    List<DelitoDTO> consultarTodos(); //TODO: throw exception

    /**
     * Consultar Delito por su ID
     * @param id
     * @return
     */
    DelitoDTO consultarPorId(Long id);

    /**
     * Guardar un Delito
     * @param delitoDTORequest
     * @return
     */
    DelitoDTO guardarDelito(DelitoDTORequest delitoDTORequest) throws RestException;

    /**
     * Borra un Delito por su ID
     * @param id
     */
    void borrarDelitoPorId(Long id);
}
