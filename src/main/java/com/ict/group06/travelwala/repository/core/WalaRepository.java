package com.ict.group06.travelwala.repository.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface WalaRepository<T, ID> extends WalaCrudRepository<T, ID> {
    Page<T> findAll(Pageable pageable);
}
