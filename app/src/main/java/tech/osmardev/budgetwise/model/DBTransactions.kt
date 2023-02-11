package tech.osmardev.budgetwise.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tech.osmardev.budgetwise.utils.Constants

/**
 * Created by Osmar Jrz. on 04/02/23
 */
@Database(entities = [TransactionEntity::class], version = 1)
abstract class DBTransactions: RoomDatabase() {

    abstract fun transactionDao(): TransactionDao

    companion object {
        @Volatile
        private var INSTANCE: DBTransactions? = null

        fun getDatabase(context: Context): DBTransactions {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DBTransactions::class.java,
                    Constants.DATABASE_NAME
                ).fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance

                instance
            }
        }
    }
}