package kessia.raissa.email;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;
import android.content.ActivityNotFoundException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnviar = findViewById(R.id.btnEnviar); //encontra o botão pelo Id definido no arquivo xml

        // Definicao da acao do click do botao
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //o código a ser executado quando o botão é clicado
                EditText etEmail = (EditText) findViewById(R.id.etEmail);
                String email = etEmail.getText().toString();

                EditText etAssunto = (EditText) findViewById(R.id.etAssunto);
                String assunto = etEmail.getText().toString();

                EditText etTexto = (EditText) findViewById(R.id.etTexto);
                String texto = etEmail.getText().toString();

                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"));

                String[] emails = new String[]{email};
                i.putExtra(Intent.EXTRA_EMAIL, emails);
                i.putExtra(Intent.EXTRA_SUBJECT, assunto);
                i.putExtra(Intent.EXTRA_TEXT, texto);

                try {
                    startActivity(Intent.createChooser(i, "Escolha o APP"));
                }
                catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Não há nenhum app que posso realizar essa operação",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
