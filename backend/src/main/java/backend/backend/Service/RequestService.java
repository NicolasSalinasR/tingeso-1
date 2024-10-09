package backend.backend.Service;

import backend.backend.Entity.RequestEntity;
import backend.backend.Repository.RequestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class RequestService {
    @Autowired
    private RequestRepository requestRepository;


    public RequestEntity createRequest(String typeOfRequest, int stage, long clientId, byte[] pdfDocument) {
        RequestEntity request = new RequestEntity();
        request.setTypeOfRequest(typeOfRequest);
        request.setStage(stage);
        request.setClientId(clientId);
        request.setPdfDocument(pdfDocument);

        return requestRepository.save(request);
    }

    public void updateStage(long requestId, int newStage) {
        // Buscar la solicitud por ID
        Optional<RequestEntity> requestOptional = requestRepository.findById(requestId);

        if (requestOptional.isPresent()) {
            RequestEntity request = requestOptional.get();
            // Actualizar el Stage
            request.setStage(newStage);
            // Guardar los cambios en la base de datos
            requestRepository.save(request);
        } else {
            // Manejar el caso donde la solicitud no se encuentra
            throw new EntityNotFoundException("Request with ID " + requestId + " not found.");
        }
    }

    // Método para obtener la entidad por su ID
    public RequestEntity getRequestById(long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Request with ID " + id + " not found."));
    }


//    public List<RequestEntity> getAllByClientId(long ClientId) {
//        List<RequestEntity> ReturnList = requestRepository.findAllByClientId(ClientId);
//        return ReturnList;
//    }





}
