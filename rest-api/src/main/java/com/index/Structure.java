package com.index;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


/**
 * Created by jaco1a on 22/12/16.
 */
@Entity
public class Structure implements Serializable{

    @Id
    @Column
    private String smile;

}