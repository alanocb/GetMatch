package com.pal.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.pal.navigationdrawer.dto.request.UserRequest;
import com.pal.navigationdrawer.dto.response.UserResponse;
import com.pal.navigationdrawer.service.ApiClient;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroActivity extends AppCompatActivity {

    private EditText nomeEditText, emailEditText, senhaEditText,
            dataNascimentoEditText, telefoneEditText;
    private Button cadastroButton;

    SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

    private final ApiClient clientApi = new ApiClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();

        iniciarComponentes();

        dataNascimentoEditText.setOnClickListener(view -> {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (datePicker, y, m, d) -> {
                        String data = (y + "-" + (m + 1) + "-" + d);
                        dataNascimentoEditText.setText(data);
                    }, year, month, day);
            datePickerDialog.show();

        });

        cadastroButton.setOnClickListener(view ->  {

            String nome = nomeEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String senha = senhaEditText.getText().toString();
            String dataNascimento = dataNascimentoEditText.getText().toString();
            String telefone = telefoneEditText.getText().toString();

            if (
                    nome.isEmpty() || email.isEmpty() || senha.isEmpty()
                    || dataNascimento.isEmpty() || telefone.isEmpty()
            ) {
                Toast.makeText(
                        getApplicationContext(),
                        "Por favor preencha todos os campos",
                        Toast.LENGTH_LONG
                ).show();
                return;
            }

            Calendar c = Calendar.getInstance();
            int anoAtual = c.get(Calendar.YEAR);

            int anoNascimento = Integer.parseInt(dataNascimento.split("-")[0]);

            if (((anoAtual - anoNascimento) < 16) || anoNascimento > anoAtual) {
                Toast.makeText(
                        getApplicationContext(),
                        "Data de nascimento invalida",
                        Toast.LENGTH_LONG
                ).show();
                return;
            } else {

                UserRequest request = new UserRequest();
                request.setName(nome);
                request.setEmail(email);
                request.setPass(senha);
                request.setbDate(dataNascimento);
                request.setTelefone(Integer.parseInt(telefone));

                Call<UserResponse> responseObj = clientApi.api.saveUser(request);
                responseObj.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Erro ao salvar usuario",
                                    Toast.LENGTH_LONG
                            ).show();
                        }else {
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Usuario criado com sucesso!",
                                    Toast.LENGTH_LONG
                            ).show();

                            Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

            }

        });

    }

    private void iniciarComponentes() {
        nomeEditText = findViewById(R.id.cadastroNome);
        emailEditText = findViewById(R.id.cadastroEmail);
        senhaEditText = findViewById(R.id.cadastroSenha);
        dataNascimentoEditText = findViewById(R.id.cadastroData);
        telefoneEditText = findViewById(R.id.cadastroTelefone);
        cadastroButton = findViewById(R.id.cadastroButton);
    }

}