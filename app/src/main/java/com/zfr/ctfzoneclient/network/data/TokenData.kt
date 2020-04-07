package com.zfr.ctfzoneclient.network.data

import com.google.gson.annotations.SerializedName
import com.zfr.ctfzoneclient.database.data.TokenDBEntity

enum class TokenType(token_type: String) {
    bearer("bearer"),
    refresh("refresh"),
    access("access"),
    session("session")
}




fun TokenNetworkEntity.asDatabaseEntity(user: UserNetworkEntity): TokenDBEntity {

    return TokenDBEntity(
        username = user.username!!,
        token = this.token,
        token_type = this.token_type.name,
        expired = this.expired
    )

}