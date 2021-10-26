package com.tedredington.apartment-finder.model;

import com.mongodb.lang.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.net.URL;
import java.util.Date;

@Document(collection = "craigslist")
public class CraigslistHousing {
    @Id
    private String id;
    @Field(name = "craigslist_id")
    @Indexed(unique = true)
    private String craigslistId;
    private String name;
    private URL url;
    private Date date;
    private String where;
    private double price;
    @Field(name = "is_active")
    private boolean isActive = true;
    @Field(name = "has_image")
    private Boolean hasImage;
    @Field(name = "has_map")
    private Boolean hasMap;
    private int bedrooms;
    @Nullable
    private GeoJsonPoint location;

    public void setId(String id) {
        this.id = id;
    }

    public void setCraigslistId(String craigslistId) {
        this.craigslistId = craigslistId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setHasImage(Boolean hasImage) {
        this.hasImage = hasImage;
    }

    public void setHasMap(Boolean hasMap) {
        this.hasMap = hasMap;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setLocation(@Nullable GeoJsonPoint location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CraigslistHousing{" +
                "id='" + id + '\'' +
                ", craigslistId='" + craigslistId + '\'' +
                ", name='" + name + '\'' +
                ", url=" + url +
                ", date=" + date +
                ", where='" + where + '\'' +
                ", price=" + price +
                ", isActive=" + isActive +
                ", hasImage=" + hasImage +
                ", hasMap=" + hasMap +
                ", bedrooms=" + bedrooms +
                '}';
    }

}
