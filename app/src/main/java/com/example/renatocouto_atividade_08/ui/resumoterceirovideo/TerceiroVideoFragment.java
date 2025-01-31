package com.example.renatocouto_atividade_08.ui.resumoterceirovideo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.renatocouto_atividade_08.databinding.FragmentTerceiroVideoBinding;

public class TerceiroVideoFragment extends Fragment {

    private FragmentTerceiroVideoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TerceiroVideoViewModel terceiroVideoViewModel =
                new ViewModelProvider(this).get(TerceiroVideoViewModel.class);

        binding = FragmentTerceiroVideoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textSlideshow;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}