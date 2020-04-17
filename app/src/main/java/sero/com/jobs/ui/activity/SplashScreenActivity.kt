package sero.com.jobs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import sero.com.jobs.R
import sero.com.jobs.utils.SPLASH_SCREEN_ACTIVITY_DELAY
import sero.com.jobs.utils.extension.setThemeFromPrefs

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setThemeFromPrefs()
        setContentView(R.layout.activity_splashscreen)
        delayMainActivity()
    }

    private fun delayMainActivity() = lifecycle.coroutineScope.launch {
        delay(SPLASH_SCREEN_ACTIVITY_DELAY)
        startActivity(Intent(baseContext, MainActivity::class.java))
        finish()
    }
}