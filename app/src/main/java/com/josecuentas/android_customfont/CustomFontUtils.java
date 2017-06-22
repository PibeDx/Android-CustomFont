package com.josecuentas.android_customfont;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by norman on 3/8/15.
 * Refactor by jcuentas on 22/06/17.
 */

public class CustomFontUtils {

    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";

    private static final int FONT_SAN_FRANCISCO_DISPLAY = 1;
    private static final int FONT_SF_UI_DISPLAY = 2;
    private static final int FONT_SF_UI_TEXT = 3;

    private static final int SEMIBOLD = 4;

    public static void applyCustomFont(TextView customFontTextView, Context context, AttributeSet attrs) {
        TypedArray attributeArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.CustomTextView);

        int fontName = attributeArray.getInt(R.styleable.CustomTextView_font, 1);

        // check if a special textStyle was used (e.g. extra bold)
        int textStyle = attributeArray.getInt(R.styleable.CustomTextView_textStyle, Typeface.NORMAL);

        // if nothing extra was used, fall back to regular android:textStyle parameter
        if (textStyle == 0) {
            textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL);
        }

        Typeface customFont = selectTypeface(context, fontName, textStyle);
        customFontTextView.setTypeface(customFont);

        attributeArray.recycle();
    }

    private static Typeface selectTypeface(Context context, int fontName, int textStyle) {
        switch (fontName) {
            case FONT_SAN_FRANCISCO_DISPLAY:
                switch (textStyle) {
                    case Typeface.NORMAL: return FontCache.getTypeface(Font.SAN_FRANCISCO_DISPLAY_NORMAL, context);
                    case Typeface.BOLD: return FontCache.getTypeface(Font.SAN_FRANCISCO_DISPLAY_BOLD, context);
                    case SEMIBOLD: return FontCache.getTypeface(Font.SAN_FRANCISCO_DISPLAY_SEMIBOLD, context);
                    default: return FontCache.getTypeface(Font.SAN_FRANCISCO_DISPLAY_NORMAL, context);
                }
            case FONT_SF_UI_DISPLAY:
                switch (textStyle) {
                    case Typeface.NORMAL: return FontCache.getTypeface(Font.SF_UI_DISPLAY_NORMAL, context);
                    default: return FontCache.getTypeface(Font.SF_UI_DISPLAY_NORMAL, context);
                }
            case FONT_SF_UI_TEXT:
                switch (textStyle) {
                    case Typeface.NORMAL: return FontCache.getTypeface(Font.SF_UI_TEXT_NORMAL, context);
                    case SEMIBOLD: return FontCache.getTypeface(Font.SF_UI_TEXT_SEMIBOLD, context);
                    default: return FontCache.getTypeface(Font.SF_UI_TEXT_NORMAL, context);
                }
            default:
                return FontCache.getTypeface(Font.DEFAULT, context);
        }
    }
}
