package co.za.kudzi.myweather.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

class PermissionViewModel : ViewModel() {

    private val _permissionState = mutableStateOf<Boolean>(false)

    val permissionState: MutableState<Boolean> get() = _permissionState

    private val _showRationaleDialog = mutableStateOf(false)

    val showRationaleDialog get() = _showRationaleDialog

    fun updatePermissionState(newValue: Boolean = false) {
        _permissionState.value = newValue
    }

    fun updateShowRational(newOption: Boolean = true) {
        _showRationaleDialog.value = newOption
    }


}