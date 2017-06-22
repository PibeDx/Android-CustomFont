package com.josecuentas.android_customfont;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by jcuentas on 22/06/17.
 */
public class CustomTextView extends AppCompatTextView {

    public CustomTextView(Context context) {
        super(context);
        if(!isInEditMode())
            CustomFontUtils.applyCustomFont(this, context, null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode())
            CustomFontUtils.applyCustomFont(this, context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if(!isInEditMode())
            CustomFontUtils.applyCustomFont(this, context, attrs);
    }
}
