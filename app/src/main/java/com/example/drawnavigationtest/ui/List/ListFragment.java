package com.example.drawnavigationtest.ui.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawnavigationtest.R;

public class ListFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        ListViewModel listViewModel =
                new ViewModelProvider(this).get(ListViewModel.class);

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    ListView list;
    String[] titles = {
            "The Wizard of Oz (1939)",
            "Citizen Kane (1941)",
            "All About Eve (1950)",
            "The Third Man (1949)",
            "A Hard Day's Night (1964)",
            "Modern Times (1936)",
            "Metropolis (1927)",
            "Metropolis (1927)",
            "Metropolis (1927)",
            "Metropolis (1927)"
    } ;
    String[] releaseYear = {
            "1939",
            "1941",
            "1950",
            "1949",
            "1964",
            "1936",
            "1927",
            "1927",
            "1927",
            "1927"
    } ;
    String[] genre1 = {
            "fantasy",
            "Drama",
            "Drama",
            "noir",
            "musical",
            "Drama",
            "Movie",
            "Movie",
            "Movie",
            "Movie"
    } ;
    Integer[] images = {
            R.drawable.movie1,
            R.drawable.movie2,
            R.drawable.movie3,
            R.drawable.movie4,
            R.drawable.movie5,
            R.drawable.movie6,
            R.drawable.movie7,
            R.drawable.movie7,
            R.drawable.movie7,
            R.drawable.movie7
    };
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CustomList adapter = new CustomList(getActivity());

        ListView list = view.findViewById(R.id.lstView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity().getBaseContext(), titles[+position], Toast.LENGTH_SHORT).show();
            }
        });

    }
    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        public CustomList(Activity context) {
            super(context, R.layout.listitem, titles);
            this.context = context;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView= inflater.inflate(R.layout.listitem, null, true);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
            TextView title = (TextView) rowView.findViewById(R.id.title);
            TextView rating = (TextView) rowView.findViewById(R.id.rating);
            TextView genre = (TextView) rowView.findViewById(R.id.genre);
            TextView year = (TextView) rowView.findViewById(R.id.releaseYear);

            title.setText(titles[position]);
            imageView.setImageResource(images[position]);
            rating.setText("9.0"+position);
            genre.setText(genre1[position]);
            year.setText(releaseYear[position]);
            return rowView;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}