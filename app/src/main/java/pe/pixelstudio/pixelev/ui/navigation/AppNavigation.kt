package pe.pixelstudio.pixelev.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.pixelstudio.pixelev.ui.screens.*

object AppRoutes {
    const val TIPO_CLIENTE = "tipo_cliente"
    const val DNI_RUC = "dni_ruc"
    const val CONFIRMACION_DATOS_SUNAT = "confirmacion_datos_sunat"
    const val GIRO_NEGOCIO = "giro_negocio"
    const val REGIMEN_TRIBUTARIO = "regimen_tributario"
    const val TIPO_LOCAL = "tipo_local"
    const val INICIO_ACTIVIDADES = "inicio_actividades"
    const val DIRECCION_NEGOCIO = "direccion_negocio"
    const val CONTACTO = "contacto"
    const val SUMINISTRO = "suministro"

    // Persona Jurídica
    const val DNI_REPRESENTANTE = "dni_representante"
    const val ESTADO_CIVIL_RL = "estado_civil_rl"
    const val DNI_CONYUGE_RL = "dni_conyuge_rl"
    const val DOMICILIO_RL = "domicilio_rl"
    const val ACCIONISTAS = "accionistas"
    const val PROPIEDADES_SOCIOS = "propiedades_socios"
    const val CONTACTO_PERSONAL_RL = "contacto_personal_rl"

    // Persona Natural
    const val ESTADO_CIVIL_PN = "estado_civil_pn"
    const val PROPIEDADES_PN = "propiedades_pn"
    const val AVALES = "avales"

    // Préstamo
    const val TIPO_PRODUCTO = "tipo_producto"
    const val MONTO_PLAZO = "monto_plazo"

    // Gastos
    const val ALQUILER = "alquiler"
    const val SERVICIOS_BASICOS = "servicios_basicos"
    const val CONTADOR = "contador"
    const val OTROS_GASTOS = "otros_gastos"

    // Activos
    const val BANCOS = "bancos"
    const val CUENTAS_POR_COBRAR = "cuentas_por_cobrar"
    const val INVENTARIO = "inventario"
    const val LOCALES = "locales"
    const val ACTIVOS_ADICIONALES = "activos_adicionales"
    const val TRABAJADORES = "trabajadores"
    const val DIAS_LABORABLES = "dias_laborables"
    const val PRODUCTOS_SERVICIOS = "productos_servicios"

    const val RESUMEN = "resumen"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    // val viewModel: CuestionarioViewModel = viewModel() // Se obtendrá el ViewModel aquí

    NavHost(navController = navController, startDestination = AppRoutes.TIPO_CLIENTE) {
        // Aquí se definirán todos los composables de las pantallas
        // composable(AppRoutes.TIPO_CLIENTE) { TipoClienteScreen(navController, viewModel) }
        // ... y así para las más de 30 pantallas
    }
}
