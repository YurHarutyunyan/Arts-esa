package com.model.amazon;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.repository.CrudRepository;
@EntityScan("com.model.amazon")

public interface ProductRepository extends CrudRepository<Product,Long> {
}
