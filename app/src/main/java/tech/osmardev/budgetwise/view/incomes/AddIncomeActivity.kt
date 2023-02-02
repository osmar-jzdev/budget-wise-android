package tech.osmardev.budgetwise.view.incomes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tech.osmardev.budgetwise.MainActivity
import tech.osmardev.budgetwise.R
import tech.osmardev.budgetwise.databinding.ActivityAddIncomeBinding

class AddIncomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddIncomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddIncomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle(R.string.add_income_title)
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
                    txtInputIncomeName.text.toString().isEmpty() -> {
                        txtInputIncomeName.error = resources.getString(R.string.error_empty_box)
                    }
                    txtInputIncomeValue.text.toString().isEmpty() -> {
                        binding.txtInputIncomeValue.error = resources.getString(R.string.error_empty_box)
                    }
                    else -> {
                        startActivity(Intent(this@AddIncomeActivity, MainActivity::class.java))
                        finish()
                    }
                }
            }
        }
    }
}