package pe.pixelstudio.pixelev.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.pixelstudio.pixelev.ui.screens.*
import pe.pixelstudio.pixelev.viewmodel.CuestionarioViewModel

object AppRoutes {
    const val HOME = "home"
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
    const val DNI_REPRESENTANTE = "dni_representante"
    const val ESTADO_CIVIL_RL = "estado_civil_rl"
    const val DNI_CONYUGE_RL = "dni_conyuge_rl"
    const val DOMICILIO_RL = "domicilio_rl"
    const val ACCIONISTAS = "accionistas"
    const val PROPIEDADES_SOCIOS = "propiedades_socios"
    const val CONTACTO_PERSONAL_RL = "contacto_personal_rl"
    const val ESTADO_CIVIL_PN = "estado_civil_pn"
    const val PROPIEDADES_PN = "propiedades_pn"
    const val AVALES = "avales"
    const val TIPO_PRODUCTO = "tipo_producto"
    const val MONTO_PLAZO = "monto_plazo"
    const val ALQUILER = "alquiler"
    const val SERVICIOS_BASICOS = "servicios_basicos"
    const val CONTADOR = "contador"
    const val OTROS_GASTOS = "otros_gastos"
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
    val viewModel: CuestionarioViewModel = viewModel()

    NavHost(navController = navController, startDestination = AppRoutes.HOME) {
        composable(AppRoutes.HOME) { HomeScreen(navController) }
        composable(AppRoutes.TIPO_CLIENTE) { TipoClienteScreen(navController, viewModel) }
        composable(AppRoutes.DNI_RUC) { DniRucScreen(navController, viewModel) }
        composable(AppRoutes.CONFIRMACION_DATOS_SUNAT) { ConfirmacionDatosSunatScreen(navController, viewModel) }
        composable(AppRoutes.GIRO_NEGOCIO) { GiroNegocioScreen(navController, viewModel) }
        composable(AppRoutes.REGIMEN_TRIBUTARIO) { RegimenTributarioScreen(navController, viewModel) }
        composable(AppRoutes.TIPO_LOCAL) { TipoLocalScreen(navController, viewModel) }
        composable(AppRoutes.INICIO_ACTIVIDADES) { InicioActividadesScreen(navController, viewModel) }
        composable(AppRoutes.DIRECCION_NEGOCIO) { DireccionNegocioScreen(navController, viewModel) }
        composable(AppRoutes.CONTACTO) { ContactoScreen(navController, viewModel) }
        composable(AppRoutes.SUMINISTRO) { SuministroScreen(navController, viewModel) }
        composable(AppRoutes.DNI_REPRESENTANTE) { DniRepresentanteScreen(navController, viewModel) }
        composable(AppRoutes.ESTADO_CIVIL_RL) { EstadoCivilRLScreen(navController, viewModel) }
        composable(AppRoutes.DNI_CONYUGE_RL) { DniConyugeRLScreen(navController, viewModel) }
        composable(AppRoutes.DOMICILIO_RL) { DomicilioRLScreen(navController, viewModel) }
        composable(AppRoutes.ACCIONISTAS) { AccionistasScreen(navController, viewModel) }
        composable(AppRoutes.PROPIEDADES_SOCIOS) { PropiedadesSociosScreen(navController, viewModel) }
        composable(AppRoutes.CONTACTO_PERSONAL_RL) { ContactoPersonalRLScreen(navController, viewModel) }
        composable(AppRoutes.ESTADO_CIVIL_PN) { EstadoCivilPNScreen(navController, viewModel) }
        composable(AppRoutes.PROPIEDADES_PN) { PropiedadesPNScreen(navController, viewModel) }
        composable(AppRoutes.AVALES) { AvalesScreen(navController, viewModel) }
        composable(AppRoutes.TIPO_PRODUCTO) { TipoProductoScreen(navController, viewModel) }
        composable(AppRoutes.MONTO_PLAZO) { MontoPlazoScreen(navController, viewModel) }
        composable(AppRoutes.ALQUILER) { AlquilerScreen(navController, viewModel) }
        composable(AppRoutes.SERVICIOS_BASICOS) { ServiciosBasicosScreen(navController, viewModel) }
        composable(AppRoutes.CONTADOR) { ContadorScreen(navController, viewModel) }
        composable(AppRoutes.OTROS_GASTOS) { OtrosGastosScreen(navController, viewModel) }
        composable(AppRoutes.BANCOS) { BancosScreen(navController, viewModel) }
        composable(AppRoutes.CUENTAS_POR_COBRAR) { CuentasPorCobrarScreen(navController, viewModel) }
        composable(AppRoutes.INVENTARIO) { InventarioScreen(navController, viewModel) }
        composable(AppRoutes.LOCALES) { LocalesScreen(navController, viewModel) }
        composable(AppRoutes.ACTIVOS_ADICIONALES) { ActivosAdicionalesScreen(navController, viewModel) }
        composable(AppRoutes.TRABAJADORES) { TrabajadoresScreen(navController, viewModel) }
        composable(AppRoutes.DIAS_LABORABLES) { DiasLaborablesScreen(navController, viewModel) }
        composable(AppRoutes.PRODUCTOS_SERVICIOS) { ProductosServiciosScreen(navController, viewModel) }
        composable(AppRoutes.RESUMEN) { ResumenScreen(navController, viewModel) }
    }
}
