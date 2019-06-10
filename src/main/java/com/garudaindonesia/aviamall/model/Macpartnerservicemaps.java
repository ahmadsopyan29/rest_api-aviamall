package com.garudaindonesia.aviamall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_ac_partner_service_maps")
public class Macpartnerservicemaps {

    private long id;
    private String m_partner_maps_id;
    private String m_ac_service_details_code;


    public Macpartnerservicemaps() {

    }


    public Macpartnerservicemaps(String m_parner_maps_id, String m_ac_service_details_code) {

        this.m_partner_maps_id = m_parner_maps_id;
        this.m_ac_service_details_code = m_ac_service_details_code;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="m_partner_maps_id", nullable = false)
    public String getM_partner_maps_id() {
        return m_partner_maps_id;
    }

    public void setM_partner_maps_id(String m_partner_maps_id) {
        this.m_partner_maps_id = m_partner_maps_id;
    }

    @Column(name = "m_ac_service_details_code", nullable = false)
    public String getM_ac_service_details_code() {
        return m_ac_service_details_code;
    }

    public void setM_ac_service_details_code(String m_ac_service_details_code) {
        this.m_ac_service_details_code = m_ac_service_details_code;
    }

    @Override
    public String toString() {
        return "Macpartnerservicemaps{" +
                "id=" + id +
                ", m_partner_maps_id='" + m_partner_maps_id + '\'' +
                ", m_ac_service_details_code='" + m_ac_service_details_code + '\'' +
                '}';
    }
}