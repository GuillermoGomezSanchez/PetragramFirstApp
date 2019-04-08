package androidcourse.companyname.com.petagramfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

public class DetalleMascota extends AppCompatActivity {

    ArrayList<Mascota> lista = new ArrayList<>();
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);

        Toolbar actionBar = findViewById(R.id.activeDetail);
        setSupportActionBar(actionBar);
        TextView title = findViewById(R.id.titlePetagram);
        title.setText(R.string.app_name);

        listaMascotas =  findViewById(R.id.RVDetailmascotas);

        LinearLayoutManager lnm = new LinearLayoutManager(this);
        lnm.setOrientation(LinearLayoutManager.VERTICAL);

        //lstContactos.setLayoutManager(lnm);
        listaMascotas.setLayoutManager(lnm);

        ArrayList<Mascota> aux = new ArrayList<>();

        listaMascotas.setAdapter(new MascotaAdaptador(Global.likeMascotas,this));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
