package com.example.cardscanner.ocr

import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.text.TextBlock

class ProcessText(private val text: (String) -> Unit) : Detector.Processor<TextBlock>{
    override fun release() {}

    override fun receiveDetections(detections: Detector.Detections<TextBlock>) {
        val items = detections.detectedItems
        if (items.size() != 0) {
            for (i in 0 until items.size()) {
                val item = items.valueAt(i)
                item.components.forEach {it->
                    text(it.value.trim()
                        .replace(" ", "")
                        .take(8)
                    )
                }
            }
        }
    }

}