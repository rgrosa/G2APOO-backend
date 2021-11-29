package br.com.src.repository;

import br.com.src.entity.AlertInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertInfoRepository extends JpaRepository<AlertInfoEntity, Long> {

    List<AlertInfoEntity> findAllByAlertTypeIdIn(List<Long> statusList);
}
