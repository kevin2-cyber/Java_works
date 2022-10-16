package kevin.codelab.splashscreen

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import java.time.Instant
import java.time.Period.between
import java.time.chrono.ChronoPeriod.between
import javax.xml.datatype.Duration

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashScreen.setOnExitAnimationListener { splashScreenView ->
            val slideUp = ObjectAnimator.ofFloat(
                splashScreenView,
                View.TRANSLATION_Y,
                0f,
                -splashScreenView.height.toFloat()
            )
            slideUp.interpolator = AnticipateInterpolator()
            slideUp.duration = 200L

            slideUp.doOnEnd {
                splashScreenView.remove()
            }

            slideUp.start()

            // Get the duration of the animated vector drawable.
            val animationDuration = splashScreenView.iconAnimationDuration
// Get the start time of the animation.
            val animationStart = splashScreenView.iconAnimationStart
// Calculate the remaining duration of the animation.
            val remainingDuration = if (animationDuration != null && animationStart != null) {
                (animationDuration - Duration.between(animationStart, Instant.now()))
                    .toMillis()
                    .coerceAtLeast(0L)
            } else {
                0L
            }

            setContentView(R.layout.activity_main)
        }
    }


}