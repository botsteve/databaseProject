package com.databaseProject.databaseProject.Repositories;

import com.databaseProject.databaseProject.Model.GPS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GPSRepository extends JpaRepository<GPS, Integer> {
}
