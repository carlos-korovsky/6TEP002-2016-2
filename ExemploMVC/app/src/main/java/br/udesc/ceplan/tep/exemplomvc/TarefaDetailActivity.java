package br.udesc.ceplan.tep.exemplomvc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TarefaDetailActivity extends AppCompatActivity {

    public static final String TAREFA_ID = "br.udesc.ceplan.tep.exemplomvc.TAREFA_ID";
    public static final String TAREFA_NAME = "br.udesc.ceplan.tep.exemplomvc.TAREFA_NAME";
    public static final String TAREFA_DESC = "br.udesc.ceplan.tep.exemplomvc.TAREFA_DESC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa_detail);

        TextView txId = (TextView) this.findViewById(R.id.txTarefaDetailId);
        TextView txName = (TextView) this.findViewById(R.id.txTarefaDetailName);
        TextView txDesc = (TextView) this.findViewById(R.id.txTarefaDetailDesc);
        Button btDelete = (Button) this.findViewById(R.id.btTarefaDetailDelete);

        Intent intent = getIntent();

        Long id = intent.getLongExtra(TAREFA_ID, -1);
        String name = intent.getStringExtra(TAREFA_NAME);
        String desc = intent.getStringExtra(TAREFA_DESC);

        txId.setText(String.valueOf(id));
        txName.setText(name);
        txDesc.setText(desc);

    }
}
