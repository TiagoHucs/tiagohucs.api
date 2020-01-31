package com.hucs.negocio.amizade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class AmiPK implements Serializable {

    public AmiPK() {
    }

    public AmiPK(Long perfilId, Long amigoId) {
        this.perfilId = perfilId;
        this.amigoId = amigoId;
    }

    @Column(name = "PER_ID",nullable=false)
    private Long perfilId;

    @Column(name = "AMI_AMIGO_ID",nullable=false)
    private Long amigoId;


}
