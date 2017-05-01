package br.com.usp.willianerodrigues.course.fragments;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
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

public class FragmentUserAdvancedWill extends Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_user_advanced_will, container, false);

        if (getActivity().getActionBar() != null) {
            getActivity().getActionBar().hide();
        }

        ImageView mWill = (ImageView) view.findViewById(R.id.img_will_advanced);
        mWill.setBackground(getResources().getDrawable(R.drawable.will_assistants_animation));
        final AnimationDrawable animation = (AnimationDrawable) mWill.getBackground();
        animation.start();

        final TextView mText1 = (TextView) view.findViewById(R.id.will_talk_question_advanced);
        YoYo.with(Techniques.FadeIn).duration(1000).playOn(mText1);

        (view.findViewById(R.id.btn_cancel_advance)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                getFragmentManager().beginTransaction().
                        replace(R.id.content_initial_exercice, new FragmentPresentAssitVirtual()).commit();
            }
        });

        (view.findViewById(R.id.btn_next_advance)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(getActivity(), ExerciceActivity.class);
                intent.putExtra("exercice","advanced");
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }

}
