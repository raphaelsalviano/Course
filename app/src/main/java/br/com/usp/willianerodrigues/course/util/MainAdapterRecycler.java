package br.com.usp.willianerodrigues.course.util;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.List;

import br.com.usp.willianerodrigues.course.CourseApplication;
import br.com.usp.willianerodrigues.course.R;
import br.com.usp.willianerodrigues.course.activity.ExerciceActivity;
import br.com.usp.willianerodrigues.course.model.ItemMenu;

public class MainAdapterRecycler extends RecyclerView.Adapter<MainAdapterRecycler.MainAdapterViewHolder> {

     private Context context;
     private LayoutInflater inflater;
     private List<ItemMenu> itemMenus;

     public MainAdapterRecycler (Context context) {
          this.context = context;
          inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          CourseApplication application = (CourseApplication) context.getApplicationContext();
          try {
               itemMenus = application.getItensUsuario(application.getUserActive());
          } catch (SQLException e) {
               e.printStackTrace();
          }
     }

     @Override
     public MainAdapterViewHolder onCreateViewHolder (ViewGroup viewGroup, int i) {
          View view = inflater.inflate(R.layout.item_menu_recycler, viewGroup, false);
          return new MainAdapterViewHolder(view);
     }

     @Override
     public void onBindViewHolder (MainAdapterViewHolder holder, int i) {
          final ItemMenu itemMenu = itemMenus.get(i);
          holder.mTextButton.setText(itemMenu.getName());

          if (itemMenu.isDisable()) {
               holder.mViewClick.setBackground(context.getResources().getDrawable(R.drawable.border_button_grey));
               holder.mImageButton.setImageDrawable(context.getResources().getDrawable(itemMenu.getDrawableDisableId()));
               holder.mTextButton.setTextColor(context.getResources().getColor(R.color.md_grey_500));
          } else {
              holder.mViewClick.setBackground(context.getResources().getDrawable(R.drawable.border_button_purple));
               holder.mImageButton.setImageDrawable(context.getResources().getDrawable(itemMenu.getDrawableEnableId()));
               holder.mTextButton.setTextColor(context.getResources().getColor(R.color.md_purple_500));
          }

          holder.mViewClick.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick (View v) {
                    if (!itemMenu.isDisable()) {
                         Intent intent = new Intent(context, ExerciceActivity.class);
                         intent.putExtra("item", itemMenu.getName());
                         intent.putExtra("exercice","main" );
                         context.startActivity(intent);
                    }
               }
          });
     }

     @Override
     public int getItemCount () {
          return itemMenus.size();
     }

     class MainAdapterViewHolder extends RecyclerView.ViewHolder {

          private LinearLayout mViewClick;
          private ImageView mImageButton;
          private TextView mTextButton;

          MainAdapterViewHolder (View itemView) {
               super(itemView);

               mViewClick = (LinearLayout) itemView.findViewById(R.id.item_menu_main);
               mImageButton = (ImageView) itemView.findViewById(R.id.ico_item_main);
               mTextButton = (TextView) itemView.findViewById(R.id.item_name_main);
          }
     }
}
