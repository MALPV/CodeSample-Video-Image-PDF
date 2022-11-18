package cl.malpv.aplicaciones.video_image_pdf.ui.viewer

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView

const val urlExamplePDF = "https://www.africau.edu/images/default/sample.pdf"

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun PDFViewerScreen(
    modifier: Modifier,
    url: String = urlExamplePDF
) {
    val docsViewer = "https://docs.google.com/viewer?url="

    var showError by remember { mutableStateOf(false) }

    AndroidView(
        modifier = modifier,
        factory = {
            it.deleteDatabase("webview.db")
            it.deleteDatabase("webviewCache.db")

            WebView(it).apply {
                clearHistory()
                clearCache(true)

                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )

                settings.cacheMode = WebSettings.LOAD_NO_CACHE
                settings.javaScriptEnabled = true
                settings.builtInZoomControls = true
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true

                setInitialScale(0)

                webViewClient = object : WebViewClient() {

                    // Informe el error de carga del recurso web a la aplicación host.
                    override fun onReceivedError(
                        view: WebView?,
                        request: WebResourceRequest?,
                        error: WebResourceError?
                    ) {
                        showError = true
                    }

                }

                loadUrl(docsViewer + url)
            }
        },
        update = {  }
    )

    if (showError)
        Column(
            modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "No se ha podido cargar el contenido, " +
                        "verifique la conexión e intente nuevamente.",
                fontSize = 24.sp
            )
        }
}
