package co.za.kudzi.myweather.util

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionUtil {
    fun checkPermission(context: Context, permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            context, permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun shouldShowRequestPermissionRationale(context: Context, permission: String): Boolean =
        ActivityCompat.shouldShowRequestPermissionRationale(
            context as Activity, permission
        )

    @Composable
    fun ShowPermissionRationale(
        onDismiss: () -> Unit, onConfirm: () -> Unit, title: String = "Permission", body: String = "Permission needed"
    ) {
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