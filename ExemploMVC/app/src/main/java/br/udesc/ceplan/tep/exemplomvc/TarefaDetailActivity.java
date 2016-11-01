package br.udesc.ceplan.tep.exemplomvc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.udesc.ceplan.tep.exemplomvc.model.Tarefa;

public class TarefaDetailActivity extends AppCompatActivity {

    public static final String TAREFA_ID = "br.udesc.ceplan.tep.exemplomvc.TAREFA_ID";
    public static final String TAREFA_NAME = "br.udesc.ceplan.tep.exemplomvc.TAREFA_NAME";
    public static final String TAREFA_DESC = "br.udesc.ceplan.tep.exemplomvc.TAREFA_DESC";

    private Long id;
    private ApplicationController aController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa_detail);

        this.aController = (ApplicationController) getApplicationContext();

        TextView txId = (TextView) this.findViewById(R.id.txTarefaDetailId);
        TextView txName = (TextView) this.findViewById(R.id.txTarefaDetailName);
        TextView txDesc = (TextView) this.findViewById(R.id.txTarefaDetailDesc);
        Button btDelete = (Button) this.findViewById(R.id.btTarefaDetailDelete);
        btDelete.setOnClickListener(handleDeletarTarefaEvent);

        Intent intent = getIntent();

        id = intent.getLongExtra(TAREFA_ID, -1);
        String name = intent.getStringExtra(TAREFA_NAME);
        String desc = intent.getStringExtra(TAREFA_DESC);

        txId.setText(String.valueOf(id));
        txName.setText(name);
        txDesc.setText(desc);

    }

    private final View.OnClickListener handleDeletarTarefaEvent =
            new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    Log.d(MainActivity.APP_TAG, "botão deletar tarefa acionado");
                    Long _id = TarefaDetailActivity.this.id;
                    TarefaDetailActivity.this.aController.getDaoFactorySQLite().getTarefaDao().delete(_id);

                }
            };
}
