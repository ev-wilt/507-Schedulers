package com.company;

import java.util.List;

public class Record {
    private float eqSiteLimit;
    private float huSiteLimit;
    private float flSiteLimit;
    private float pointLatitude;
    private float pointLongitude;
    private String line;
    private String construction;

    public Record(List<String> recordArray) {
        this.eqSiteLimit = Float.parseFloat(recordArray.get(3));
        this.huSiteLimit = Float.parseFloat(recordArray.get(4));
        this.flSiteLimit = Float.parseFloat(recordArray.get(5));
        this.pointLatitude = Float.parseFloat(recordArray.get(13));
        this.pointLongitude = Float.parseFloat(recordArray.get(14));
        this.line = recordArray.get(15);
        this.construction = recordArray.get(16);
    }

    public float getEqSiteLimit() {
        return eqSiteLimit;
    }

    public float getHuSiteLimit() {
        return huSiteLimit;
    }

    public float getFlSiteLimit() {
        return flSiteLimit;
    }

    public float getPointLatitude() {
        return pointLatitude;
    }

    public float getPointLongitude() {
        return pointLongitude;
    }

    public String getLine() {
        return line;
    }

    public String getConstruction() {
        return construction;
    }
}
