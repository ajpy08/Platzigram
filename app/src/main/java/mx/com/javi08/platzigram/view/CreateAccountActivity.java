package mx.com.javi08.platzigram.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import mx.com.javi08.platzigram.R;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        //De esta manera llamamos al texto de strings.xml con id = toolbar_tittle_createaccount
        // getResources().getString(R.string.toolbar_tittle_createaccount)

        //Este metodo se creo aparte con parametros que nos indican si va a tener texto el toolbar (string) y si va a tener un boton (boolean)
        showToolbar(getResources().getString(R.string.toolbar_tittle_createaccount),true);

    }

    public void showToolbar(String tittle, Boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //para dar soporte de la toolbar a versiones mas antiguas de android las siguientes 3 lineas
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
