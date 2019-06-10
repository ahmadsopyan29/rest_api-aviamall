package com.garudaindonesia.aviamall.model;

import javax.persistence.*;

@Entity
@Table(name = "m_ac_service_headers")
public class Macserviceheaders {

    private long id;
    private String code;
    private String description;

    public Macserviceheaders() {

    }


    public Macserviceheaders(String code, String description) {

        this.code = code;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name="code", nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Macserviceheaders{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}