package mx.com.javi08.platzigram;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.OnClick;
import mx.com.javi08.platzigram.view.ContainerActivity;
import mx.com.javi08.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    // Este es el metodo inicial y dice que al crearse esta view empezara con la vista de login
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    //Definimos el metodo que llevara a Nueva Cuenta con intent al dar clic a crea una cuenta aqui
    public void goCreateAccount(View view){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    //Definimos el metodo que llevara al dar clic al boton Login con intent al container
    public void goContainer(View view){
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }

//    public void onClickLogo(View view) {
//        //Uri uriUrl = Uri.parse("http://www.codigojavalibre.com/");
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://platzigram.com/"));
//        startActivity(intent);
//    }

    @OnClick(R.id.logo)
    public void irPagina(View view) {
//        if (view.getId() == R.id.logo) {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://platzigram.com/"));
            startActivity(intent);
//        }
    }

}
