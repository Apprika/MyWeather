package co.za.kudzi.myweather.util

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionUtil {

    @Composable
    fun ShowPermissionRationale(
        onDismiss: () -> Unit, onConfirm: () -> Unit, title: String = "Permission", body: String = "Permission needed"
    ) {
        Log.i("Weather", "We are showing rational")
        AlertDialog(
            confirmButton = {
                TextButton(onClick = onConfirm) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text("Cancel")
                }
            },
            text = {
                Text(text = body)
            },
            onDismissRequest = onDismiss,
            title = {
                Text(text = title)
            },
        )

    }

}