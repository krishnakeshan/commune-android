package com.qrilt.commune;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
Class representing the server or relay server.
 */
public class Server {
    // Attributes
    private String baseUrlString = "https://us-central1-commune-80a98.cloudfunctions.net/";
    private String registerPath = "registerDevice";

    private URL baseUrl;

    // Constructors
    // Default constructor
    Server() {
        try {
            // create base url
            baseUrl = new URL(baseUrlString);
        } catch (MalformedURLException exception) {
            Log.d("DebugK", "Error creating base url");
        }
    }

    // Methods
    // Method to register with the server
    void registerDevice() {
        try {
            // create register url
            URL registerURL = new URL(baseUrl, registerPath);

            // open connection and connect
            HttpURLConnection connection = (HttpURLConnection) registerURL.openConnection();
//            connection.connect();

            // write to connection
            connection.setDoOutput(true);
            connection.setFixedLengthStreamingMode(FirebaseAuth.getInstance().getCurrentUser().getUid().length());

            OutputStream outputStream = new BufferedOutputStream(connection.getOutputStream());
            outputStream.write(FirebaseAuth.getInstance().getCurrentUser().getUid().getBytes());

            // read from connection
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                Log.d("DebugK", inputLine);
            }
            in.close();
        } catch (MalformedURLException exception) {
            Log.d("DebugK", "Error creating register url");
            exception.printStackTrace();
        } catch (IOException exception) {
            Log.d("DebugK", "Error opening connection to url");
            exception.printStackTrace();
        }
    }
}
