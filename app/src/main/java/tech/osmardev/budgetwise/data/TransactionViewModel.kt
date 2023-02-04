package tech.osmardev.budgetwise.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Osmar Jrz. on 04/02/23
 */
class TransactionViewModel(application: Application): AndroidViewModel(application) {

    val repository: TransactionRepository
    val readAllData: LiveData<List<TransactionEntity>>

    init {
        val transactionDao = DBTransactions.getDatabase(application).transactionDao()
        repository = TransactionRepository(transactionDao)
        readAllData = repository.readAllData.asLiveData()
    }

    fun addTransaction(transaction: TransactionEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertTransactionData(transaction)
        }
    }

    fun updateTransaction(transaction: TransactionEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTransaction(transaction)
        }
    }


    fun deleteTransaction(transaction: TransactionEntity){
        viewModelScope.launch {
            repository.deleteTransaction(transaction)
        }
    }
}