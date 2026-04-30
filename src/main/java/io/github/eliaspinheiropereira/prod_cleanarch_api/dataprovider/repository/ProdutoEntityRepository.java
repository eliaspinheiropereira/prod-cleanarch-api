package io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider.repository;

import io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider.repository.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoEntityRepository extends JpaRepository<ProdutoEntity, Integer> {
}
