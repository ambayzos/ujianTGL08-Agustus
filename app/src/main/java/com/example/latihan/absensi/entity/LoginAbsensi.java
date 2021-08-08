package com.example.latihan.absensi.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class LoginAbsensi implements Parcelable {

    @SerializedName("id")
    private Long id;
    @SerializedName("username")
    private String username;
    @SerializedName("tglMasuk")
    private String tglMasuk;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("image_url")
    private String image_url;

    public LoginAbsensi() {
    }

    public LoginAbsensi(Long id, String username, String tglMasuk, String latitude, String longitude, String image_url) {
        this.id = id;
        this.username = username;
        this.tglMasuk = tglMasuk;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image_url = image_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(String tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.username);
        dest.writeString(this.tglMasuk);
        dest.writeString(this.latitude);
        dest.writeString(this.longitude);
        dest.writeString(this.image_url);
    }

    public void readFromParcel(Parcel source) {
        this.id = (Long) source.readValue(Long.class.getClassLoader());
        this.username = source.readString();
        this.tglMasuk = source.readString();
        this.latitude = source.readString();
        this.longitude = source.readString();
        this.image_url = source.readString();
    }

    protected LoginAbsensi(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.username = in.readString();
        this.tglMasuk = in.readString();
        this.latitude = in.readString();
        this.longitude = in.readString();
        this.image_url = in.readString();
    }

    public static final Parcelable.Creator<LoginAbsensi> CREATOR = new Parcelable.Creator<LoginAbsensi>() {
        @Override
        public LoginAbsensi createFromParcel(Parcel source) {
            return new LoginAbsensi(source);
        }

        @Override
        public LoginAbsensi[] newArray(int size) {
            return new LoginAbsensi[size];
        }
    };
}
