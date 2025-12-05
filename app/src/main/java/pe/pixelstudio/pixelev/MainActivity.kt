package pe.pixelstudio.pixelev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import pe.pixelstudio.pixelev.ui.navigation.AppNavigation
import pe.pixelstudio.pixelev.ui.theme.PixelEvalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //PixelEvalTheme {
                AppNavigation()
            //}
        }
    }
}
