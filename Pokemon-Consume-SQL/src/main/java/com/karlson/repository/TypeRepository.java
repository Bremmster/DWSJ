package com.karlson.repository;

import com.karlson.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Is this class really needed?
@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}
