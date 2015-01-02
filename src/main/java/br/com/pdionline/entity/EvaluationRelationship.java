package br.com.pdionline.entity;

import javax.persistence.*;

/**
 * Created by gui on 31/12/14.
 */
@Entity
public class EvaluationRelationship {
    
    @Id
    private Long id;

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "avaliador_id")
    private User avalia;
    
    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "avaliado_id")
    private User avaliadoPor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAvalia() {
        return avalia;
    }

    public void setAvalia(User avalia) {
        this.avalia = avalia;
    }

    public User getAvaliadoPor() {
        return avaliadoPor;
    }

    public void setAvaliadoPor(User avaliadoPor) {
        this.avaliadoPor = avaliadoPor;
    }
}
