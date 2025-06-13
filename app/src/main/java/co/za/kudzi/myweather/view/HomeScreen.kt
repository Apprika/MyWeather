package co.za.kudzi.myweather.view

import android.Manifest
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import co.za.kudzi.myweather.util.PermissionUtil
import co.za.kudzi.myweather.util.PermissionUtil.ShowPermissionRationale
import co.za.kudzi.myweather.viewmodel.PermissionViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(permissionViewmodel: PermissionViewModel = viewModel()) {

    val context = LocalContext.current

    val permission = Manifest.permission.ACCESS_COARSE_LOCATION

    val permissionState = permissionViewmodel.permissionState

    val toShowRational = permissionViewmodel.showRationaleDialog

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted: Boolean ->
            if (isGranted) {
                permissionViewmodel.updatePermissionState(true)
            } else {
                if (PermissionUtil.shouldShowRequestPermissionRationale(context, permission)) {
                    permissionViewmodel.updateShowRational(true)
                }
                Toast.makeText(context, "Location permission was denied.", Toast.LENGTH_SHORT).show()
            }
        })

    LaunchedEffect(Unit) {
        permissionLauncher.launch(permission)
    }

    if (toShowRational.value) {
        ShowPermissionRationale(
            onDismiss = { permissionViewmodel.updateShowRational(false) },
            onConfirm = {
                permissionViewmodel.updateShowRational(false)
                permissionLauncher.launch(permission)
            }
        )
    }

    if (permissionState.value) {
        WeatherScreen()
        Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
    }
}

