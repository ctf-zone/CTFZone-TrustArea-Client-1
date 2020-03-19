package com.zfr.ctfzoneclient.database.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zfr.ctfzoneclient.network.data.UserNetworkEntity

/**
 * UserDBEntity represents a user entity in the database
 */
@Entity
data class UserDBEntity constructor(
    @PrimaryKey
    val user_id: String,
    val user_name: String,
    val first_name: String,
    val last_name: String
)


/**
 * Extension: Map List<UserDBEntity> to domain entities (to Network Entity)
 */
fun List<UserDBEntity>.asDomainModel(): List<UserNetworkEntity> {
    return map {
        UserNetworkEntity(
            username = it.user_name,
            user_id = it.user_id,
            first_name = it.first_name,
            last_name = it.last_name
        )
    }
}

