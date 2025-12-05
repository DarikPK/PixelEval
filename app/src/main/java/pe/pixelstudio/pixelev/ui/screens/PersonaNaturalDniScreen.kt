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
import pe.pixelstudio.pixelev.ui.components.QuestionnaireTopAppBar
import pe.pixelstudio.pixelev.ui.navigation.AppRoutes
import pe.pixelstudio.pixelev.viewmodel.CuestionarioViewModel
import pe.pixelstudio.pixelev.viewmodel.SunatValidationState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonaNaturalDniScreen(navController: NavController, viewModel: CuestionarioViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val sunatState by viewModel.sunatState.collectAsState()
    val isDniValid = uiState.dniORuc.length == 8

    Scaffold(
        topBar = { QuestionnaireTopAppBar(navController = navController, viewModel = viewModel) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Ingresar DNI")
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = uiState.dniORuc,
                onValueChange = { viewModel.onDniChanged(it) },
                label = { Text("DNI") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = !isDniValid && uiState.dniORuc.isNotEmpty()
            )
            if (!isDniValid && uiState.dniORuc.isNotEmpty()) {
                Text("El DNI debe tener 8 dígitos")
            }
            Spacer(modifier = Modifier.height(16.dp))

            when (val state = sunatState) {
                is SunatValidationState.Loading -> CircularProgressIndicator()
                is SunatValidationState.Success -> {
                    Text("Cliente: ${state.nombre}")
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        viewModel.setLastScreen(AppRoutes.PERSONA_NATURAL_DNI)
                        navController.navigate(AppRoutes.CONFIRMACION_DATOS_SUNAT)
                    }) {
                        Text("Siguiente")
                    }
                }
                is SunatValidationState.Error -> Text(state.message)
                else -> Button(
                    onClick = { viewModel.validarDocumento() },
                    enabled = isDniValid
                ) {
                    Text("Validar")
                }
            }

            if (uiState.razonSocial.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { viewModel.saveEvaluation() }) {
                    Text("Guardar")
                }
            }
        }
    }
}
