package pe.pixelstudio.pixelev.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ResumenScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Resumen Final del Cuestionario")
        Spacer(modifier = Modifier.height(16.dp))
        // Aquí se mostrarían todos los datos del ViewModel
        Button(onClick = { /* TODO: Implementar generación de PDF */ }) {
            Text("Generar PDF")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("Atrás")
        }
    }
}
