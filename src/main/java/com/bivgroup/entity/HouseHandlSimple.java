package com.bivgroup.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "HOUSEHANDL")
public class HouseHandlSimple extends PanacheEntityBase {

    @Id
    @Column(name = "HOUSEHANDLID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "TEST_HOUSEHANDLID_SEQ")
    @SequenceGenerator(name = "TEST_HOUSEHANDLID_SEQ", sequenceName = "TEST_HOUSEHANDLID_SEQ", allocationSize = 10)
    public Long houseHadnlId;

}
