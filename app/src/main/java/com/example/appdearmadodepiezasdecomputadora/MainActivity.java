package com.example.appdearmadodepiezasdecomputadora;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnercpu;
    private Spinner spinneram;
    private Spinner spinnermother;
    private Spinner spinnergraf;
    private CheckBox armado;
    private Button mostrar;
    private TextView resultado;
    private String[] CPU={"CORE I3","CORE I5","CORE I7"};
    private String[] MOTHER={"PLACA 1","PLACA 2","PLACA 3"};
    private String[] RAM={"8 GB","16 GB","32 GB"};
    private String[] GRAFICA={"NVIDIA 1060","NVIDIA 3060","NVIDIA 4060"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnercpu=findViewById(R.id.spinner_cpu);
        spinneram=findViewById(R.id.spinner_ram);
        spinnergraf=findViewById(R.id.spinner_grafica);
        spinnermother=findViewById(R.id.spinner_placa);
        resultado=findViewById(R.id.total_1);
        armado=findViewById(R.id.check_armado);
        mostrar=findViewById(R.id.boton_calculo);

        ArrayAdapter<String>adaptador1=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,CPU);
        spinnercpu.setAdapter(adaptador1);
        ArrayAdapter<String>adaptador2=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,MOTHER);
        spinnermother.setAdapter(adaptador2);
        ArrayAdapter<String>adaptador3=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,RAM);
        spinneram.setAdapter(adaptador3);
        ArrayAdapter<String>adaptador4=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,GRAFICA);
        spinnergraf.setAdapter(adaptador4);

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cpu=spinnercpu.getSelectedItem().toString();
                String placa=spinnermother.getSelectedItem().toString();
                String ram=spinneram.getSelectedItem().toString();
                String grafica=spinnergraf.getSelectedItem().toString();
                resultado.setText("Cpu: "+ cpu + "\n");
                resultado.append("Placa: "+ placa + "\n");
                resultado.append("Ram: "+ ram + "\n");
                resultado.append("Grafica: "+ grafica + "\n");
                int vcpu=0;
                int vram=0;
                int vplaca=0;
                int vgrafica=0;
                double total=0.0;
                if (cpu.equals("CORE I3")){
                    vcpu=155350;
                } else if (cpu.equals("CORE I5")) {
                    vcpu=89990;

                } else if (cpu.equals("CORE I7")) {
                    vcpu=400000;
                }
                //calculo ram
                if (ram.equals("8 GB")){
                    vram=10000;
                } else if (ram.equals("16 GB")) {
                    vram=20000;

                } else if (ram.equals("32 GB")) {
                    vram=30000;
                }
                //calculo placa
                if (placa.equals("PLACA 1")){
                    vplaca=99990;
                } else if (placa.equals("PLACA 2")) {
                    vplaca=167680;

                } else if (placa.equals("PLACA 3")) {
                    vplaca=350000;
                }
                //calculo grafica
                if (grafica.equals("NVIDIA 1060")){
                    vgrafica=250000;
                } else if (grafica.equals("NVIDIA 3060")) {
                    vgrafica=350000;

                } else if (grafica.equals("NVIDIA 4060")) {
                    vgrafica=450000;
                }
                total=vcpu+vram+vplaca+vgrafica;
                if (armado.isChecked()){
                    total=total*1.13;
                    resultado.append("Servicio de armado: SI \n");
                }
                resultado.append("Total: "+ String.valueOf(total));
            }
        });

        armado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (armado.isChecked()){
                    Toast.makeText(MainActivity.this, "Has seleccionado el servicio de armado", Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(MainActivity.this, "Te has arrepentido", Toast.LENGTH_LONG).show();


                }

            }
        });




    }
}