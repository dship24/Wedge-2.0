package com.example.ShipatonRemastered.Items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {


    @Query("SELECT * FROM Items WHERE category = ?1")
    ResultSet findCategory(String category);

    @Query("SELECT * FROM Items WHERE id = ?1")
    ResultSet findId(Integer id);
}
