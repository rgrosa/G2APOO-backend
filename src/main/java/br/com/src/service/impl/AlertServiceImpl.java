package br.com.src.service.impl;

import br.com.src.dto.AlertDTO;
import br.com.src.entity.AlertEntity;
import br.com.src.entity.PropertyEntity;
import br.com.src.repository.AlertInfoRepository;
import br.com.src.repository.AlertRepository;
import br.com.src.resource.ResponseResource;
import br.com.src.service.AlertService;
import br.com.src.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    AlertRepository alertRepository;

    @Autowired
    AlertInfoRepository alertInfoRepository;

    @Autowired
    PropertyService propertyService;

    @Value("${alert.time}")
    private Long dateOffset;

    @Value("${admin.user}")
    private Long adminUser;

    @Override
    public ResponseResource postAlert(AlertDTO alertDTO, Long idFromCurrentUser) {
        AlertEntity alertEntity = new AlertEntity();
        alertEntity.setUserId(idFromCurrentUser);
        alertEntity.setPropertyId(alertDTO.getPropertyId());
        alertEntity.setAlertMessage(alertDTO.getMessage());
        alertEntity.setShowAlert(true);
        alertEntity.setAlertType(alertDTO.getAlertType());
        alertRepository.save(alertEntity);
        return new ResponseResource(200,"Success",null);
    }

    @Override
    public ResponseResource hideAlert(AlertDTO alertDTO) {
        AlertEntity alertEntity = alertRepository.findOneByAlertId(alertDTO.getAlertId());
        alertEntity.setShowAlert(false);
        alertRepository.save(alertEntity);
        return new ResponseResource(200,"Success",null);
    }

    @Override
    public ResponseResource getAlerts(List<Long> alertTypeList) {
        return new ResponseResource(200,"Success",alertInfoRepository.findAllByAlertTypeIdIn(alertTypeList));
    }

    @Override
    public Long createAlertsByTime() {
        Long iterate = 0L;
        Optional<List<PropertyEntity>> optionalPropertyEntityList = propertyService.findPropertyListByUpdateDate(LocalDateTime.now().minusDays(dateOffset));
        if(!optionalPropertyEntityList.isPresent()){
            return iterate;
        }
        List<PropertyEntity> propertyEntityList = optionalPropertyEntityList.get();
        for (PropertyEntity propertyEntity: propertyEntityList) {
            Optional<AlertEntity> alertEntityOptional = alertRepository.findOneByShowAlertAndPropertyIdAndUserId(true, propertyEntity.getPropertyId(), adminUser);
            if(!alertEntityOptional.isPresent()){
                AlertEntity alertEntity = new AlertEntity();
                alertEntity.setPropertyId(propertyEntity.getPropertyId());
                alertEntity.setUserId(adminUser);
                alertEntity.setAlertMessage("Propriedade sem receber uma atualização em seu cadastro a mais de "+dateOffset+" dias, Recomendado atualizar o anuncio!");
                alertEntity.setAlertType(3L);
                alertEntity.setShowAlert(true);
                alertRepository.save(alertEntity);
                iterate++;
            }
        }
        return iterate;
    }
}
