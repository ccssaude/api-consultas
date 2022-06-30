package com.api.consultingcontrolhospital.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class hospitalModel implements Serializable {

    private static final long serialVerionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

}
