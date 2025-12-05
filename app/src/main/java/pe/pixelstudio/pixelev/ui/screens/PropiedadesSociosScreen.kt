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
fun PropiedadesSociosScreen(navController: NavController, viewModel: CuestionarioViewModel) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Propiedades de los Socios")
        Spacer(modifier = Modifier.height(16.dp))
        // Aquí irían las preguntas sobre propiedades de los socios
        Row {
            Button(onClick = { navController.popBackStack() }) {
                Text("Atrás")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { navController.navigate(AppRoutes.CONTACTO_PERSONAL_RL) }) {
                Text("Siguiente")
            }
        }
    }
}
