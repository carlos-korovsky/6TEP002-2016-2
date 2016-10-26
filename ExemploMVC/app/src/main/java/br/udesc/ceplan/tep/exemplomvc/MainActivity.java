package br.udesc.ceplan.tep.exemplomvc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.udesc.ceplan.tep.exemplomvc.adapter.TarefaAdapter;
import br.udesc.ceplan.tep.exemplomvc.dao.DaoFactory;
import br.udesc.ceplan.tep.exemplomvc.model.Tarefa;

public class MainActivity extends AppCompatActivity {

    public static final String APP_TAG = "br.udesc.ceplan.tep.mvc";

    private ListView lvTarefa;
    private Button btNovaTarefa;
    private EditText etNovaTarefa;
    private ApplicationController aController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.aController = (ApplicationController) getApplicationContext();

        this.lvTarefa = (ListView) this.findViewById(R.id.lvTarefa);
        this.btNovaTarefa = (Button) this.findViewById(R.id.btNovaTarefa);
        this.etNovaTarefa = (EditText)
                this.findViewById(R.id.etNovaTarefa);

        this.btNovaTarefa.setOnClickListener(this.handleNovaTarefaEvent);

        this.populaTarefas();
    }

    private void populaTarefas() {
        DaoFactory database = this.aController.getDaoFactorySQLite();
        final List<Tarefa> tarefas = database.getTarefaDao().findAll();

        Log.d(MainActivity.APP_TAG, String.format("%d tarefas encontradas ",
                tarefas.size()));

        this.lvTarefa.setAdapter( new TarefaAdapter(this, tarefas) );

        this.lvTarefa.setOnItemClickListener(this.handleListOnItemClick);
    }

    private final View.OnClickListener handleNovaTarefaEvent =
        new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Log.d(MainActivity.APP_TAG, "botão nova tarefa acionado");
                MainActivity.this.populaTarefas();
            }
        };

    private final AdapterView.OnItemClickListener handleListOnItemClick =
        new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    final AdapterView<?> parent,
                    final View view,
                    final int position,
                    final long id)
            {

                Log.d(MainActivity.APP_TAG, String.format("tarefa id: %d e posição: %d", id, position));

                final TextView v = (TextView) view;

                MainActivity.this.populaTarefas();
            }
        };
}
