package com.example.aluno.easyrecipe.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Recipe implements Parcelable{

    private final String title;
    private String yield;
    private String time;
    private ArrayList<String> ingredients;
    private ArrayList<String> steps;

    public Recipe(String title) {
        this.title = title;
    }

    public void setYield(String yield) {
        this.yield = yield;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setSteps(ArrayList<String> steps) {
        this.steps = steps;
    }

    public String getTitle() {
        return title;
    }

    public String getYield() {
        return yield;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public ArrayList<String> getSteps() {
        return steps;
    }
    protected Recipe(Parcel in) {
        title = in.readString();
        yield = in.readString();
        time = in.readString();
        if (in.readByte() == 0x01) {
            ingredients = new ArrayList<String>();
            in.readList(ingredients, String.class.getClassLoader());
        } else {
            ingredients = null;
        }
        if (in.readByte() == 0x01) {
            steps = new ArrayList<String>();
            in.readList(steps, String.class.getClassLoader());
        } else {
            steps = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(yield);
        dest.writeString(time);
        if (ingredients == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(ingredients);
        }
        if (steps == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(steps);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

}
