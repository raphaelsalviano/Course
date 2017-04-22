package br.com.usp.willianerodrigues.course.util;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by rapha on 16/04/2016.
 */
public class Bauhs93 extends AppCompatTextView {

     public Bauhs93 (Context context) {
          super(context);
          setTypeface(context);
     }

     public Bauhs93 (Context context, AttributeSet attrs) {
          super(context, attrs);
          setTypeface(context);
     }

     public Bauhs93 (Context context, AttributeSet attrs, int defStyleAttr) {
          super(context, attrs, defStyleAttr);
          setTypeface(context);
     }

     private void setTypeface (Context context) {
          setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/bauhs93.TTF"));
     }
}
