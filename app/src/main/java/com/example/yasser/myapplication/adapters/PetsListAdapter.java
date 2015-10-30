package com.example.yasser.myapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.yasser.myapplication.R;
import com.example.yasser.myapplication.data.Pet;
import com.example.yasser.myapplication.data.Poetry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yasser on 10/28/15.
 */
public class PetsListAdapter extends BaseAdapter {

    private final Activity activity;
    private List<Pet> pets;
    private LayoutInflater inflater;
    private TextView petName;
    private ImageView petPicture;
    private View view;

    public PetsListAdapter(Activity activity) {
        this.activity = activity;
        pets = new ArrayList<>();

        String [] serializedPets = activity.getResources().getStringArray(R.array.pets);

        for (String serializedPet : serializedPets) {
            pets.add(new Pet().deserialize(serializedPet));
        }

    }

    @Override
    public int getCount() {
        return pets.size();
    }

    @Override
    public Object getItem(int position) {
        return pets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView == null){
            convertView = inflater.inflate(R.layout.pets_list_item, null);
        }

        view = convertView;

        Pet pet = pets.get(position);

        int id = convertView.getResources().getIdentifier(pet.getPictureId(), "drawable", activity.getPackageName());

        petName = (TextView) convertView.findViewById(R.id.pet_name);
        petPicture = (ImageView) convertView.findViewById(R.id.pet_picture);

        new LoadItemsAsync().execute(id);

        petName.setText(pet.getName());

        return convertView;
    }

    private class LoadItemsAsync extends AsyncTask<Integer , Integer, Integer> {


        @Override
        protected Integer doInBackground(Integer...id) {
            return id[0];
        }

        @Override
        protected void onPostExecute(Integer imageId) {
            super.onPostExecute(imageId);

            petPicture.setImageResource(imageId);
        }
    }
}
