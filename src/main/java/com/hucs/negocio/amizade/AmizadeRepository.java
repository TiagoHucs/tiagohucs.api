package com.hucs.negocio.amizade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmizadeRepository extends JpaRepository<Amizade, Long> {


    List<Amizade> findAllByPerfilId(Long id);
}
