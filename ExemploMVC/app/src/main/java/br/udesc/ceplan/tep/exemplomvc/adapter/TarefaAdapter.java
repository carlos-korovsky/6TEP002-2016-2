package br.udesc.ceplan.tep.exemplomvc.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.udesc.ceplan.tep.exemplomvc.model.Tarefa;

/**
 * Created by UKTech on 25/10/2016.
 */

public class TarefaAdapter extends ArrayAdapter<Tarefa> {

    public TarefaAdapter(Context context, List<Tarefa> objects) {
        super(context, android.R.layout.simple_list_item_2, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        Tarefa tarefa = this.getItem(position);

        TextView text1 = (TextView) view.findViewById(android.R.id.text1);
        TextView text2 = (TextView) view.findViewById(android.R.id.text2);

        text1.setText(tarefa.getName());
        text2.setText(tarefa.getDescription());

        return view;
    }
}
