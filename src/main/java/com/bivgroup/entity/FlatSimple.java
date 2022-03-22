package com.bivgroup.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Sort;

import javax.persistence.*;

@Entity
@Table(name = "FLAT")
public class FlatSimple extends PanacheEntityBase {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "TEST_FLAT_SEQ")
    @SequenceGenerator(name = "TEST_FLAT_SEQ", sequenceName = "TEST_FLAT_SEQ", allocationSize = 10)
    public Long id;

}
