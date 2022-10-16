package cl.malpv.aplicaciones.video_image_pdf.ui.viewer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

const val urlExampleImage = "https://i.blogs.es/2b63f8/androidze/840_560.jpg"

@Composable
fun ImageViewerScreen(modifier: Modifier, url: String = urlExampleImage) {
    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = null,
        modifier = modifier.size(200.dp)
    )
}