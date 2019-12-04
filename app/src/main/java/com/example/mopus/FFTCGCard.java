package com.example.mopus;

import com.google.gson.annotations.SerializedName;

public class FFTCGCard {
    @SerializedName("Code")
    private String code;
    @SerializedName("Element")
    private String element;
    @SerializedName("Rarity")
    private String rarity;
    @SerializedName("Cost")
    private String cost;
    @SerializedName("Power")
    private String power;
    @SerializedName("Category_1")
    private String category1;
    @SerializedName("Category_2")
    private String category2;
    @SerializedName("Multicard")
    private String multicard;
    @SerializedName("Ex_Burst")
    private String exBurst;
    @SerializedName("Name_EN")
    private String name;
    @SerializedName("Type_EN")
    private String type;
    @SerializedName("Job_EN")
    private String job;
    @SerializedName("Text_EN")
    private String text;
    @SerializedName("Set")
    private String set;

    public String getCode() {
        return code;
    }

    public String getElement() {
        return element;
    }

    public String getRarity() {
        return rarity;
    }

    public String getCost() {
        return cost;
    }

    public String getPower() {
        return power;
    }

    public String getCategory1() {
        return category1;
    }

    public String getCategory2() {
        return category2;
    }

    public String getMulticard() {
        return multicard;
    }

    public String getExBurst() {
        return exBurst;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getJob() {
        return job;
    }

    public String getText() {
        return text;
    }

    public String getSet() {
        return set;
    }
}
