package pe.pixelstudio.pixelev.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pe.pixelstudio.pixelev.ui.components.QuestionnaireTopAppBar
import pe.pixelstudio.pixelev.ui.navigation.AppRoutes
import pe.pixelstudio.pixelev.viewmodel.CuestionarioViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipoClienteScreen(navController: NavController, viewModel: CuestionarioViewModel) {
    Scaffold(
        topBar = { QuestionnaireTopAppBar(navController = navController, viewModel = viewModel) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Tipo de Cliente")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                viewModel.onTipoClienteChanged("PERSONA_NATURAL")
                navController.navigate(AppRoutes.PERSONA_NATURAL_DNI)
            }) {
                Text("Persona Natural")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                viewModel.onTipoClienteChanged("PERSONA_JURIDICA")
                navController.navigate(AppRoutes.PERSONA_JURIDICA_RUC)
            }) {
                Text("Persona Jurídica")
            }
        }
    }
}
