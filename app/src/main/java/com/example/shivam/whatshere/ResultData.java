package com.example.shivam.whatshere;


public class ResultData {

    private String name;
    private String distance;
    private String address;
    public Integer imgid;

    public ResultData(String name,String distance,String address,Integer imgid) {
        super();
        this.imgid=imgid;
        this.name = name;
        this.distance=distance;
        this.address=address;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}