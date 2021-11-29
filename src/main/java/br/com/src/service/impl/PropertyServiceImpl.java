package br.com.src.service.impl;

import br.com.src.dto.PropertyDTO;
import br.com.src.entity.AlertEntity;
import br.com.src.entity.PropertyEntity;
import br.com.src.exception.ResourceNotFoundException;
import br.com.src.repository.AlertRepository;
import br.com.src.repository.PropertyRepository;
import br.com.src.resource.ResponseResource;
import br.com.src.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    AlertRepository alertRepository;

    @Override
    public ResponseResource getPropertyList(Long propertyId, List<Long> propertyStatusId,  Double priceMin, Double priceMax) throws ResourceNotFoundException {
        if(propertyId != null){
            Optional<PropertyEntity> optionalProperty = propertyRepository.findOneByPropertyId(propertyId);
            if(!optionalProperty.isPresent()){
                return new ResponseResource(404,"Request failed, no property found for the id= "+propertyId,null);
            }
            return new ResponseResource(200,"Success",optionalProperty.get());
        }
        Optional<List<PropertyEntity>> optionalPropertyList;
        if(priceMin == null && priceMax != null){
            optionalPropertyList = propertyRepository.findAllByPropertyStatusIdInAndPropertyPriceLessThanEqual(propertyStatusId,priceMax);
            if(!optionalPropertyList.isPresent()){
                return new ResponseResource(404,"Request failed, no propertyList found" ,null);
            }
            return new ResponseResource(200,"Success",optionalPropertyList.get());
        }

        if(priceMax == null && priceMin != null ){
            optionalPropertyList = propertyRepository.findAllByPropertyStatusIdInAndPropertyPriceGreaterThanEqual(propertyStatusId,priceMin);
            if(!optionalPropertyList.isPresent()){
                return new ResponseResource(404,"Request failed, no propertyList found" ,null);
            }
            return new ResponseResource(200,"Success",optionalPropertyList.get());
        }

        if(priceMin != null && priceMax != null){
            optionalPropertyList = propertyRepository.findAllByPropertyStatusIdInAndPropertyPriceGreaterThanEqualAndPropertyPriceLessThanEqual(propertyStatusId, priceMin, priceMax);
            if(!optionalPropertyList.isPresent()){
                return new ResponseResource(404,"Request failed, no propertyList found" ,null);
            }
            return new ResponseResource(200,"Success",optionalPropertyList.get());
        }

        optionalPropertyList = propertyRepository.findAllByPropertyStatusIdIn(propertyStatusId);
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
                propertyEntity.setLastPropertyPrice(propertyEntity.getPropertyPrice());
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

        Optional<AlertEntity> alertEntityOptional = alertRepository.findOneByPropertyIdAndAlertTypeAndShowAlert(propertyEntity.getPropertyId(),3L ,true);
        if(alertEntityOptional.isPresent()){
            AlertEntity alertEntity = alertEntityOptional.get();
            alertEntity.setShowAlert(false);
            alertRepository.save(alertEntity);
        }


        return new ResponseResource(200,"Success",propertyDTO);
    }

    @Override
    public Optional<List<PropertyEntity>> findPropertyListByUpdateDate(LocalDateTime minusDays) {
        return propertyRepository.findAllByUpdatedAtLessThanEqual(minusDays);
    }


}
