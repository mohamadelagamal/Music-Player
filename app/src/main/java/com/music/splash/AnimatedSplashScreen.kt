import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.music.MainActivity
import com.music.ui.theme.Purple700
import kotlinx.coroutines.delay
import com.music.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedSplashScreen(navController: NavHostController) {

    val context = LocalContext?.current
    val activity = LocalContext.current as? Activity
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnimation = animateFloatAsState(targetValue =
    if (startAnimation) 1f else 0f ,
        animationSpec = tween(durationMillis = 3000)
    )
    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
       context.startActivity(Intent(context, MainActivity::class.java))
       activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        activity?.finish()

    }
    Splash(alpha = alphaAnimation.value)
}

@Composable
fun Splash(
    // this alpha animation value
    alpha:Float
) {

    Box(modifier = Modifier
        .background(if (isSystemInDarkTheme()) Color.Black else Color.Black)
        .fillMaxSize(), contentAlignment = Alignment.Center) {


        val image: Painter = painterResource(id = R.drawable.icon)
        Image(painter = image,contentDescription = "",
            modifier = Modifier.size(120.dp).alpha(alpha=alpha))
    }

}

@Composable
@Preview
fun SplashScreenPreview() {
    Splash(alpha = 1f)
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun SplashScreenDarkPreview() {
    Splash(alpha = 1f)
}