package com.example.drawnavigationtest.ui.Toast;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawnavigationtest.R;

public class ToastFragment extends Fragment {

    //    private FragmentToastBinding binding;
    private Button buttonShow;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ToastViewModel toastViewModel =
                new ViewModelProvider(this).get(ToastViewModel.class);

        View view = inflater.inflate(R.layout.fragment_toast, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.buttonShow = (Button) view.findViewById(R.id.button_show);
        this.buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonShowClicked();
            }
        });
    }


    // Create Toast with "Resource Layout File".
    private void buttonShowClicked() {
        LayoutInflater inflater = this.getLayoutInflater();

        View layout = inflater.inflate(R.layout.layout_custom_toast, null);
        // TextView in layout_custom_toast.
        TextView textView = (TextView) layout.findViewById(R.id.textView);
        textView.setText("This is a message");
        textView.setTextColor(Color.BLUE);
        // Create Toast
        Toast toast = new Toast(getActivity().getBaseContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    // Create Toast without "Resource Layout File".
    private void buttonShowClicked2() {
        LinearLayout layout = new LinearLayout(getActivity().getBaseContext());
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setPadding(10, 10, 10, 10);
        //
        ImageView imageView = new ImageView(getActivity().getBaseContext());
        imageView.setImageResource(R.drawable.icon_info);
        imageView.setPadding(0, 0, 10, 0);
        //
        TextView textView = new TextView(getActivity().getBaseContext());
        textView.setTextColor(Color.BLUE);
        textView.setText("This is a message");

        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 0);
        layout.addView(imageView, params1);

        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        layout.addView(textView, params2);

        // Create Toast
        Toast toast = new Toast(getActivity().getBaseContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
