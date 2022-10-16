package cl.malpv.aplicaciones.video_image_pdf.ui.viewer

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

const val urlExamplePDF = "www.africau.edu/images/default/sample.pdf"

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun PDFViewerScreen(
    modifier: Modifier,
    url: String = urlExamplePDF
) {
    val docsViewer = "https://docs.google.com/viewer?url="

    AndroidView(
        modifier = modifier,
        factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                settings.setSupportZoom(true)
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
                loadUrl(docsViewer + url)
            }
        },
        update = { it.loadUrl(docsViewer + url) }
    )
}