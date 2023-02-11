package tech.osmardev.budgetwise.model

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

/**
 * Created by Osmar Jrz. on 04/02/23
 */
class TransactionRepository(private val transactionDao: TransactionDao) {

    val readAllData: Flow<List<TransactionEntity>> =  transactionDao.readData()

    @WorkerThread
    suspend fun insertTransactionData(transaction: TransactionEntity){
        transactionDao.insertTransaction(transaction)
    }

    @WorkerThread
    suspend fun getTransaction(id: Int): TransactionEntity {
        return transactionDao.getTransaction(id)
    }

    @WorkerThread
    suspend fun updateTransaction(transaction: TransactionEntity) {
        transactionDao.updateTransaction(transaction)
    }

    @WorkerThread
    suspend fun deleteTransaction(transaction: TransactionEntity) {
        transactionDao.deleteTransaction(transaction)
    }
}