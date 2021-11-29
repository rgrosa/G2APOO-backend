package br.com.src.service;

import br.com.src.dto.AlertDTO;
import br.com.src.resource.ResponseResource;

import java.util.List;

public interface AlertService {
    ResponseResource postAlert(AlertDTO alertDTO, Long idFromCurrentUser);

    ResponseResource hideAlert(AlertDTO alertDTO);

    ResponseResource getAlerts(List<Long> alertTypeList);

    Long createAlertsByTime();
}
