package com.pal.navigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pal.navigationdrawer.databinding.FragmentProfileBinding;
import com.pal.navigationdrawer.dto.Utils;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    private TextView userNameTextView, passwordTextView;
    private Button logoutButton;
    private SharedPreferences sharedPreferences;

    public ProfileFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getActivity().getSharedPreferences(Utils.SHARED_PREFERENCE, Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //getActivity().getSupportActionBar().hide();


        userNameTextView = root.findViewById(R.id.profileUserName);
        passwordTextView = root.findViewById(R.id.profileUserEmail);
        logoutButton = root.findViewById(R.id.profileLogout);

        String name = sharedPreferences.getString("user_name", "");
        String email = sharedPreferences.getString("user_email", "");

        userNameTextView.setText(name);
        passwordTextView.setText(email);

        logoutButton.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("user_logged_in", false);
            editor.commit();
            startActivity(intent);
        });

        return root;
    }
}