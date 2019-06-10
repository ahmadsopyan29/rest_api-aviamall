package com.garudaindonesia.aviamall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_ac_service_details")
public class Macservicedetails {

    private long id;
    private String m_ac_service_header_code;
    private String code;
    private String title;
    private String description;
    private String status;

    public Macservicedetails() {

    }


    public Macservicedetails(String m_ac_service_header_code, String code, String title, String description, String status) {

        this.m_ac_service_header_code = m_ac_service_header_code;
        this.code = code;
        this.title = title;
        this.description = description;
        this.status = status;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="m_ac_service_header_code", nullable = false)
    public String getM_ac_service_header_code() {
        return m_ac_service_header_code;
    }

    public void setM_ac_service_header_code(String m_ac_service_header_code) {
        this.m_ac_service_header_code = m_ac_service_header_code;
    }
    @Column(name="code", nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name="title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Macservicedetails{" +
                "id=" + id +
                ", m_ac_service_header_code='" + m_ac_service_header_code + '\'' +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}