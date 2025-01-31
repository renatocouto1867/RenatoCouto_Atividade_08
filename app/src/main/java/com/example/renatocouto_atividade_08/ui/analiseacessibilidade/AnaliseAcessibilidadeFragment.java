package com.example.renatocouto_atividade_08.ui.analiseacessibilidade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.renatocouto_atividade_08.R;
import com.example.renatocouto_atividade_08.databinding.FragmentAnaliseAcessibilidadeBinding;

public class AnaliseAcessibilidadeFragment extends Fragment {

    private FragmentAnaliseAcessibilidadeBinding binding;
    private int idNavegacao = 0;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AnaliseAcessibilidadeViewModel analiseAcessibilidadeViewModel =
                new ViewModelProvider(this).get(AnaliseAcessibilidadeViewModel.class);

        binding = FragmentAnaliseAcessibilidadeBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        configuraClick();
        navegaTelas(0);

        return root;
    }

    private void configuraClick() {
        binding.buttonAnalise.setOnClickListener(view -> {
            binding.analisePrincipal.setVisibility(View.GONE);
            binding.analiseSecundario.setVisibility(View.VISIBLE);
        });
        binding.buttonVoltar.setOnClickListener(view -> {
            binding.analisePrincipal.setVisibility(View.VISIBLE);
            binding.analiseSecundario.setVisibility(View.GONE);
        });
        binding.buttonProximo.setOnClickListener(view -> {
            if (idNavegacao < 4) {
                idNavegacao++;
                navegaTelas(idNavegacao);
            } else
                Toast.makeText(requireActivity(), "Essa é a ultima tela", Toast.LENGTH_SHORT).show();
        });

        binding.buttonAnterior.setOnClickListener(view -> {
            if (idNavegacao > 0) {
                idNavegacao--;
                navegaTelas(idNavegacao);
            } else
                Toast.makeText(requireActivity(), "Essa é a primeira tela", Toast.LENGTH_SHORT).show();
        });

    }

    private void navegaTelas(int id) {
        if (id == 0) {
            binding.imageViewResultado.setImageDrawable(requireActivity().getDrawable(R.drawable.screen1));
            binding.textResultado.setText(requireActivity().getResources().getStringArray(R.array.texto_analise)[0]);
        }
        if (id == 1) {
            binding.imageViewResultado.setImageDrawable(requireActivity().getDrawable(R.drawable.screen2));
            binding.textResultado.setText(requireActivity().getResources().getStringArray(R.array.texto_analise)[1]);
        }
        if (id == 2) {
            binding.imageViewResultado.setImageDrawable(requireActivity().getDrawable(R.drawable.screen3));
            binding.textResultado.setText(requireActivity().getResources().getStringArray(R.array.texto_analise)[2]);
        }
        if (id == 3) {
            binding.imageViewResultado.setImageDrawable(requireActivity().getDrawable(R.drawable.screen4));
            binding.textResultado.setText(requireActivity().getResources().getStringArray(R.array.texto_analise)[3]);
        }
        if (id == 4) {
            binding.imageViewResultado.setImageDrawable(requireActivity().getDrawable(R.drawable.screen5));
            binding.textResultado.setText(requireActivity().getResources().getStringArray(R.array.texto_analise)[4]);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}