package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private EditText input;
	private Button tebak;
	int random;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		initRandomNumber();
		input = findViewById(R.id.number_input);
		tebak = findViewById(R.id.guess_button);
	}

	// TODO: generate angka random di sini
	private int initRandomNumber() {
		Random r = new Random();
		random = r.nextInt(100)+1;
		return random;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		int angka = Integer.parseInt(String.valueOf(input.getText()));
		if(angka > random){
			Toast.makeText(this, "Hasil Terlalu Besar", Toast.LENGTH_SHORT).show();
		}
		else if(angka < random){
			Toast.makeText(this, "Hasil Terlalu Kecil", Toast.LENGTH_SHORT).show();
		}
		else {
			Toast.makeText(this, "Hasil Sama", Toast.LENGTH_SHORT).show();
			tebak.setEnabled(false);
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		input.setText("");
		initRandomNumber();
		tebak.setEnabled(true);
	}
}
