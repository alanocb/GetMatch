package com.pal.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pal.navigationdrawer.dto.request.AuthRequest;
import com.pal.navigationdrawer.dto.response.UserAuthResponse;
import com.pal.navigationdrawer.dto.Utils;
import com.pal.navigationdrawer.service.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private TextView text_tela_cadastro;
    private Button bt_entrar;
    private EditText emailEditText, passwordEditText;
    private SharedPreferences sharedPreferences;

    private final ApiClient clientApi = new ApiClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        IniciarComponentes();

        Boolean loggedIn = sharedPreferences.getBoolean("user_logged_in", false);
        if (loggedIn) {
            Intent intent = new Intent(LoginActivity.this, MainActivity2.class);
            startActivity(intent);
        }

        bt_entrar.setOnClickListener((View view) -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (email.isEmpty()) {
                Toast.makeText(
                        getApplicationContext(),
                        "Por favor preencha email",
                        Toast.LENGTH_LONG
                ).show();
            }else if (password.isEmpty()) {
                Toast.makeText(
                        getApplicationContext(),
                        "Por favor preencha senha",
                        Toast.LENGTH_LONG
                ).show();
            }else {

                AuthRequest request = new AuthRequest();
                request.setEmail(email);
                request.setPassword(password);

                Call<UserAuthResponse> responseObj = clientApi.api.authenticate(request);

                responseObj.enqueue(new Callback<UserAuthResponse>() {
                    @Override
                    public void onResponse(Call<UserAuthResponse> call, Response<UserAuthResponse> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Erro ao autenticar usuario",
                                    Toast.LENGTH_LONG
                            ).show();
                        }else {
                            UserAuthResponse user = (UserAuthResponse) response.body();
                            if (user != null) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity2.class);

                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("user_name", user.getNome());
                                editor.putString("user_email", user.getEmail());
                                editor.putBoolean("user_logged_in", true);
                                editor.commit();

                                startActivity(intent);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<UserAuthResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

            }
        });

        text_tela_cadastro.setOnClickListener((View view) -> {
            Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
            startActivity(intent);
        });
    }

    private void IniciarComponentes(){
        text_tela_cadastro = findViewById(R.id.text_tela_cadastro);
        bt_entrar = findViewById(R.id.bt_entrar);
        emailEditText = findViewById(R.id.loginEditEmail);
        passwordEditText = findViewById(R.id.loginEditSenha);
        sharedPreferences = getSharedPreferences(Utils.SHARED_PREFERENCE, Context.MODE_PRIVATE);
    }

}