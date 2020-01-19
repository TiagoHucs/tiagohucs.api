package com.hucs.negocio.publicacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {

    List<Publicacao> findAllByOrderByDataDesc();
}
