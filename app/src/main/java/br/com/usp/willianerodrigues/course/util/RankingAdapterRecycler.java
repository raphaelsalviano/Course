package br.com.usp.willianerodrigues.course.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.List;

import br.com.usp.willianerodrigues.course.CourseApplication;
import br.com.usp.willianerodrigues.course.R;
import br.com.usp.willianerodrigues.course.model.ItemMenu;
import br.com.usp.willianerodrigues.course.model.Usuario;

public class RankingAdapterRecycler extends RecyclerView.Adapter<RankingAdapterRecycler.RankingViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<ItemMenu> itemMenus;

    public RankingAdapterRecycler(Context context) {
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
    public RankingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_ranking_recycler, parent, false);
        return new RankingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RankingViewHolder holder, int position) {
        ItemMenu itemMenu = itemMenus.get(position);

        holder.mImage.setImageDrawable(context.getResources().getDrawable(itemMenu.getDrawableEnableId()));
        holder.mName.setText(itemMenu.getName());
        holder.mPontuacao.setText(itemMenu.getPontuacao() + " pontos");
    }

    @Override
    public int getItemCount() {
        return itemMenus.size();
    }

    class RankingViewHolder extends RecyclerView.ViewHolder {

        private TextView mName;
        private TextView mPontuacao;
        private ImageView mImage;

        RankingViewHolder(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.item_name_ranking);
            mPontuacao = (TextView) itemView.findViewById(R.id.item_pontuacao_ranking);
            mImage = (ImageView) itemView.findViewById(R.id.ico_item_ranking);
        }
    }

}
