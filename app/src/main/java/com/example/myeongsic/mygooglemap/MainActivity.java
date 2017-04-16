package com.example.myeongsic.mygooglemap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //GoogleService.json 파일을 자신의 파일로 덮어 씌워야 함

        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        new Thread(){
            @Override
            public void run() {
                String Token = FirebaseInstanceId.getInstance().getToken();
                System.out.println(Token);

            }
        }.start();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        //홍대입구역에 마커 넣기
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.556694, 126.923712))
                .title("Marker"));
        googleMap.moveCamera(CameraUpdateFactory.
                newLatLngZoom(new LatLng(37.556694, 126.923712), 10));

    }

}