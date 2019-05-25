package com.garudaindonesia.aviamall.model;

import javax.persistence.*;

@Entity
@Table(name = "partner")
public class Partner {

    private long id;
    private String name_partner ;
    private String address_partner;
    private String city_partner;
    private String country;
    private String aggre_no;
    private String aggre_exp_date;
    private String status;

    public Partner() {

    }


    public Partner(long id, String name_partner, String address_partner, String city_partner, String country, String aggre_no, String aggre_exp_date, String status) {
        this.id = id;
        this.name_partner = name_partner;
        this.address_partner = city_partner;
        this.country = country;
        this.aggre_no = aggre_no;
        this.aggre_exp_date = aggre_exp_date;
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

    @Column(name = "name_partner", nullable = false)
    public String getName_partner() {
        return name_partner;
    }

    public void setName_partner(String name_partner) {
        this.name_partner = name_partner;
    }

    @Column(name="address_partner", nullable = false)
    public String getAddress_partner() {
        return address_partner;
    }

    public void setAddress_partner(String address_partner) {
        this.address_partner = address_partner;
    }

    @Column(name="city_partner", nullable = false)
    public String getCity_partner() {
        return city_partner;
    }

    public void setCity_partner(String city_partner) {
        this.city_partner = city_partner;
    }

    @Column(name="country", nullable = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name="aggre_no", nullable = false)
    public String getAggre_no() {
        return aggre_no;
    }

    public void setAggre_no(String aggre_no) {
        this.aggre_no = aggre_no;
    }

    @Column(name="aggre_exp_date", nullable = false)
    public String getAggre_exp_date() {
        return aggre_exp_date;
    }

    public void setAggre_exp_date(String aggre_exp_date) {
        this.aggre_exp_date = aggre_exp_date;
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
        return "m_aircraft_type [id=" + id + ", name_partner=" + name_partner + "address_partner=" + address_partner + ", city_partner=" + city_partner + ", country=" + country + ", aggre_no=" + aggre_no +",aggre_exp_date=" + aggre_exp_date +", status=" + status + " ]";
    }
}