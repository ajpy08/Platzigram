package mx.com.javi08.platzigram.model;

/**
 * Created by javi on 24/03/2017.
 */

public class Picture {

    private String picture;
    private String userName;
    private String time;
    private String like_number = "0";

    //Este constructor se genero automaticamente apartir de la clase con ALT+INSERT - Generate - Constructor y seleccionas todas las variables
    public Picture(String picture, String userName, String time, String like_number) {
        this.picture = picture;
        this.userName = userName;
        this.time = time;
        this.like_number = like_number;
    }

    //Estos getters y setters se generaron automaticamente con ALT+INSERT - Getter and Setter - Constructor y seleccionas todas las variables
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLike_number() {
        return like_number;
    }

    public void setLike_number(String like_number) {
        this.like_number = like_number;
    }
}
