package br_elfo.edmarluizleonefogaca.spinnercombo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sistemas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);



        setContentView(R.layout.activity_main);

        sistemas = (Spinner) findViewById(R.id.spinSO);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.sistemas_mobile,
                android.R.layout.simple_spinner_dropdown_item);
        sistemas.setAdapter(adapter);

        // vai exibir o item escolhido a partir do clique do botão
        Button ok = (Button) findViewById(R.id.btnOk);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = sistemas.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), "Item escolhido: " + item,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // vai exibir o item escolhido a partir da mudança do item do Spinner
        AdapterView.OnItemSelectedListener escolha =
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                        String item = sistemas.getSelectedItem().toString();
                        Toast.makeText(getApplicationContext(), "Item escolhido: " + item,
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                };

        sistemas.setOnItemSelectedListener(escolha);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}