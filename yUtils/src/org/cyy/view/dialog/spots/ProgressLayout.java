package org.cyy.view.dialog.spots;


import org.cyy.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ProgressLayout extends FrameLayout {

    private static final int DEFAULT_COUNT = 5;
    private int spotsCount;
	private AttributeSet attrs;

    public ProgressLayout(Context context) {
        this(context, null);
    }

    public ProgressLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr, 0);
    }


    private void init(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Dialog,
                defStyleAttr, defStyleRes);

        spotsCount = a.getInt(R.styleable.Dialog_DialogSpotCount, DEFAULT_COUNT);
        a.recycle();
    }

    public int getSpotsCount() {
        return spotsCount;
    }
}
