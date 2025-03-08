/*
 * SPDX-FileCopyrightText: The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.lineageos.dolby

import android.os.Bundle
import org.lineageos.dolby.preference.DolbySettingsFragment
import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity

private const val TAG = "DolbyActivity"

class DolbyActivity : CollapsingToolbarBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentManager.beginTransaction()
            .replace(com.android.settingslib.collapsingtoolbar.R.id.content_frame, DolbySettingsFragment(), TAG)
            .commit()
    }
}
