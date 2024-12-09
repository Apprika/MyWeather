package co.za.kudzi.myweather

import android.R
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionUtil {
    fun checkPermission(context: Context, permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun showRationale(context: Activity, permission: String): Boolean =
        ActivityCompat.shouldShowRequestPermissionRationale(context, permission)

    fun showPermissionRationale(context: Activity, permission: String) {
        AlertDialog.Builder(context).setTitle("Location access required").setMessage("We need your location to proceed further")
            .setPositiveButton(
                R.string.ok
            ) { _, _ ->
                ActivityCompat.requestPermissions(
                    context, arrayOf(permission), 22
                )
            }.create().show()
    }

}