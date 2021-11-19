package br.com.src.repository;

import br.com.src.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {

    Optional<List<PropertyEntity>> findAllByPropertyStatusIdIn(List<Long> propertyStatusId);

    Optional<PropertyEntity> findOneByPropertyId(Long propertyId);
}
