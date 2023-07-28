package co.edu.iudigital.helpmeiud.service.impl;

import co.edu.iudigital.helpmeiud.dto.request.DelitoDTORequest;
import co.edu.iudigital.helpmeiud.dto.response.DelitoDTO;
import co.edu.iudigital.helpmeiud.exceptions.BadRequestException;
import co.edu.iudigital.helpmeiud.exceptions.ErrorDto;
import co.edu.iudigital.helpmeiud.exceptions.RestException;
import co.edu.iudigital.helpmeiud.model.Delito;
import co.edu.iudigital.helpmeiud.model.Usuario;
import co.edu.iudigital.helpmeiud.repository.IDelitoRepository;
import co.edu.iudigital.helpmeiud.repository.IUsuarioRepository;
import co.edu.iudigital.helpmeiud.service.iface.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DelitoServiceImpl implements IDelitoService {
    private IDelitoRepository delitoRepository;
    private IUsuarioRepository usuarioRepository;

    @Autowired // Inyección de Dependencias por constructor
    public DelitoServiceImpl(IDelitoRepository delitoRepository,
                             IUsuarioRepository usuarioRepository){
        this.delitoRepository = delitoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DelitoDTO> consultarTodos() {
        List<Delito> delitos = delitoRepository.findAll();
        return delitos.stream()
                .map(delito ->
                    DelitoDTO.builder()
                            .id(delito.getId())
                            .nombre(delito.getNombre())
                            .descripcion(delito.getDescripcion())
                            .build()
                ).collect(Collectors.toList());
    }

    @Override
    public DelitoDTO consultarPorId(Long id) {
        return null;
    }

    @Transactional
    @Override
    public DelitoDTO guardarDelito(DelitoDTORequest delitoDTORequest) throws RestException {
        Delito delito = new Delito();
        delito.setNombre(delitoDTORequest.getNombre());
        delito.setDescripcion(delitoDTORequest.getDescripcion());
        Optional<Usuario> usuarioOptional = usuarioRepository
                .findById(delitoDTORequest.getUsuarioId());
        if(!usuarioOptional.isPresent()){
            throw new BadRequestException(
                    ErrorDto.builder()
                            .status(HttpStatus.BAD_REQUEST.value())
                            .message("No existe usuario")
                            .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                            .date(LocalDateTime.now())
                            .build()
            );
        }
        delito.setUsuario(usuarioOptional.get());
        delito = delitoRepository.save(delito);
        return DelitoDTO.builder()
                .id(delito.getId())
                .nombre(delito.getNombre())
                .descripcion(delito.getDescripcion())
                .build();
    }

    @Override
    public void borrarDelitoPorId(Long id) {

    }
}
