package com.example.settingsapp

data class Item(
    val id: Int,
    val icon: Int,
    val title: String,
    val moreInfo: String?,
    val hasSwitch: Boolean = false,
    val iconArrow: Int,
    val textColor: Boolean = false
) {
    companion object {
        const val ARROW = -1
    }
}
