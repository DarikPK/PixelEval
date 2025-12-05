package pe.pixelstudio.pixelev.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pe.pixelstudio.pixelev.ui.navigation.AppRoutes
import pe.pixelstudio.pixelev.viewmodel.CuestionarioViewModel
import pe.pixelstudio.pixelev.viewmodel.SunatValidationState

@Composable
fun PersonaJuridicaRucScreen(navController: NavController, viewModel: CuestionarioViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val sunatState by viewModel.sunatState.collectAsState()
    val isRucValid = uiState.dniORuc.length == 11

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Ingresar RUC")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = uiState.dniORuc,
            onValueChange = { viewModel.onRucChanged(it) },
            label = { Text("RUC") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = !isRucValid && uiState.dniORuc.length > 2
        )
        if (!isRucValid && uiState.dniORuc.length > 2) {
            Text("El RUC debe tener 11 dígitos y empezar con 20")
        }
        Spacer(modifier = Modifier.height(16.dp))

        when (val state = sunatState) {
            is SunatValidationState.Loading -> CircularProgressIndicator()
            is SunatValidationState.Success -> {
                Text("Razón Social: ${state.nombre}")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { navController.navigate(AppRoutes.CONFIRMACION_DATOS_SUNAT) }) {
                    Text("Siguiente")
                }
            }
            is SunatValidationState.Error -> Text(state.message)
            else -> Button(
                onClick = { viewModel.validarDocumento() },
                enabled = isRucValid
            ) {
                Text("Validar")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("Atrás")
        }
    }
}
