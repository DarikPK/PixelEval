package pe.pixelstudio.pixelev.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pe.pixelstudio.pixelev.ui.navigation.AppRoutes
import pe.pixelstudio.pixelev.viewmodel.CuestionarioViewModel

@Composable
fun PersonaJuridicaRucScreen(navController: NavController, viewModel: CuestionarioViewModel) {
    var ruc by remember { mutableStateOf("20") }
    val isRucValid = ruc.length == 11

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Ingresar RUC")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = ruc,
            onValueChange = { if (it.length <= 11 && it.startsWith("20")) ruc = it },
            label = { Text("RUC") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        if (!isRucValid) {
            Text("El RUC debe tener 11 dígitos y empezar con 20")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = { navController.popBackStack() }) {
                Text("Atrás")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { navController.navigate(AppRoutes.CONFIRMACION_DATOS_SUNAT) },
                enabled = isRucValid
            ) {
                Text("Siguiente")
            }
        }
    }
}
