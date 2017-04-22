package br.com.usp.willianerodrigues.course.util;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by rapha on 16/04/2016.
 */
public class RobotoRegular extends AppCompatTextView {

     public RobotoRegular (Context context) {
          super(context);
          setTypeface(context);
     }

     public RobotoRegular (Context context, AttributeSet attrs) {
          super(context, attrs);
          setTypeface(context);
     }

     public RobotoRegular (Context context, AttributeSet attrs, int defStyleAttr) {
          super(context, attrs, defStyleAttr);
          setTypeface(context);
     }

     private void setTypeface (Context context) {
          setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/roboto_regular.ttf"));
     }
}
