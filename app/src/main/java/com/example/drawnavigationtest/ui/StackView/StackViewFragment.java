package com.example.drawnavigationtest.ui.StackView;

import android.os.Bundle;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.StackView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawnavigationtest.R;

import java.util.ArrayList;
import java.util.List;

//import com.example.navigationtest.databinding.FragmentSlideshowBinding;


public class StackViewFragment extends Fragment {

    private static final String[] IMAGE_NAMES = {"image1","image2", "image3", "image4","image5"};

//    private FragmentSlideshowBinding binding;

    private StackView stackView;
    private Button buttonPrevious;
    private Button buttonNext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StackViewModel slideshowViewModel =
                new ViewModelProvider(this).get(StackViewModel.class);

//        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textSlideshow;
//        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
        View view = inflater.inflate(R.layout.fragment_stackview, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.stackView = (StackView) view.findViewById(R.id.stackView);
        this.buttonNext =(Button) view.findViewById(R.id.button_next);
        this.buttonPrevious= (Button) view.findViewById(R.id.button_previous);

        List<StackItem> items = new ArrayList<StackItem>();

        for(String imageName: IMAGE_NAMES) {
            items.add(new StackItem(imageName+".png", imageName));
        }

        StackAdapter adapt = new StackAdapter(getContext(), R.layout.stack_item, items);
        stackView.setAdapter(adapt);
        stackView.setHorizontalScrollBarEnabled(true);
        stackView.setBackgroundColor(Color.rgb(230, 255, 255));

        buttonNext.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                stackView.showNext();
            }
        });

        buttonPrevious.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                stackView.showPrevious();
            }
        });
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
}