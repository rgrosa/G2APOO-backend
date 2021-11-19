package br.com.src.service.impl;

import br.com.src.dto.PropertyDTO;
import br.com.src.entity.PropertyEntity;
import br.com.src.exception.ResourceNotFoundException;
import br.com.src.repository.PropertyRepository;
import br.com.src.resource.ResponseResource;
import br.com.src.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Override
    public ResponseResource getPropertyList(Long propertyId, List<Long> propertyStatusId) throws ResourceNotFoundException {
        Optional<List<PropertyEntity>> optionalPropertyList = propertyRepository.findAllByPropertyStatusIdIn(propertyStatusId);
        if(!optionalPropertyList.isPresent()){
            return new ResponseResource(404,"Request failed, no propertyList found for the propertyStatusId= "+propertyStatusId,null);
        }
        return new ResponseResource(200,"Success",optionalPropertyList.get());
    }

    @Override
    public ResponseResource saveProperty(PropertyDTO propertyDTO, Long userId) throws ResourceNotFoundException {
        PropertyEntity propertyEntity = new PropertyEntity();
        if(propertyDTO.getPropertyId() != null) {
            Optional<PropertyEntity> optionalProperty = propertyRepository.findOneByPropertyId(propertyDTO.getPropertyId());
            if (optionalProperty.isPresent()) {
                propertyEntity = optionalProperty.get();
            }
        }
        propertyEntity.setPropertyAddress(propertyDTO.getPropertyAddress());
        propertyEntity.setPropertyPrice(propertyDTO.getPropertyPrice());
        propertyEntity.setUserId(propertyDTO.getUserId());
        propertyEntity.setPropertyStatusId(propertyDTO.getPropertyStatusId());
        propertyEntity.setPropertyOwnerName(propertyDTO.getPropertyOwnerName());
        propertyEntity.setPropertyOwnerEmail(propertyDTO.getPropertyOwnerEmail());
        propertyEntity.setPropertyOwnerTel(propertyDTO.getPropertyOwnerTel());
        propertyEntity.setFinanced(propertyDTO.getFinanced());
        propertyEntity.setOwnerNamed(propertyDTO.getOwnerNamed());
        propertyEntity.setNegotiable(propertyDTO.getNegotiable());
        propertyEntity.setPicture1x64(propertyDTO.getPicture1x64());
        propertyEntity.setPicture2x64(propertyDTO.getPicture2x64());
        propertyEntity.setPicture3x64(propertyDTO.getPicture3x64());
        propertyEntity.setPicture4x64(propertyDTO.getPicture4x64());
        propertyEntity.setPicture5x64(propertyDTO.getPicture5x64());
        propertyEntity.setUserEditedId(userId.intValue());
        propertyRepository.save(propertyEntity);

        return new ResponseResource(200,"Success",propertyDTO);
    }


}
