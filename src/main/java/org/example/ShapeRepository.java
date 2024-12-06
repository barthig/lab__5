package org.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShapeRepository<T extends Shape> extends JpaRepository<T, Long> {

}