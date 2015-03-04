package com.example.shivam.whatshere;


public class ResultData {

    private String name;
    private String distance;
    private String address;
    public Integer imgid;
    public Double lat;
    public Double lng;

    public ResultData(String name,String distance,String address,Integer imgid,Double lat,Double lng) {
        super();
        this.imgid=imgid;
        this.name = name;
        this.distance=distance;
        this.address=address;
        this.lat=lat;
        this.lng=lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return imgid;
    }

    public void setId(Integer id) {
        this.imgid = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return distance;
    }

    public void setPhone(String distance) {
        this.distance = distance;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lng) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }


}