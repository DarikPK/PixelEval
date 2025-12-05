package pe.pixelstudio.pixelev.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.pixelstudio.pixelev.data.models.CuestionarioState
import pe.pixelstudio.pixelev.data.remote.RetrofitClient

sealed interface SunatValidationState {
    object Idle : SunatValidationState
    object Loading : SunatValidationState
    data class Success(val nombre: String) : SunatValidationState
    data class Error(val message: String) : SunatValidationState
}

class CuestionarioViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CuestionarioState())
    val uiState = _uiState.asStateFlow()

    private val _sunatState = MutableStateFlow<SunatValidationState>(SunatValidationState.Idle)
    val sunatState = _sunatState.asStateFlow()

    fun onTipoClienteChanged(tipoCliente: String) {
        _uiState.update { it.copy(tipoCliente = tipoCliente) }
        if (tipoCliente == "PERSONA_JURIDICA") {
            _uiState.update { it.copy(dniORuc = "20") }
        } else {
            _uiState.update { it.copy(dniORuc = "") }
        }
    }

    fun onDniChanged(dni: String) {
        if (dni.length <= 8) {
            _uiState.update { it.copy(dniORuc = dni) }
        }
    }

    fun onRucChanged(ruc: String) {
        if (ruc.length <= 11 && ruc.startsWith("20")) {
            _uiState.update { it.copy(dniORuc = ruc) }
        }
    }

    fun validarDocumento() {
        viewModelScope.launch {
            _sunatState.value = SunatValidationState.Loading
            try {
                val numeroDocumento = _uiState.value.dniORuc
                if (_uiState.value.tipoCliente == "PERSONA_NATURAL") {
                    val dniData = RetrofitClient.instance.getDniData(numeroDocumento)
                    val nombre = dniData.nombre ?: "Nombre no disponible"
                    _sunatState.value = SunatValidationState.Success(nombre)
                    _uiState.update { it.copy(razonSocial = nombre) }
                } else {
                    val rucData = RetrofitClient.instance.getRucData(numeroDocumento)
                    val nombre = rucData.nombre ?: "Razón social no disponible"
                    _sunatState.value = SunatValidationState.Success(nombre)
                    _uiState.update { it.copy(razonSocial = nombre) }
                }
            } catch (e: Exception) {
                _sunatState.value = SunatValidationState.Error("Error de red o documento no válido")
            }
        }
    }
}
