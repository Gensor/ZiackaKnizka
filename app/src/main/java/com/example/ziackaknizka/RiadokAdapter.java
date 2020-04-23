package com.example.ziackaknizka;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class RiadokAdapter extends ArrayAdapter<StudentovPredmet> {
    Context context;
    ArrayList<StudentovPredmet> data = new ArrayList<StudentovPredmet>();
    ArrayAdapter<CharSequence> adapterSpiner;

    public RiadokAdapter(@NonNull Context context, ArrayList<StudentovPredmet> data) {
        super(context,R.layout.riadok,data);
        this.context=context;
        this.data=data;

    }

    @Override
    public  View getView(final int position, View convertView, ViewGroup parent){
        View riadok = convertView;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            riadok = inflater.inflate(R.layout.riadok,parent,false);
        }

        TextView label =  riadok.findViewById(R.id.riadok_textview_nazovPredmetu);
        final Spinner spinner =  riadok.findViewById(R.id.riadok_spinner_znamky);

        label.setText(data.get(position).getPredmet().getNazov());

        adapterSpiner= ArrayAdapter.createFromResource(parent.getContext(),R.array.znamky,android.R.layout.simple_spinner_item);
        adapterSpiner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpiner);

        spinner.setSelection(data.get(position).getHodnotenie().getZnamkaCislo());
        final int poziciaPredmetu = position;

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Znamka znamka = Znamka.valueOf(Znamka.getValue(position));
                data.get(poziciaPredmetu).setHodnotenie(znamka);
                adapterSpiner.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        return riadok;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }
}
