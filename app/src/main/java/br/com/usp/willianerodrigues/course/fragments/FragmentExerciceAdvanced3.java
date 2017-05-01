package br.com.usp.willianerodrigues.course.fragments;

import android.content.DialogInterface;
import android.content.Intent;
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
import br.com.usp.willianerodrigues.course.activity.FinishExerciceActivity;

public class FragmentExerciceAdvanced3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercice_advanced_3, container, false);

        movimentarProgressBar(inflater);

        ((view.findViewById(R.id.exercice_advanced_3_o1))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Resposta Incorreta!")
                        .setMessage("A resposta correta é o Wordpad.\n" +
                                "Trata-se de uma aplicação de processamento de texto que apresenta apenas as ferramentas básicas de formatação de texto. Nas versões fornecidas com os Windows 95, 98 e ME, o WordPad permite abrir e guardar ficheiros nos formatos.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((CourseApplication) getActivity().getApplicationContext()).calcularPontuacao(30);
                                Log.i("TAG", "" + ((CourseApplication) getActivity().getApplicationContext()).getPontuacao());
                                Intent intent = new Intent(getActivity(), FinishExerciceActivity.class);
                                getActivity().startActivity(intent);
                                getActivity().finish();
                            }
                        })
                        .create().show();
            }
        });

        ((view.findViewById(R.id.exercice_advanced_3_o2))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Resposta Correta!")
                        .setMessage("A resposta correta é o Wordpad.\n" +
                                "Trata-se de uma aplicação de processamento de texto que apresenta apenas as ferramentas básicas de formatação de texto. Nas versões fornecidas com os Windows 95, 98 e ME, o WordPad permite abrir e guardar ficheiros nos formatos.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((CourseApplication) getActivity().getApplicationContext()).calcularPontuacao(30);
                                Log.i("TAG", "" + ((CourseApplication) getActivity().getApplicationContext()).getPontuacao());
                                Intent intent = new Intent(getActivity(), FinishExerciceActivity.class);
                                getActivity().startActivity(intent);
                                getActivity().finish();
                            }
                        })
                        .create().show();
            }
        });

        ((view.findViewById(R.id.exercice_advanced_3_nao_sei))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Ops!")
                        .setMessage("Parece que você não sabe a resposta! Então vamos lá, a resposta correta é Wordpad." +
                                "Trata-se de uma aplicação de processamento de texto que apresenta apenas as ferramentas básicas de formatação de texto. Nas versões fornecidas com os Windows 95, 98 e ME, o WordPad permite abrir e guardar ficheiros nos formatos.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((CourseApplication) getActivity().getApplicationContext()).calcularPontuacao(30);
                                Log.i("TAG", "" + ((CourseApplication) getActivity().getApplicationContext()).getPontuacao());
                                Intent intent = new Intent(getActivity(), FinishExerciceActivity.class);
                                getActivity().startActivity(intent);
                                getActivity().finish();
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
