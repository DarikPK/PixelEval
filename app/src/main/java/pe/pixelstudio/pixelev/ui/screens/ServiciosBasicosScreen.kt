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
fun ServiciosBasicosScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Paso 21: Servicios Básicos")
        Spacer(modifier = Modifier.height(16.dp))
        // Aquí irían los campos de agua, luz e internet
        Row {
            Button(onClick = { navController.popBackStack() }) {
                Text("Atrás")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { navController.navigate(AppRoutes.CONTADOR) }) {
                Text("Siguiente")
            }
        }
    }
}
