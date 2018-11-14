package com.fpuna.arandu.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fpuna.arandu.R;

public class InformacionActivity extends AppCompatActivity {

    private ImageView escudo, bandera, logo_institucionales_spl, logos_gobierno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        escudo = findViewById(R.id.escudoInfo);
        bandera = findViewById(R.id.banderaInfo);
        logo_institucionales_spl = findViewById(R.id.logo_institucionales_splInfo);
        logos_gobierno = findViewById(R.id.logos_gobiernoInfo);
        /*
        Glide.with(this)
                .load(getResources().getDrawable(R.drawable.escudo))
                .into(escudo);
        Glide.with(this)
                .load(getResources().getDrawable(R.drawable.bandera))
                .into(bandera);
        Glide.with(this)
                .load(getResources().getDrawable(R.drawable.logo_institucionales_spl))
                .into(logo_institucionales_spl);

        Glide.with(this)
                .load(getResources().getDrawable(R.drawable.logos_gobierno))
                .into(logos_gobierno);
                */
    }
}
