package com.josecuentas.android_customfont;

/**
 * Created by jcuentas on 22/06/17.
 */

public enum Font {
    DEFAULT("SanFranciscoDisplay-Regular.otf"),
    SAN_FRANCISCO_DISPLAY_NORMAL("SanFranciscoDisplay-Regular.otf"),
    SAN_FRANCISCO_DISPLAY_SEMIBOLD("SanFranciscoDisplay-Semibold.otf"),
    SAN_FRANCISCO_DISPLAY_BOLD("SanFranciscoDisplay-Bold.otf"),
    SF_UI_DISPLAY_NORMAL("SF-UI-Display-Regular.otf"),
    SF_UI_TEXT_NORMAL("SF-UI-Text-Regular.otf"),
    SF_UI_TEXT_SEMIBOLD("SF-UI-Text-Semibold.otf");

    private  String font ;

    Font(String font) {
        this.font = font;
    }

    public String getFont() {
        return font;
    }
}
