package com.gcc.smartcity.fontui;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

/**
 * Custom AutoCompleteTextView which allows us to apply custom font
 */
public class FontAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    public FontAutoCompleteTextView(Context context) {
        super(context);
        CustomFont.applyFont(context, this, null);
    }

    public FontAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        CustomFont.applyFont(context, this, attrs);
    }

    public FontAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        CustomFont.applyFont(context, this, attrs);
    }

    @Override
    protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {

    }

}
