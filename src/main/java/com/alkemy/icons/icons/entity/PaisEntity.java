package com.alkemy.icons.icons.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pais")
@Getter
@Setter
@EqualsAndHashCode
@SQLDelete(sql = "UPDATE pais SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class PaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String denominacion;
    @Column(name = "cant_habitantes")

    private Long cantidadHabitantes;

    private Long superficie;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)
    private ContinenteEntity continente;

    @Column(name = "continente_id", nullable = false)
    private Long continenteId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE

            })
    @JoinTable(
            name = "icon_pais",
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id"))
    private Set<IconEntity> icons = new HashSet<>();

    private boolean deleted = Boolean.FALSE;

    public void addIcon(IconEntity icon){
        this.icons.add(icon);
    }
    public void removeIcon(IconEntity icon){
        this.icons.remove(icon);
    }


}
