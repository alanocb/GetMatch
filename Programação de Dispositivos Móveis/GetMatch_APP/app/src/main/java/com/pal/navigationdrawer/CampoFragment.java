package com.pal.navigationdrawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pal.navigationdrawer.adapter.CampoListAdapter;
import com.pal.navigationdrawer.adapter.JogoListAdapter;
import com.pal.navigationdrawer.databinding.FragmentCampoBinding;
import com.pal.navigationdrawer.dto.response.CampoResponse;
import com.pal.navigationdrawer.dto.response.JogoResponse;
import com.pal.navigationdrawer.service.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CampoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CampoFragment extends Fragment {
    private FragmentCampoBinding binding;
    ListView lView;
    CampoListAdapter lAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private final ApiClient clientApi = new ApiClient();
    private final ArrayList<CampoResponse> campos = new ArrayList<>();

    public CampoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CampoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CampoFragment newInstance(String param1, String param2) {
        CampoFragment fragment = new CampoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCampoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        lView = root.findViewById(R.id.campoListView);

        Call<List<CampoResponse>> responseObj = clientApi.api.getAllCampos();

        responseObj.enqueue(new Callback<List<CampoResponse>>() {
            @Override
            public void onResponse(Call<List<CampoResponse>> call, Response<List<CampoResponse>> response) {
                if (response.isSuccessful()) {
                    for (CampoResponse jogo: response.body()) {
                        campos.add(jogo);
                    }
                    lAdapter = new CampoListAdapter(container.getContext(), campos);
                    lView.setAdapter(lAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<CampoResponse>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return root;
    }
}