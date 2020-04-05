package com.gcc.smartcity.dashboard.model

import com.bluelinelabs.logansquare.annotation.JsonField
import com.bluelinelabs.logansquare.annotation.JsonObject

@JsonObject
class FormFieldsModel {

    @JsonField
    var label: String? = null

    @JsonField
    var type: String? = null

    @JsonField
    var isRequired: Boolean? = false

    @JsonField
    var data: ArrayList<String>? = null

}