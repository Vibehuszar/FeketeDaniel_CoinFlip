package hu.petrik.coinflip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewErme;
    private Button buttonFej, buttonIras;
    private TextView textViewDobasok, textViewGyozelem, textViewVereseg;
    private int dbszam;
    private int gyszam;
    private int vszam;
    private AlertDialog.Builder builderJatekVege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        init();

        buttonFej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                int szam = rnd.nextInt(2);
                if (szam == 0){
                    imageViewErme.setImageResource(R.drawable.heads);
                    gyszam++;
                    textViewGyozelem.setText("Győzelem: " +gyszam);
                    Toast.makeText(MainActivity.this, "Fej", Toast.LENGTH_SHORT).show();
                }
                else{
                    imageViewErme.setImageResource(R.drawable.tails);
                    vszam++;
                    textViewVereseg.setText("Vereség: " +vszam);
                    Toast.makeText(MainActivity.this, "Írás", Toast.LENGTH_SHORT).show();
                }
                dbszam++;
                textViewDobasok.setText("Dobások: " +dbszam);
                if (gyszam == 3 || vszam == 3){
                    if (gyszam == 3){
                        builderJatekVege.setTitle("Győzelem.");
                        builderJatekVege.show();
                    }
                    else{
                        builderJatekVege.setTitle("Vereség.");
                        builderJatekVege.show();
                    }
                }
            }
        });

        buttonIras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                int szam = rnd.nextInt(2);
                if (szam == 1){
                    imageViewErme.setImageResource(R.drawable.tails);
                    gyszam++;
                    textViewGyozelem.setText("Győzelem: " +gyszam);
                    Toast.makeText(MainActivity.this, "Írás", Toast.LENGTH_SHORT).show();
                }
                else{
                    imageViewErme.setImageResource(R.drawable.heads);
                    vszam++;
                    textViewVereseg.setText("Vereség: " +vszam);
                    Toast.makeText(MainActivity.this, "Fej", Toast.LENGTH_SHORT).show();
                }
                dbszam++;
                textViewDobasok.setText("Dobások: " +dbszam);
                if (gyszam == 3 || vszam == 3){
                    if (gyszam == 3){
                        builderJatekVege.setTitle("Győzelem.");
                        builderJatekVege.show();
                    }
                    else{
                        builderJatekVege.setTitle("Vereség.");
                        builderJatekVege.show();
                    }
                }
            }
        });
    }


    private void init(){
        imageViewErme = findViewById(R.id.imageViewErme);
        buttonFej = findViewById(R.id.buttonFej);
        buttonIras = findViewById(R.id.buttonIras);
        textViewDobasok = findViewById(R.id.textViewDobasok);
        textViewGyozelem = findViewById(R.id.textViewGyozelem);
        textViewVereseg = findViewById(R.id.textViewVereseg);
        dbszam = 0;
        gyszam = 0;
        vszam = 0;
        builderJatekVege = new AlertDialog.Builder(MainActivity.this);
        builderJatekVege.setCancelable(false)
                .setMessage("Szeretne új játékot játszani?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ujJatek();
                    }
                })
                .create();

    }

    private void ujJatek(){
        dbszam = 0;
        gyszam = 0;
        vszam = 0;
        textViewGyozelem.setText("Győzelem: " +gyszam);
        textViewVereseg.setText("Vereség: " +vszam);
        textViewDobasok.setText("Dobások: " +dbszam);

    }
}