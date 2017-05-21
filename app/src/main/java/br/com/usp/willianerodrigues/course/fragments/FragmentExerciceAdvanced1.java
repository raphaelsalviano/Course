package br.com.usp.willianerodrigues.course.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import br.com.usp.willianerodrigues.course.CourseApplication;
import br.com.usp.willianerodrigues.course.R;
import br.com.usp.willianerodrigues.course.model.Usuario;

public class FragmentExerciceAdvanced1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercice_advanced_1, container, false);

        movimentarProgressBar(inflater, container);

        final Usuario usuario = ((CourseApplication) getActivity().getApplicationContext()).getUsuario();

        ((view.findViewById(R.id.exercice_advanced_1_o1))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Resposta Correta!")
                        .setMessage("Parabéns você aceitou!")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                usuario.setPontuacao(28);
                                ((CourseApplication) getActivity().getApplicationContext()).setUsuario(usuario);
                                getFragmentManager().beginTransaction().replace(R.id.container_exercice,
                                        new FragmentExerciceAdvanced2()).commit();
                            }
                        })
                        .create().show();
            }
        });

        ((view.findViewById(R.id.exercice_advanced_1_o2))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Resposta Incorreta!")
                        .setMessage("A resposta correta é a Dell ou Apple," +
                                "as duas empresas são empresas que vendem apenas hardware.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                usuario.setPontuacao(28);
                                ((CourseApplication) getActivity().getApplicationContext()).setUsuario(usuario);
                                getFragmentManager().beginTransaction().replace(R.id.container_exercice,
                                        new FragmentExerciceAdvanced2()).commit();
                            }
                        })
                        .create().show();
            }
        });

        ((view.findViewById(R.id.exercice_advanced_1_o3))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Resposta Correta!")
                        .setMessage("Parabéns você aceitou!")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                usuario.setPontuacao(28);
                                ((CourseApplication) getActivity().getApplicationContext()).setUsuario(usuario);
                                getFragmentManager().beginTransaction().replace(R.id.container_exercice,
                                        new FragmentExerciceAdvanced2()).commit();
                            }
                        })
                        .create().show();
            }
        });

        ((view.findViewById(R.id.exercice_advanced_1_o4))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Resposta Correta!")
                        .setMessage("A Dell e a Apple," +
                                "as duas empresas são empresas que vendem apenas hardware.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                usuario.setPontuacao(33);
                                ((CourseApplication) getActivity().getApplicationContext()).setUsuario(usuario);
                                getFragmentManager().beginTransaction().replace(R.id.container_exercice,
                                        new FragmentExerciceAdvanced2()).commit();
                            }
                        })
                        .create().show();
            }
        });

        ((view.findViewById(R.id.exercice_advanced_1_nao_sei))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Ops!")
                        .setMessage("A resposta correta é a Dell ou Apple," +
                                "as duas empresas são empresas que vendem apenas hardware.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                usuario.setPontuacao(30);
                                ((CourseApplication) getActivity().getApplicationContext()).setUsuario(usuario);
                                getFragmentManager().beginTransaction().replace(R.id.container_exercice,
                                        new FragmentExerciceAdvanced2()).commit();
                            }
                        })
                        .create().show();
            }
        });

        return view;
    }

    private void movimentarProgressBar(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.activity_exercice, container, false);

        ProgressBar bar = (ProgressBar) view.findViewById(R.id.progressBar_exercice);
        bar.setProgress(33);
    }
}
