package rakuten.india.model;

import com.google.gson.annotations.SerializedName;

public class GitJsonModel {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPrivacy_status() {
        return privacy_status;
    }

    public void setPrivacy_status(String privacy_status) {
        this.privacy_status = privacy_status;
    }

    @SerializedName("name")
    private String name;
    @SerializedName("desc")
    private String desc;
    @SerializedName("lang")
    private String lang;
    @SerializedName("privacy_status")
    private String privacy_status;


}
