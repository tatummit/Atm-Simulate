package com.tum.atmsim.repository.entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "atm_detail")
public class AtmDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name ="num_of_bath_20")
    private int NumOfBath20;

    @Column(name ="num_of_bath_50")
    private int NumOfBath50;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumOfBath20() {
        return NumOfBath20;
    }

    public void setNumOfBath20(int numOfBath20) {
        NumOfBath20 = numOfBath20;
    }

    public int getNumOfBath50() {
        return NumOfBath50;
    }

    public void setNumOfBath50(int numOfBath50) {
        NumOfBath50 = numOfBath50;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
