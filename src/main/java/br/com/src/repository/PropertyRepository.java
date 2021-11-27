package br.com.src.repository;

import br.com.src.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {

    Optional<List<PropertyEntity>> findAllByPropertyStatusIdIn(List<Long> propertyStatusId);

    Optional<List<PropertyEntity>> findAllByPropertyStatusIdInAndPropertyPriceGreaterThanEqual(List<Long> propertyStatusId, Double priceMin);

    Optional<List<PropertyEntity>> findAllByPropertyStatusIdInAndPropertyPriceLessThanEqual(List<Long> propertyStatusId, Double priceMax);

    Optional<List<PropertyEntity>> findAllByPropertyStatusIdInAndPropertyPriceGreaterThanEqualAndPropertyPriceLessThanEqual(List<Long> propertyStatusId, Double priceMin, Double priceMax);

    Optional<PropertyEntity> findOneByPropertyId(Long propertyId);


}
