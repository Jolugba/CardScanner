import android.app.Application
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.text.TextRecognizer

// Represents the configuration for text recognition using camera.
class OCRConfiguration(application: Application) {

    // TextRecognizer instance for text recognition.
    val textRecognizer: TextRecognizer = TextRecognizer.Builder(application).build()

    // CameraSource instance for accessing the camera and providing previews.

    val cameraSource: CameraSource = CameraSource.Builder(application, textRecognizer).apply {
        setFacing(CameraSource.CAMERA_FACING_BACK)
        setRequestedPreviewSize(1280, 1024)
        setAutoFocusEnabled(true)
        setRequestedFps(60.0f)
    }.build()
}
