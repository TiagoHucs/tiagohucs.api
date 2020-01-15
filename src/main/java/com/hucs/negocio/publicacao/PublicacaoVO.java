package com.hucs.negocio.publicacao;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PublicacaoVO {

    private Long id;
    private LocalDateTime data;
    private String texto;
}
