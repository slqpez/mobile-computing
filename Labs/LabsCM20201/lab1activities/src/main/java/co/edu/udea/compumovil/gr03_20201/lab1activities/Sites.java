package co.edu.udea.compumovil.gr03_20201.lab1activities;

public class Sites {
    int id;

    public int getPunt() {
        return punt;
    }

    public void setPunt(int punt) {
        this.punt = punt;
    }

    int punt;

    public Sites() {
    }

    @Override
    public String toString() {
        return "Sites{" +
                "id=" + id +
                ", photo='" + photo + '\'' +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", location='" + location + '\'' +
                ", tempe='" + tempe + '\'' +
                ", sitesR='" + sitesR + '\'' +
                '}';
    }

    public Sites(int id, String photo, String name, String info, String location, String tempe, String sitesR) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.info = info;
        this.location = location;
        this.tempe = tempe;
        this.sitesR = sitesR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTempe() {
        return tempe;
    }

    public void setTempe(String tempe) {
        this.tempe = tempe;
    }

    public String getSitesR() {
        return sitesR;
    }

    public void setSitesR(String sitesR) {
        this.sitesR = sitesR;
    }

    String photo, name, info, location, tempe, sitesR;
}
