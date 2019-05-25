package com.garudaindonesia.aviamall.model;

import javax.persistence.*;

@Entity
@Table(name = "type_aircraft")
public class MAircraftType extends Partner {

    private long id;
    private String code;
    private String description;
    private String type;
    private String remarks;

    public MAircraftType() {

    }


    public MAircraftType(long id, String code, String description, String type, String remarks) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.type = type;
        this.remarks = remarks;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name="remarks", nullable = false)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "m_aircraft_type [id=" + id + ", code=" + code + ", description=" + description + ", type=" + type + ", remarks=" + remarks + " ]";
    }
}