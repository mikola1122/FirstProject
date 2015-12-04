package com.heliocratic.mikola.firstproject.ui.keybord_setting.items_settings;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class ProgressHintSeekBar extends SeekBar {

    public ProgressHintSeekBar(Context context) {
        super(context);
    }

    public ProgressHintSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressHintSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String text = Integer.toString((this.getProgress() + 1) * 2 + 2);
        Paint p = new Paint();
        p.setTypeface(Typeface.DEFAULT);
        p.setTextSize(22);
        p.setColor(0xFFFFFFFF);
        float thumb_x;
        if ((this.getProgress() + 1) * 2 + 2 < 10)
            thumb_x = this.getProgress() * 2 * this.getWidth() / 76 + 25;
        else
            thumb_x = this.getProgress() * 2 * this.getWidth() / 76 + 21;
        float middle = this.getHeight() / 3;
        canvas.drawText(text, thumb_x, middle, p);
    }
}
