package br.udesc.ceplan.tep.exemplomvc;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.udesc.ceplan.tep.exemplomvc.model.Tarefa;

/**
 * Created by UKTech on 25/10/2016.
 */

public class TarefasAdapter extends ArrayAdapter<Tarefa> {

    private Map<Tarefa, Integer> mIdMap = new HashMap<>();

    public TarefasAdapter(Context context, int resource, List<Tarefa> objects) {
        super(context, resource, objects);

        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
        }
    }

    @Override
    public long getItemId(int position) {
        Tarefa item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }


}
