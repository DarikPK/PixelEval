package pe.pixelstudio.pixelev.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import pe.pixelstudio.pixelev.ui.navigation.AppRoutes
import pe.pixelstudio.pixelev.viewmodel.CuestionarioViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionnaireTopAppBar(
    navController: NavController,
    viewModel: CuestionarioViewModel
) {
    TopAppBar(
        title = { Text("Cuestionario") },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Regresar")
            }
        },
        actions = {
            IconButton(onClick = {
                viewModel.clearEvaluation()
                navController.navigate(AppRoutes.HOME) {
                    popUpTo(AppRoutes.HOME) { inclusive = true }
                }
            }) {
                Icon(Icons.Default.ExitToApp, contentDescription = "Salir")
            }
        }
    )
}
