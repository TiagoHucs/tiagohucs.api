package com.hucs.negocio.amizade;


import com.hucs.negocio.perfil.Perfil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Amizade {

    @EmbeddedId
    private AmiPK id;

    @ManyToOne
    @JoinColumn(name = "PER_ID",insertable=false, updatable=false,nullable=false)
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "AMI_AMIGO_ID",insertable=false, updatable=false,nullable=false)
    private Perfil amigo;

    @Column(name = "AMI_DH_SOLICITACAO")
    private LocalDateTime dataHoraSolicitacao;

    @Column(name = "AMI_DH_APROVACAO")
    private LocalDateTime dataHoraAprovacao;

    @Column(name = "AMI_IB_APROVACAO")
    private boolean aprovado;

    public void setPerfil(Perfil perfil){
        this.perfil = perfil;
        this.getId().setPerfilId(perfil.getId());
    }

    public void setAmigo(Perfil amigo){
        this.amigo = amigo;
        this.getId().setAmigoId(amigo.getId());
    }

    public AmiPK getId() {
        if(id == null){
            this.id = new AmiPK();
        }
        return id;
    }

    @PrePersist
    private void prePersiste(){
        setDataHoraSolicitacao(LocalDateTime.now());
    }
}
