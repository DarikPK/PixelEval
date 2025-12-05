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
import pe.pixelstudio.pixelev.viewmodel.CuestionarioViewModel

@Composable
fun LocalesScreen(navController: NavController, viewModel: CuestionarioViewModel) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Locales")
        Spacer(modifier = Modifier.height(16.dp))
        // Aquí iría la lista dinámica de locales
        Row {
            Button(onClick = { navController.popBackStack() }) {
                Text("Atrás")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { navController.navigate(AppRoutes.ACTIVOS_ADICIONALES) }) {
                Text("Siguiente")
            }
        }
    }
}
