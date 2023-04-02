package com.example.binarybandits.ui.home;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.binarybandits.R;
import com.example.binarybandits.ScanQRActivity;
import com.example.binarybandits.controllers.PermissionsController;
import com.example.binarybandits.ui.auth.LogInActivity;

/**
 * A Fragment displaying the Home Page, to be displayed in MainActivity above bottom navigation bar
 */
public class HomeFragment extends Fragment {

    private ImageButton scanButton;
    private Button signOut;

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        scanButton = view.findViewById(R.id.scan_button);
        scanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                Intent myIntent = new Intent(getActivity(), ScanQRActivity.class);
                requireActivity().startActivity(myIntent);
            }
        });

        // on sign out button clicked send user back to Log in page
        signOut = view.findViewById(R.id.signOutButton);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), LogInActivity.class);
                startActivity(myIntent);
            }
        });
        PermissionsController.askAllPermissions(getActivity());

        return view;
    }

}
