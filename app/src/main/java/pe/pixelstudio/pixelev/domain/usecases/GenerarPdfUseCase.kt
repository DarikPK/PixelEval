package pe.pixelstudio.pixelev.domain.usecases

import android.content.Context
import pe.pixelstudio.pixelev.data.models.Cuestionario
import pe.pixelstudio.pixelev.pdf.generator.PdfGenerator

class GenerarPdfUseCase {
    operator fun invoke(context: Context, cuestionario: Cuestionario): String {
        return PdfGenerator.generarPdf(context, cuestionario)
    }
}
