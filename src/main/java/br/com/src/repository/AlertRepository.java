package br.com.src.repository;

import br.com.src.entity.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlertRepository extends JpaRepository<AlertEntity, Long> {

    AlertEntity findOneByAlertId(Long alertId);

    Optional<AlertEntity> findOneByShowAlertAndPropertyIdAndUserId(Boolean showAlert , Long propertyId, Long userId);

    Optional<AlertEntity> findOneByPropertyIdAndAlertTypeAndShowAlert(Long propertyId, Long alertType, Boolean showAlert);
}
