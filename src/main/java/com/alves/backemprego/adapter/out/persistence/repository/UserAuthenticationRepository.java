package com.alves.backemprego.adapter.out.persistence.repository;

import com.alves.backemprego.adapter.out.persistence.entity.UserAuthenticationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserAuthenticationEntity, Long> {

    @Query("""
            SELECT DISTINCT 
                    u FROM UserAuthenticationEntity u
                    WHERE u.email = :email
            """)
    Optional<UserAuthenticationEntity> findByEmail(@Param("email") String email);
}
