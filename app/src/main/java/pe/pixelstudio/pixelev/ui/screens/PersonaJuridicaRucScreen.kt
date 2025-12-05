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
fun PersonaJuridicaRucScreen(navController: NavController, viewModel: CuestionarioViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val sunatState by viewModel.sunatState.collectAsState()
    val isRucValid = uiState.dniORuc.length == 11

    Scaffold(
        topBar = { QuestionnaireTopAppBar(navController = navController, viewModel = viewModel) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp),
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
                Text("El RUC debe tener 11 dígitos")
            }
            Spacer(modifier = Modifier.height(16.dp))

            when (val state = sunatState) {
                is SunatValidationState.Loading -> CircularProgressIndicator()
                is SunatValidationState.Success -> {
                    Text("Razón Social: ${state.nombre}")
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        viewModel.setLastScreen(AppRoutes.PERSONA_JURIDICA_RUC)
                        navController.navigate(AppRoutes.CONFIRMACION_DATOS_SUNAT)
                    }) {
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

            if (uiState.razonSocial.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { viewModel.saveEvaluation() }) {
                    Text("Guardar")
                }
            }
        }
    }
}
