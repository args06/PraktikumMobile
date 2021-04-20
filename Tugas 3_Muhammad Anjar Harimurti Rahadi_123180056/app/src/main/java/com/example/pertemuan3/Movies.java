package com.example.pertemuan3;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {
    private String sName, sDetail, sImage, sDirector, sReleaseDate, sRunningTime;

    public Movies(String sName, String sDetail, String sImage, String sDirector, String sReleaseDate, String sRunningTime) {
        this.sName = sName;
        this.sDetail = sDetail;
        this.sImage = sImage;
        this.sDirector = sDirector;
        this.sReleaseDate = sReleaseDate;
        this.sRunningTime = sRunningTime;
    }

    public Movies() {
    }

    protected Movies(Parcel in) {
        sName = in.readString();
        sDetail = in.readString();
        sImage = in.readString();
        sDirector = in.readString();
        sReleaseDate = in.readString();
        sRunningTime = in.readString();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsDetail() {
        return sDetail;
    }

    public void setsDetail(String sDetail) {
        this.sDetail = sDetail;
    }

    public String getsImage() {
        return sImage;
    }

    public void setsImage(String sImage) {
        this.sImage = sImage;
    }

    public String getsDirector() {
        return sDirector;
    }

    public void setsDirector(String sDirector) {
        this.sDirector = sDirector;
    }

    public String getsReleaseDate() {
        return sReleaseDate;
    }

    public void setsReleaseDate(String sReleaseDate) {
        this.sReleaseDate = sReleaseDate;
    }

    public String getsRunningTime() {
        return sRunningTime;
    }

    public void setsRunningTime(String sRunningTime) {
        this.sRunningTime = sRunningTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sName);
        dest.writeString(sDetail);
        dest.writeString(sImage);
        dest.writeString(sDirector);
        dest.writeString(sReleaseDate);
        dest.writeString(sRunningTime);
    }
}
