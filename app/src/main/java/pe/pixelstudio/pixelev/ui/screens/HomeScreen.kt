package pe.pixelstudio.pixelev.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pe.pixelstudio.pixelev.ui.navigation.AppRoutes
import pe.pixelstudio.pixelev.viewmodel.CuestionarioViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: CuestionarioViewModel = viewModel()) {
    val isEvaluationInProgress by viewModel.isEvaluationInProgress.collectAsState()
    val lastScreenRoute by viewModel.lastScreenRoute.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("PixelEval", style = androidx.compose.material3.MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = {
            viewModel.clearEvaluation()
            navController.navigate(AppRoutes.TIPO_CLIENTE)
        }) {
            Text("Nueva Evaluación")
        }
        if (isEvaluationInProgress) {
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                lastScreenRoute?.let { navController.navigate(it) }
            }) {
                Text("Continuar Evaluación")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* TODO: Implementar pantalla de evaluaciones pasadas */ }) {
            Text("Evaluaciones Pasadas")
        }
    }
}
