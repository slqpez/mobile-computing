package co.edu.udea.compumovil.gr03_20201.lab1activities;

public class User {
    int id;
    String user, password;

    public User() {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public boolean isNull(){
        if(user.equals("") && password.equals("")){
            return false;
        }else{
            return  true;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
