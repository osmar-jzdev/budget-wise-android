package tech.osmardev.budgetwise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import tech.osmardev.budgetwise.databinding.ActivityMainBinding
import tech.osmardev.budgetwise.view.expenses.AddExpenseActivity
import tech.osmardev.budgetwise.view.incomes.AddIncomeActivity

/**
 * Created by Osmar Jrz. on 09/01/23
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_dashboard, R.id.navigation_expenses, R.id.navigation_incomes
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val buttonAddIncomeDashCardView: View = findViewById(R.id.btn_add_income)
        buttonAddIncomeDashCardView.setOnClickListener { _ ->
            startActivity(Intent(this, AddIncomeActivity::class.java))
        }

        val buttonAddExpenseDashCardView: View = findViewById(R.id.btn_add_expense)
        buttonAddExpenseDashCardView.setOnClickListener { _ ->
            startActivity(Intent(this, AddExpenseActivity::class.java))
        }
    }
}