package com.example.renatocouto_atividade_08.ui.resumoprimeirovideo;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.renatocouto_atividade_08.R;
import com.example.renatocouto_atividade_08.databinding.FragmentPrimeiroVideoBinding;

import java.util.Locale;

public class PrimeiroVideoFragment extends Fragment {

    private FragmentPrimeiroVideoBinding binding;
    private TextToSpeech textToSpeech;
    private String msg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        PrimeiroVideoViewModel primeiroVideoViewModel =
                new ViewModelProvider(this).get(PrimeiroVideoViewModel.class);

        binding = FragmentPrimeiroVideoBinding.inflate(inflater, container, false);
        msg = getResources().getString(R.string.resumo_video_1);

        inicializarTextToSpeech();

        binding.buttonLer.setOnClickListener(view -> lerResumo());

        return binding.getRoot();
    }

    private void inicializarTextToSpeech() {
        textToSpeech = new TextToSpeech(requireContext(), status -> {
            if (status == TextToSpeech.SUCCESS) {
                Locale locale = new Locale("pt", "BR");
                int result = textToSpeech.setLanguage(locale);
                textToSpeech.setSpeechRate(1.2f);
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TextToSpeech", "Idioma não suportado");
                }
            } else {
                Log.e("TextToSpeech", "Falha na inicialização");
            }
        });
    }

    private void lerResumo() {
        if (textToSpeech != null && !textToSpeech.isSpeaking()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                textToSpeech.speak(msg, TextToSpeech.QUEUE_FLUSH, null, null);
            } else {
                textToSpeech.speak(msg, TextToSpeech.QUEUE_FLUSH, null);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        binding = null;
    }
}
