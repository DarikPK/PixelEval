package pe.pixelstudio.pixelev.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.pixelstudio.pixelev.ui.screens.*

// Definición de las rutas de la aplicación
object AppRoutes {
    const val HOME = "home"
    const val TIPO_CLIENTE = "tipo_cliente"
    const val CUESTIONARIO = "cuestionario"
    const val RESUMEN = "resumen"
    const val PDF_GENERADO = "pdf_generado"
    const val SETTINGS = "settings"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppRoutes.HOME) {
        composable(AppRoutes.HOME) {
            HomeScreen(navController = navController)
        }
        composable(AppRoutes.TIPO_CLIENTE) {
            TipoClienteScreen(navController = navController)
        }
        composable(AppRoutes.CUESTIONARIO) {
            CuestionarioScreen(navController = navController)
        }
        composable(AppRoutes.RESUMEN) {
            ResumenScreen(navController = navController)
        }
        composable(AppRoutes.PDF_GENERADO) {
            PdfGeneratedScreen(navController = navController)
        }
        composable(AppRoutes.SETTINGS) {
            SettingsScreen(navController = navController)
        }
    }
}
