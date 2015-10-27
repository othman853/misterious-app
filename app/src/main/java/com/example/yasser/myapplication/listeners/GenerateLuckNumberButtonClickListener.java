package com.example.yasser.myapplication.listeners;

import android.view.View;
import android.widget.TextView;

import com.example.yasser.myapplication.R;
import com.example.yasser.myapplication.data.LuckNumber;
import com.example.yasser.myapplication.util.Animations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/**
 * Created by yasser on 14/09/15.
 */
public class GenerateLuckNumberButtonClickListener implements View.OnClickListener {

    private List<LuckNumber> numbers;
    private View context;
    private Random generator;

    public GenerateLuckNumberButtonClickListener(View context) {
        this.context = context;
        this.numbers = findNumbers();

        generator = new Random();

    }

    @Override
    public void onClick(View v) {
        TextView displayNumber = (TextView) context.findViewById(R.id.luck_number_text_view);
        TextView displayDescription = (TextView) context.findViewById(R.id.luck_number_description);

        LuckNumber number = generate();

        displayDescription.setText(number.getDescription());
        displayNumber.setText(number.getValue());

        Animations.fadeOut(displayDescription);
        Animations.fadeIn(displayDescription);

        Animations.fadeOut(displayNumber, 200);
        Animations.fadeIn(displayNumber, 200);
    }

    private LuckNumber generate(){
        int randomIndex = generator.nextInt(numbers.size());
        return  numbers.get(randomIndex);
    }

    private List<LuckNumber> findNumbers (){
        String [] serializedNumbers = context.getResources().getStringArray(R.array.luck_numbers);
        List<LuckNumber> numbers = new ArrayList<>();

        for(String serializedNumber : serializedNumbers){
            LuckNumber number = new LuckNumber();
            number.deserialize(serializedNumber);

            numbers.add(number);
        }

        return numbers;
    }
}