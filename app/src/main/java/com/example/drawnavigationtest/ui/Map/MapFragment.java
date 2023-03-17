package com.example.drawnavigationtest.ui.Map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawnavigationtest.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback,View.OnClickListener {

    private GoogleMap mMap;
    LatLng loc;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MapViewModel mapViewModel =
                new ViewModelProvider(this).get(MapViewModel.class);


        View view = inflater.inflate(R.layout.fragment_map, container, false);

        Button btnSeoul = view.findViewById(R.id.btnSeoul);
        Button btnInchon = view.findViewById(R.id.btnInchon);
        Button btnBusan = view.findViewById(R.id.btnBusan);
        Button btnJeju = view.findViewById(R.id.btnJeju);


        btnSeoul.setOnClickListener(this);
        btnInchon.setOnClickListener(this);
        btnBusan.setOnClickListener(this);
        btnJeju.setOnClickListener(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        loc = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(loc).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));

    }

    @Override
    public void onClick(View view) {
        String title=null;
        int id=view.getId();

        switch(id){
            case R.id.btnSeoul:
                loc=new LatLng(37.548439, 126.985386);
                title="서울";
                break;
            case R.id.btnInchon:
                loc=new LatLng(37.457927, 126.708671);
                title="인천";
                break;
            case R.id.btnBusan:
                loc=new LatLng(35.164931, 129.058056);
                title="부산";
                break;
            case R.id.btnJeju:
                loc=new LatLng(33.386824, 126.561856);
                title="제주";
                break;
        }
        /*
        LatLng SEOUL = new LatLng(37.56, 126.97);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("한국의 수도");
        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
        //*/
        mMap.animateCamera(CameraUpdateFactory.zoomTo(2));
        mMap.addMarker(new MarkerOptions().position(loc).title(title));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
}
