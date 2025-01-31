package com.example.renatocouto_atividade_08.ui.resumoterceirovideo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.renatocouto_atividade_08.R;
import com.example.renatocouto_atividade_08.databinding.FragmentTerceiroVideoBinding;

public class TerceiroVideoFragment extends Fragment {

    private FragmentTerceiroVideoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TerceiroVideoViewModel terceiroVideoViewModel =
                new ViewModelProvider(this).get(TerceiroVideoViewModel.class);

        binding = FragmentTerceiroVideoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonEnviar.setOnClickListener(view -> clicar());


        return root;
    }

    public void clicar() {
        Intent intent = null;
        String text = getResources().getString(R.string.resumo_video_3);

        if (verficaApp()) {
            intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, text);
            intent.setType("text/plain");
            intent.setPackage("com.whatsapp");
            startActivity(intent);
        } else {
            abrirWhatsAppWeb();
        }


    }

    private void abrirWhatsAppWeb() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.whatsapp.com/"));
        startActivity(intent);
    }

    private boolean verficaApp() {
        try {
            requireActivity().getPackageManager().getPackageInfo("com.whatsApp", PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}