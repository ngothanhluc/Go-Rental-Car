package com.company.go.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.go.Models.Car;
import com.company.go.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Card#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Card extends Fragment {
    private Car car;

    public Card() {
        // Required empty public constructor
    }

    public static Card newInstance(Car car) {
        Card fragment = new Card();
        Bundle args = new Bundle();
        args.putSerializable("car", (Serializable) car);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            car = (Car) getArguments().getSerializable("car");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_card, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView address = view.findViewById(R.id.address);
        TextView model = view.findViewById(R.id.model);
        TextView brand = view.findViewById(R.id.brand);
        TextView price = view.findViewById(R.id.price);
        TextView type = view.findViewById(R.id.type);
        TextView capacity = view.findViewById(R.id.capacity);
        TextView fuelType = view.findViewById(R.id.fuel_type);
        ImageView imageView = view.findViewById(R.id.carImage);

        address.setText("Ho Chi Minh");
        price.setText(car.getPriceFormat());
        type.setText(car.getInformation().get("type").toString());
        model.setText(car.getInformation().get("model").toString());
        brand.setText( car.getInformation().get("brand").toString());
        capacity.setText( car.getInformation().get("capacity").toString() + " Seats");
        fuelType.setText( car.getInformation().get("fuel_type").toString());
        Picasso.get().load(car.getAvatar()).resize(200, 100).into(imageView);
    }
}