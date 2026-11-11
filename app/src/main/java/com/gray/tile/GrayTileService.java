package com.gray.tile;

import android.content.ContentResolver;
import android.provider.Settings;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.widget.Toast;

public class GrayTileService extends TileService {

    private static final String ENABLED = "accessibility_display_daltonizer_enabled";
    private static final String MODE = "accessibility_display_daltonizer";

    @Override
    public void onStartListening() {
        refresh();
    }

    @Override
    public void onClick() {
        ContentResolver cr = getContentResolver();
        try {
            if (isOn()) {
                Settings.Secure.putInt(cr, ENABLED, 0);
            } else {
                Settings.Secure.putInt(cr, MODE, 0);
                Settings.Secure.putInt(cr, ENABLED, 1);
            }
        } catch (SecurityException e) {
            Toast.makeText(this, "Permission missing. Run the ADB command.", Toast.LENGTH_LONG).show();
        }
        refresh();
    }

    private boolean isOn() {
        return Settings.Secure.getInt(getContentResolver(), ENABLED, 0) == 1;
    }

    private void refresh() {
        Tile t = getQsTile();
        if (t == null) return;
        t.setState(isOn() ? Tile.STATE_ACTIVE : Tile.STATE_INACTIVE);
        t.updateTile();
    }
}
