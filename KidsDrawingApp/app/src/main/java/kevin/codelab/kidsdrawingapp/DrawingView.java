package kevin.codelab.kidsdrawingapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DrawingView extends View {

    private CustomPath mDrawPath;
    private Bitmap mCanvasBitmap = null;
    private Paint mDrawPaint;
    private Paint mCanvasPaint;
    private double mBrushSize = 0.0;
    private int color = Color.BLACK;
    private Canvas canvas;
    private ArrayList<CustomPath> mPaths;


    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void setUpDrawing() {
        mDrawPaint = new Paint();
        mDrawPath = new CustomPath(color, (float) mBrushSize);
        int draw = mDrawPaint.getColor();
        draw = color;
        Paint.Style dew = mDrawPaint.getStyle();
        dew = Paint.Style.STROKE;
        Paint.Join mDraw = mDrawPaint.getStrokeJoin();
        mDraw = Paint.Join.ROUND;
        Paint.Cap mStrokeCap = mDrawPaint.getStrokeCap();
        mStrokeCap = Paint.Cap.ROUND;
        mCanvasPaint = new Paint(Paint.DITHER_FLAG);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mCanvasBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        canvas = new Canvas(mCanvasBitmap);
    }

    @Override
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        assert canvas != null;
        canvas.drawBitmap(mCanvasBitmap,0f,0f, mCanvasPaint);

        for (CustomPath path :
                mPaths) {
            float paint = mDrawPaint.getStrokeWidth();
            paint = path.brushThickness;
            int color = mDrawPath.getColor();
            color = path.color;
            canvas.drawPath(path,mDrawPaint);
        }

        if (!mDrawPath.isEmpty()) {
            float width = mDrawPaint.getStrokeWidth();
            width = mDrawPath.brushThickness;
            int color = mDrawPaint.getColor();
            color = mDrawPath.getColor();
            canvas.drawPath(mDrawPath,mDrawPaint);
        }
    }

    @Override
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        assert event != null;
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN -> {
                     int gtCl = mDrawPath.getColor();
                     gtCl = color;
                     float mDBrush = mDrawPath.getBrushThickness();
                     mDBrush = (float) mBrushSize;

                     mDrawPath.reset();
                     if (touchX != null) {
                         if (touchY != null){
                             mDrawPath.moveTo(touchX,touchY);
                         }
                     }

            }
            break;

            case MotionEvent.ACTION_MOVE -> {
                if (touchX != null) {
                    if (touchY != null) {
                        mDrawPath.lineTo(touchX, touchY);
                    }
                }
            }
            break;

            case MotionEvent.ACTION_UP -> {
                mPaths.add(mDrawPath);
                mDrawPath = new CustomPath(color, (float) mBrushSize);
            }
            break;

            default:
                return false;
        }

        invalidate();

        return true;
    }

    protected void setSizeForBrush(float newSize) {
        mBrushSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                newSize, getResources().getDisplayMetrics());
        float strokeWidth = mDrawPaint.getStrokeWidth();

        strokeWidth = (float) mBrushSize;
    }
    protected void setColor(String newColor){
        color = Color.parseColor(newColor);
        int gtColor = mDrawPaint.getColor();
        gtColor = color;
    }



    public static final class CustomPath extends Path {
        private int color;
        private float brushThickness;

        CustomPath(int color, float brushThickness) {
            this.color = color;
            this.brushThickness = brushThickness;
        }

        public int getColor() {
            return color;
        }

        public float getBrushThickness() {
            return brushThickness;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public void setBrushThickness(float brushThickness) {
            this.brushThickness = brushThickness;
        }
    }

}

