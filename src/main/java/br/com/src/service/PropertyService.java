package br.com.src.service;

import br.com.src.dto.PropertyDTO;
import br.com.src.exception.ResourceNotFoundException;
import br.com.src.resource.ResponseResource;

import java.util.List;

public interface PropertyService {

    ResponseResource getPropertyList(Long propertyId, List<Long> propertyStatusId, Double priceMin, Double priceMax) throws ResourceNotFoundException;

    ResponseResource saveProperty(PropertyDTO propertyDTO, Long userId) throws ResourceNotFoundException;
}
