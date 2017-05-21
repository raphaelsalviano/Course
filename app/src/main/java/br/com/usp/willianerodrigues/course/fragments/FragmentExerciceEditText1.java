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

public class FragmentExerciceEditText1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercice_editores_text_1, container, false);

        movimentarProgressBar(inflater, container);

        ((view.findViewById(R.id.exercice_advanced_1_o1))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Resposta Correta!")
                        .setMessage("Você acertou! Parabéns!")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    ((CourseApplication) getActivity().getApplicationContext()).inserirPontuacaoUser(33);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                getFragmentManager().beginTransaction().replace(R.id.container_exercice,
                                        new FragmentExerciceEditText2()).commit();
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
                        .setView(R.layout.exercice_edit_text_dialog_correct)
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    ((CourseApplication) getActivity().getApplicationContext()).inserirPontuacaoUser(28);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                getFragmentManager().beginTransaction().replace(R.id.container_exercice,
                                        new FragmentExerciceEditText2()).commit();
                            }
                        })
                        .create().show();
            }
        });

        ((view.findViewById(R.id.exercice_advanced_1_o3))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Resposta Incorreta!")
                        .setView(R.layout.exercice_edit_text_dialog_correct)
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    ((CourseApplication) getActivity().getApplicationContext()).inserirPontuacaoUser(28);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                getFragmentManager().beginTransaction().replace(R.id.container_exercice,
                                        new FragmentExerciceEditText2()).commit();
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
                        .setView(R.layout.exercice_edit_text_dialog_correct)
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    ((CourseApplication) getActivity().getApplicationContext()).inserirPontuacaoUser(28);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                getFragmentManager().beginTransaction().replace(R.id.container_exercice,
                                        new FragmentExerciceEditText2()).commit();
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
                        .setView(R.layout.exercice_edit_text_dialog_correct)
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    ((CourseApplication) getActivity().getApplicationContext()).inserirPontuacaoUser(30);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                getFragmentManager().beginTransaction().replace(R.id.container_exercice,
                                        new FragmentExerciceEditText2()).commit();
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
