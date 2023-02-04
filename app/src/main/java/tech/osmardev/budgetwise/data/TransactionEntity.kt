package tech.osmardev.budgetwise.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import tech.osmardev.budgetwise.utils.Constants

/**
 * Created by Osmar Jrz. on 04/02/23
 */
@Entity(tableName = Constants.DATABASE_MOVIES_TABLE)
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val type: String,
    val name: String,
    val value: Float
)
