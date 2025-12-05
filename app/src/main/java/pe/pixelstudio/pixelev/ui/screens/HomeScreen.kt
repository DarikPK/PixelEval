package pe.pixelstudio.pixelev.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pe.pixelstudio.pixelev.ui.navigation.AppRoutes

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("PixelEval", style = androidx.compose.material3.MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { navController.navigate(AppRoutes.TIPO_CLIENTE) }) {
            Text("Nueva Evaluación")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* TODO: Implementar pantalla de evaluaciones pasadas */ }) {
            Text("Evaluaciones Pasadas")
        }
    }
}
