package com.krawart.hexademo.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface HexaDemoJpaRepository<T> extends JpaRepository<T, UUID> {}
