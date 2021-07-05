package com.mentor.crud.repo;

import com.mentor.crud.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoleRepository extends JpaRepository<Role, Integer> {
}
