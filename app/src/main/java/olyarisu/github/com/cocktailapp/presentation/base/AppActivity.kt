package olyarisu.github.com.cocktailapp.presentation.base

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import olyarisu.github.com.cocktailapp.R



class AppActivity : MvpAppCompatActivity() {

    private val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.container) as? BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        supportFragmentManager.beginTransaction().add(R.id.container, AppFragment()).commit()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }
}