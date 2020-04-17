package sero.com.jobs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import sero.com.jobs.R
import sero.com.jobs.utils.extension.doNothing
import sero.com.jobs.utils.extension.setThemeFromPrefs

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setThemeFromPrefs()
        setContentView(R.layout.activity_main)
        setupNavigationBar()
    }

    private fun setupNavigationBar() {
        nav_view?.run {
            setupWithNavController(findNavController(R.id.nav_host_fragment))
            setOnNavigationItemReselectedListener { doNothing() }
        }
    }
}
