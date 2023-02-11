package tech.osmardev.budgetwise.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import tech.osmardev.budgetwise.utils.Constants

/**
 * Created by Osmar Jrz. on 04/02/23
 */
@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTransaction(transaction: TransactionEntity)

    @Query("SELECT * FROM ${Constants.DATABASE_MOVIES_TABLE} ORDER BY id ASC")
    fun readData(): Flow<List<TransactionEntity>>

    @Query("SELECT * FROM ${Constants.DATABASE_MOVIES_TABLE} WHERE ID = :id")
    suspend fun getTransaction(id: Int): TransactionEntity

    @Update
    suspend fun updateTransaction(transaction: TransactionEntity)

    @Delete
    suspend fun deleteTransaction(transaction: TransactionEntity)
}