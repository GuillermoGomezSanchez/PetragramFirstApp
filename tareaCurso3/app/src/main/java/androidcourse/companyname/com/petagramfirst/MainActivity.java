package androidcourse.companyname.com.petagramfirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> lista = new ArrayList<>();
    private RecyclerView listaMascotas;
    ArrayList<Mascota> gustoAnimal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionBar = findViewById(R.id.activPrinc);
        setSupportActionBar(actionBar);
        TextView title = findViewById(R.id.titlePetagram);
        title.setText(R.string.app_name);
        //getSupportActionBar().setTitle(R.string.app_name);
        //getSupportActionBar().setLogo(R.drawable.huella);

        lista.add(new Mascota(R.drawable.chihuahua,"Dominico",(byte)0));
        lista.add(new Mascota(R.drawable.happycat,"Perejilo",(byte)0));
        lista.add(new Mascota(R.drawable.husky,"Laboriel",(byte)0));
        lista.add(new Mascota(R.drawable.pomeranian,"Ito",(byte)0));
        lista.add(new Mascota(R.drawable.pitbull,"Brutus",(byte) 0));
        lista.add(new Mascota(R.drawable.kitty,"Hello",(byte)0));
        lista.add(new Mascota(R.drawable.pug,"Edgar", (byte)0));

        for(int ind=0;ind<lista.size();ind++)
        {
            for(int idx=0;idx<Global.likeMascotas.size();idx++)
            {
                if(lista.get(ind).getNombre() == Global.likeMascotas.get(idx).getNombre()){
                    lista.get(ind).setCalificacion(Global.likeMascotas.get(idx).getCalificacion());
                }
            }
        }

        listaMascotas =  findViewById(R.id.RVmascotas);

        LinearLayoutManager lnm = new LinearLayoutManager(this);
        lnm.setOrientation(LinearLayoutManager.VERTICAL);

        //lstContactos.setLayoutManager(lnm);
        listaMascotas.setLayoutManager(lnm);

        listaMascotas.setAdapter(new MascotaAdaptador(lista,this));

        ImageView estrella = findViewById(R.id.iconStar);
        TextView textEstrella = findViewById(R.id.textIconStar);

        estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,DetalleMascota.class);
                startActivity(i);
            }
        });

        textEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,DetalleMascota.class);
                startActivity(i);
            }
        });
    }

    /*private void alDarClick(Mascota mascota){
        //Toast.makeText(activity,mascota.getNombre(),Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,DetalleMascota.class);

        for(int j=0;j<mascotas.size();j++)
        {
            if(j==5){break;}

            i.putExtra("nombre"+Integer.toString(j),mascotas.get(j).getNombre());
            i.putExtra("calificacion"+Integer.toString(j),mascotas.get(j).getCalificacion());
            i.putExtra("imagen"+Integer.toString(j),mascotas.get(j).getImagen());
        }

        startActivity(i);
        //activity.finish();
    }*/
}
