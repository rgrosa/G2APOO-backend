package br.com.src.component;

import br.com.src.service.AlertService;
import br.com.src.service.impl.LoginServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GenerateAlertsComponent {
    private static final Logger log = LoggerFactory.getLogger(GenerateAlertsComponent.class);
    @Autowired
    AlertService alertService;

    @Scheduled(cron = "${alert.cron}")
    public void verifyAlerts(){
        log.info("verifyAlerts - Search for old property");
        alertService.createAlertsByTime();

    }
}
