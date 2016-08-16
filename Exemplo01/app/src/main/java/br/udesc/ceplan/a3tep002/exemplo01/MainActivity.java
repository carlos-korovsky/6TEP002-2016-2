package br.udesc.ceplan.a3tep002.exemplo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TextView txLogin = (TextView) findViewById(R.id.txLogin);
                TextView txPassword = (TextView) findViewById(R.id.txPassword);
                String login = txLogin.getText().toString();
                String password = txPassword.getText().toString();
                if (login.equals("demo") && (password.equals("demo"))) {
                    alerta("Bem vindo! Login realizado com sucesso");
                } else {
                    alerta("Login ou senha inválidos");
                }
            }
        });
    }

    private void alerta(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}
