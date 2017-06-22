package com.josecuentas.android_customfont;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * Created by norman on 3/8/15.
 * Refactor by jcuentas on 22/06/17.
 * <p/>
 * Code taken from britzl on StackOverflow (slightly modified):
 * http://stackoverflow.com/questions/16901930/memory-leaks-with-custom-font-for-set-custom-font/16902532#16902532
 */

public class FontCache {

    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(Font font, Context context) {
        final String path = "fonts/";
        String fontname = path + font.getFont();
        Typeface typeface = fontCache.get(fontname);

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), fontname);
            } catch (Exception e) {
                return null;
            }

            fontCache.put(fontname, typeface);
        }

        return typeface;
    }


}
