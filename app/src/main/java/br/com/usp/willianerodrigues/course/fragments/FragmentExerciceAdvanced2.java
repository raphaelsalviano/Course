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

public class FragmentExerciceAdvanced2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercice_advanced_2, container, false);

        movimentarProgressBar(inflater);

        ((view.findViewById(R.id.exercice_advanced_2_o1))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Resposta Incorreta!")
                        .setMessage("A resposta correra é o Editor de Registros," +
                                "é um programa interno onde guarda as opções e configurações reservadas do sistema.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((CourseApplication) getActivity().getApplicationContext()).calcularPontuacao(30);
                                Log.i("TAG", "" + ((CourseApplication) getActivity().getApplicationContext()).getPontuacao());
                                getFragmentManager().beginTransaction().replace(R.id.container_exercice,
                                        new FragmentExerciceAdvanced3()).commit();
                            }
                        })
                        .create().show();
            }
        });

        ((view.findViewById(R.id.exercice_advanced_2_o2))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Resposta Correta!")
                        .setMessage("A resposta correra é o Editor de Registros," +
                                "é um programa interno onde guarda as opções e configurações reservadas do sistema.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((CourseApplication) getActivity().getApplicationContext()).calcularPontuacao(30);
                                Log.i("TAG", "" + ((CourseApplication) getActivity().getApplicationContext()).getPontuacao());
                                getFragmentManager().beginTransaction().replace(R.id.container_exercice,
                                        new FragmentExerciceAdvanced3()).commit();
                            }
                        })
                        .create().show();
            }
        });

        ((view.findViewById(R.id.exercice_advanced_2_o3))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Resposta Incorreta!")
                        .setMessage("A resposta correra é o Editor de Registros," +
                                "é um programa interno onde guarda as opções e configurações reservadas do sistema.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((CourseApplication) getActivity().getApplicationContext()).calcularPontuacao(30);
                                Log.i("TAG", "" + ((CourseApplication) getActivity().getApplicationContext()).getPontuacao());
                                getFragmentManager().beginTransaction().replace(R.id.container_exercice,
                                        new FragmentExerciceAdvanced3()).commit();
                            }
                        })
                        .create().show();
            }
        });

        ((view.findViewById(R.id.exercice_advanced_2_o4))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Resposta Incorreta!")
                        .setMessage("A resposta correra é o Editor de Registros," +
                                "é um programa interno onde guarda as opções e configurações reservadas do sistema.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((CourseApplication) getActivity().getApplicationContext()).calcularPontuacao(30);
                                Log.i("TAG", "" + ((CourseApplication) getActivity().getApplicationContext()).getPontuacao());
                                getFragmentManager().beginTransaction().replace(R.id.container_exercice,
                                        new FragmentExerciceAdvanced3()).commit();
                            }
                        })
                        .create().show();
            }
        });

        ((view.findViewById(R.id.exercice_advanced_2_nao_sei))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Ops!")
                        .setMessage("A resposta correra é o Editor de Registros," +
                                "é um programa interno onde guarda as opções e configurações reservadas do sistema.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((CourseApplication) getActivity().getApplicationContext()).calcularPontuacao(30);
                                Log.i("TAG", "" + ((CourseApplication) getActivity().getApplicationContext()).getPontuacao());
                                getFragmentManager().beginTransaction().replace(R.id.container_exercice,
                                        new FragmentExerciceAdvanced3()).commit();
                            }
                        })
                        .create().show();
            }
        });

        return view;
    }

    private void movimentarProgressBar(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.activity_exercice, null, false);

        ProgressBar bar = (ProgressBar) view.findViewById(R.id.progressBar_exercice);
        bar.setProgress(33);
    }
}
