package cl.malpv.aplicaciones.video_image_pdf.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cl.malpv.aplicaciones.video_image_pdf.ui.theme.VideoImagePDFTheme
import cl.malpv.aplicaciones.video_image_pdf.ui.viewer.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VideoImagePDFTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ContentViewerScreen(
                        title = "Video View Example",
                        urlContent = urlExampleVideo,
                        viewerType = ViewerType.VIDEO
                    )
                }
            }
        }
    }
}

@Composable
fun ContentViewerScreen(
    title: String,
    urlContent: String,
    viewerType: ViewerType
){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        when(viewerType){
            ViewerType.VIDEO ->
                VideoViewerScreen(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .fillMaxSize(),
                    url = urlContent
                )
            ViewerType.IMAGE ->
                ImageViewerScreen(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .fillMaxSize(),
                    url = urlContent
                )
            ViewerType.PDF -> {
                PDFViewerScreen(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .fillMaxSize(),
                    url = urlContent
                )
            }
        }

        Text(
            text = title,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .background(color = Color.Black)
                .padding(14.dp)
        )

    }
}