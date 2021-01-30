package rakuten.india.model

import com.google.gson.annotations.SerializedName

class GitJsonModel {

    @SerializedName("name")
    var name: String? = null

    @SerializedName("desc")
    var desc: String? = null

    @SerializedName("lang")
    var lang: String? = null

    @SerializedName("privacy_status")
    var privacy_status: String? = null
}