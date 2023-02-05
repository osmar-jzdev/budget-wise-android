package tech.osmardev.budgetwise.view.expenses

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import tech.osmardev.budgetwise.MainActivity
import tech.osmardev.budgetwise.R
import tech.osmardev.budgetwise.databinding.ActivityAddExpenseBinding

class AddExpenseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddExpenseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle(R.string.add_expense_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_white)
        onClickBtnAdd()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun onClickBtnAdd() {
        binding.btnAdd.setOnClickListener {
            with(binding) {
                when {
                    txtInputExpenseName.text.toString().isEmpty() -> {
                        txtInputExpenseName.error = resources.getString(R.string.error_empty_box)
                    }
                    txtInputExpenseValue.text.toString().isEmpty() -> {
                        binding.txtInputExpenseValue.error = resources.getString(R.string.error_empty_box)
                    }
                    txtInputExpenseValue.text.toString().toFloat() == 0.0F-> {
                        binding.txtInputExpenseValue.error = resources.getString(R.string.error_empty_box)
                    }
                    else -> {
                        startActivity(Intent(this@AddExpenseActivity, MainActivity::class.java))
                        finish()
                    }
                }
            }
        }
    }
}