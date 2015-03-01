package com.example.shivam.whatshere;


public class SampleData {

    private String name;

    public Integer imgid;

    public SampleData(Integer imgid,String name) {
        super();
        this.imgid=imgid;
        this.name = name;
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
}