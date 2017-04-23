package br.com.usp.willianerodrigues.course.fragments;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import br.com.usp.willianerodrigues.course.R;
import br.com.usp.willianerodrigues.course.activity.ExerciceActivity;

public class FragmentPresentAssitVirtual extends Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_present_asst_virtual, container, false);

        final ImageView mWill = (ImageView) view.findViewById(R.id.will_virtual_present);
        mWill.setBackground(getResources().getDrawable(R.drawable.will_assistants_animation));
        final AnimationDrawable animation = (AnimationDrawable) mWill.getBackground();
        animation.start();

        final TextView mText1 = (TextView) view.findViewById(R.id.will_talk_question_home);
        YoYo.with(Techniques.FadeIn).duration(1000).playOn(mText1);
        mText1.setText(R.string.will_start_frase);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run () {
                YoYo.with(Techniques.BounceInUp).duration(500).playOn(mWill);

                TextView mText2 = (TextView) view.findViewById(R.id.will_talk_question_home2);
                YoYo.with(Techniques.FadeIn).duration(500).playOn(mText2);
                mText2.setText(R.string.will_question_one);
                mText1.setVisibility(View.GONE);
                mText2.setVisibility(View.VISIBLE);

                View v = view.findViewById(R.id.initial_container_button_question_pc);
                v.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.FadeInUp).duration(100).playOn(v);
            }
        }, 3000);

        (view.findViewById(R.id.btn_sou_iniciante)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(getActivity(), ExerciceActivity.class);
                intent.putExtra("exercice","apresentacao");
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        (view.findViewById(R.id.btn_ja_tem_conhecimento)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                getFragmentManager().beginTransaction().
                        replace(R.id.content_initial_exercice, new FragmentUserAdvancedWill()).commit();
            }
        });

        return view;
    }

}
