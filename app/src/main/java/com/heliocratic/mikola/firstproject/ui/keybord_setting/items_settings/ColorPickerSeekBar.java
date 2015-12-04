package com.heliocratic.mikola.firstproject.ui.keybord_setting.items_settings;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class ColorPickerSeekBar extends SeekBar {

    private OnColorSeekBarChangeListener mOnColorSeekbarChangeListener;

    public void setOnColorSeekbarChangeListener(OnColorSeekBarChangeListener listener) {
        this.mOnColorSeekbarChangeListener = listener;
    }

    public ColorPickerSeekBar(Context context) {
        super(context);
    }

    public ColorPickerSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorPickerSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        init();
    }


    /**
     * Initializes the color seekbar with the gradient
     */
    public void init() {
        LinearGradient colorGradient = new LinearGradient(0.f, 0.f, this.getMeasuredWidth() - this.getThumb().getIntrinsicWidth(), 0.f,
                new int[]{0xFF000000, 0xFF0000FF, 0xFF00FF00, 0xFF00FFFF,
                        0xFFFF0000, 0xFFFF00FF, 0xFFFFFF00, 0xFFFFFFFF},
                null, Shader.TileMode.CLAMP
        );
        ShapeDrawable shape = new ShapeDrawable(new RectShape());
        shape.getPaint().setShader(colorGradient);
        this.setProgressDrawable(shape);
        this.setMax(256 * 7 - 1);
        //        Log.d("MIKI", String.valueOf(this.getMeasuredWidth() - this.getThumb().getIntrinsicWidth()));
        //        shape.setIntrinsicHeight(3);
        //        shape.setIntrinsicWidth(30);
    }

    /**
     * A callback that notifies clients when the color has been changed.
     * This includes changes that were initiated by the user through a
     * touch gesture or arrow key/trackball as well as changes that were initiated programmatically.
     */
    public interface OnColorSeekBarChangeListener {

        /**
         * Notification that the color has changed. Clients can use the fromUser parameter
         * to distinguish user-initiated changes from those that occurred programmatically.
         * Parameters:
         *
         * @param seekBar The SeekBar whose progress has changed
         * @param color   The current color-int from alpha, red, green, blue components.
         * @param b       True if the progress change was initiated by the user.
         */
        void onColorChanged(SeekBar seekBar, int color, boolean b);

        /**
         * Notification that the user has started a touch gesture.
         * Clients may want to use this to disable advancing the seekbar.
         *
         * @param seekBar The SeekBar in which the touch gesture began
         */
        void onStartTrackingTouch(SeekBar seekBar);

        /**
         * Notification that the user has finished a touch gesture.
         * Clients may want to use this to re-enable advancing the seekbar.
         *
         * @param seekBar The SeekBar in which the touch gesture finished
         */
        void onStopTrackingTouch(SeekBar seekBar);
    }

}
