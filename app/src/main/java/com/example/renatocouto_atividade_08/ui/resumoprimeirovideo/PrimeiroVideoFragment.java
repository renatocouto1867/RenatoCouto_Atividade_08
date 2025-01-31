package com.example.renatocouto_atividade_08.ui.resumoprimeirovideo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.renatocouto_atividade_08.databinding.FragmentPrimeiroVideoBinding;

public class PrimeiroVideoFragment extends Fragment {

    private FragmentPrimeiroVideoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PrimeiroVideoViewModel galleryViewModel =
                new ViewModelProvider(this).get(PrimeiroVideoViewModel.class);

        binding = FragmentPrimeiroVideoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}