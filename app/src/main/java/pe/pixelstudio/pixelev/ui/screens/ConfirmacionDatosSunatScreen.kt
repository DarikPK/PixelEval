package pe.pixelstudio.pixelev.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pe.pixelstudio.pixelev.ui.components.QuestionnaireTopAppBar
import pe.pixelstudio.pixelev.ui.navigation.AppRoutes
import pe.pixelstudio.pixelev.viewmodel.CuestionarioViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmacionDatosSunatScreen(navController: NavController, viewModel: CuestionarioViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = { QuestionnaireTopAppBar(navController = navController, viewModel = viewModel) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Confirmación de Datos SUNAT")
            Spacer(modifier = Modifier.height(16.dp))
            Text("Cliente: ${uiState.razonSocial}")
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Button(onClick = {
                    viewModel.setLastScreen(AppRoutes.CONFIRMACION_DATOS_SUNAT)
                    navController.navigate(AppRoutes.GIRO_NEGOCIO)
                }) {
                    Text("Siguiente")
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
