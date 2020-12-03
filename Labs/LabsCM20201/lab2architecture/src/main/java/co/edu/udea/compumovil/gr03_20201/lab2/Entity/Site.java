package co.edu.udea.compumovil.gr03_20201.lab2.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "site_table")
public class Site {
    @ColumnInfo(name ="SiteId")
    @PrimaryKey(autoGenerate = true)
    private String SiteId;

    @ColumnInfo(name ="photoURL")
    private String photoURL;
    @ColumnInfo(name ="name")
    private String name;
    @ColumnInfo(name ="description")
    private String description;
    @ColumnInfo(name ="rate")
    private String rate;
    @ColumnInfo(name ="location")
    private String location;
    @ColumnInfo(name ="temperature")
    private String temperature;
    @ColumnInfo(name ="recommendations")
    private String recommendations;

    public Site(String photoURL, String name, String description, String rate, String location, String temperature, String recommendations) {
        this.photoURL = photoURL;
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.location = location;
        this.temperature = temperature;
        this.recommendations = recommendations;
    }

    public Site() {
    }

    public String getSiteId() {
        return SiteId;
    }

    public void setSiteId(String SiteId) {
        this.SiteId = SiteId;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }
}
