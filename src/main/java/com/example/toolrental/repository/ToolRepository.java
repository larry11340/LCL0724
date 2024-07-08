package com.example.toolrental.repository;

import com.example.toolrental.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToolRepository extends JpaRepository<Tool, String> {
    @Query("select t from Tool t where t.code =:code")
    Optional<Tool> getToolByCode(@Param("code") String code);

}
