/*
 * Copyright (C) 2023-24 Paranoid Android
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package co.aospa.dolby.oplus

import android.service.quicksettings.Tile
import android.service.quicksettings.TileService

private const val TAG = "DolbyTileService"

class DolbyTileService : TileService() {

    private val dolbyController by lazy { DolbyController.getInstance(applicationContext) }

    override fun onStartListening() {
        super.onStartListening()
        updateTileState()
    }

    override fun onClick() {
        super.onClick()
        toggleDolbyState()
    }

    private fun updateTileState() {
        qsTile.apply {
            state = if (dolbyController.dsOn) Tile.STATE_ACTIVE else Tile.STATE_INACTIVE
            subtitle = dolbyController.getProfileName() ?: getString(R.string.dolby_unknown)
            updateTile()
        }
    }

    private fun toggleDolbyState() {
        dolbyController.dsOn = !dolbyController.dsOn
        updateTileState()
    }
}
