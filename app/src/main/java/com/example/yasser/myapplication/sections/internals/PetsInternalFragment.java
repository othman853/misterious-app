package com.example.yasser.myapplication.sections.internals;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yasser.myapplication.R;
import com.example.yasser.myapplication.data.Pet;

import org.w3c.dom.Text;

/**
 * Created by yasser on 10/29/15.
 */
public class PetsInternalFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pets_internal, container, false);

        Pet pet = (Pet) getArguments().getSerializable("pet");

        int id = getResources().getIdentifier(pet.getPictureId(), "drawable", getActivity().getPackageName());
        ImageView petImage = (ImageView) view.findViewById(R.id.pet_image);
        petImage.setImageResource(id);

        TextView petName = (TextView) view.findViewById(R.id.pet_name);
        TextView petHabitat = (TextView) view.findViewById(R.id.pet_habitat);
        TextView petEatingHabits = (TextView) view.findViewById(R.id.pet_eating_habits);
        TextView petHabits = (TextView) view.findViewById(R.id.pet_habits);

        petName.setText(pet.getName());
        petHabitat.setText(pet.getNaturalHabitat());
        petEatingHabits.setText(pet.getEatingHabits());
        petHabits.setText(pet.getDescription());

        return view;
    }
}
