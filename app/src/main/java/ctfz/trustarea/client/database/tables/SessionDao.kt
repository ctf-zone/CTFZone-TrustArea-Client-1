package ctfz.trustarea.client.database.tables

import androidx.room.*
import ctfz.trustarea.client.database.data.TokenDBEntity

@Dao
interface SessionDao {

    @Query("SELECT * FROM TokenDBEntity WHERE token LIKE :token LIMIT 1")
    fun userByToken(token: String): TokenDBEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSession(token: TokenDBEntity)

    @Update
    fun updateSession(token: TokenDBEntity)

    @Delete
    fun deleteSession(token: TokenDBEntity)
}