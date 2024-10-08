package com.alves.backemprego.adapter.out.persistence.repository;

import com.alves.backemprego.adapter.out.persistence.entity.CategoryEntity;
import com.alves.backemprego.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("""
            SELECT DISTINCT u FROM UserEntity u
                         LEFT JOIN FETCH u.resume r
                         LEFT JOIN FETCH r.professionalExperiences
                         LEFT JOIN FETCH r.educations
                         LEFT JOIN FETCH u.categories
                         WHERE u.email = :email
            """)
    Optional<UserEntity> loadByEmail(@Param("email") String email);


    @Query("""
            SELECT DISTINCT u FROM UserEntity u
                         LEFT JOIN FETCH u.resume r
                         LEFT JOIN FETCH r.professionalExperiences
                         LEFT JOIN FETCH r.educations
                         LEFT JOIN FETCH u.categories c
                         WHERE u.show = true AND u.display = true AND c = :category
                          ORDER BY u.createdAt DESC
            """)
    Page<UserEntity> findByCategory(@Param("category") CategoryEntity category, Pageable pageable);

    @Query("""
            SELECT DISTINCT u FROM UserEntity u
                        LEFT JOIN FETCH u.resume r
                        LEFT JOIN FETCH r.professionalExperiences
                        LEFT JOIN FETCH r.educations
                        LEFT JOIN FETCH u.categories
                        WHERE u.show = true AND u.display = true
                        ORDER BY u.createdAt DESC
            """)
    Page<UserEntity> findAllByShowIsTrueAndDisplayIsTrue(Pageable pageable);

    @Query("""
            SELECT DISTINCT u FROM UserEntity u
                        WHERE u.email = :email
            """)
    Optional<UserEntity> findByEmail(@Param("email") String email);
}
