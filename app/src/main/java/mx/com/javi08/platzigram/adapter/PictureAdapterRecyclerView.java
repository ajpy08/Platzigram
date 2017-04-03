package mx.com.javi08.platzigram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.com.javi08.platzigram.R;
import mx.com.javi08.platzigram.model.Picture;
import mx.com.javi08.platzigram.view.PictureDetailActivity;

/**
 * Created by javi on 24/03/2017.
 */
// RecyclerView.Adapter<Recibe una coleccion de PictureViewHolder que va a ser de nuestro modelo osea del dataset de datos>
// Se creo el package Picture y adentro una clase que sera nuestro modelo
public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{

    //La lista de Pictures es una lista de objetos de mi modelo
    private ArrayList<Picture> pictures;
    // El cardview (Picture.xml)
    private int resource;
    // La actividad de donde se esta llamando esta clase
    private Activity activity;

    //Este constructor se genero automaticamente al dar ALT+Enter generate constructor y se seleccionaron todas las variables
    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    //Estos 3 metodos sobreescritos se implementaron automaticamente al dar ALT+Enter en <PictureAdapterRecyclerView.PictureViewHolder> (PictureViewHolder)
    //Esta clase inicializara nuestra clase PictureViewHolder

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflar significa insertar una porcion de codigo en una actividad, tomar esa porcion de codigo y mostrarlo en una pantalla
        //Ese archivo layout + componente de java mostrarlo en la pantalla, el XML lo estamos convirtiendo en un View
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);

        // retornamos el view que viene inflado ya tiene asociado su resource
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        //Aqui se trabajara con la lista de elementos osea el arraylist de Pictures, se hara el paso de datos de cada objeto de la lista

        //pictures es el array, posicion ira cachando y recorrer el arraylist para asignar cada objeto a cada cardview
        //Iremos generando tarjetas con datos llenos.
        Picture picture = pictures.get(position);
        holder.usernameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLike_number());


        // Con la libreria picaso que ya deberiamos haber agregado al gradle module mostramos imagenes de internet pero tenemos que ponerle permisos
        //en el AndroidManifest
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);


        //Agregamos un intent con un evento OnClickListener para que cuando se de clic a un cardview habra el detalle.
        //El activity lo pasamos desde el constructor por eso siempre lo pedimos como parametro
        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // El intent recibe como parametro la actividad osea donde estoy coma a donde quiero ir.
                Intent intent = new Intent(activity, PictureDetailActivity.class);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    //la duracion se da en milisegundos en este caso 1 seg
                    explode.setDuration(1000);
                    //tenemos que poner activity por que estamos en el adapter, si estuvieras en la actividad no necesitariamos que poner activity
                    activity.getWindow().setExitTransition(explode);

                    //Si quisieramos tomar los valores por default del explode pondriamos
                    //activity.getWindow().setExitTransition(new Explode());

                    //Con esto ya estamos saliendo de la actividad
                    activity.startActivity(intent,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(activity, view, activity.getString(R.string.transitionname_picture)).toBundle());
                }
                else{
                    activity.startActivity(intent);
                }
            }
        });
    }

    //Este metodo lo unico que hace es devolver un conteo de cuantos elementos tengo
    @Override
    public int getItemCount() {
        return pictures.size();
    }

    //El adapter recibe una coleccion de PictureViewHolder ya que este se concentra en todos los view que componen la tarjeta
    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likeNumberCard;

        //Este constructor se genero automaticamente al dar ALT+Enter en en public class PictureViewHolder extends RecyclerView.ViewHolder{ (ViewHolder)
        //En la opcion Create Constructor matching super
        public PictureViewHolder(View itemView) {
            super(itemView);

            // Se instanciaron las varibales que se declararon antes
            // Se importo para poder usar R.
            pictureCard = (ImageView) itemView.findViewById(R.id.pictureCard);
            usernameCard = (TextView) itemView.findViewById(R.id.userNameCard);
            timeCard = (TextView) itemView.findViewById(R.id.timeCard);
            likeNumberCard = (TextView) itemView.findViewById(R.id.likeNumberCard);
        }
    }

}
