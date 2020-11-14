package com.example.app_crud_mysql;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.app_crud_mysql.ui.dashboard.AdaptadorUsuarios;
import com.example.app_crud_mysql.ui.dts.dto_productos;
import com.example.app_crud_mysql.ui.dts.dto_usuarios;
import com.example.app_crud_mysql.ui.listpro.ProductoAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UsuariosRecyclerview extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{

    RecyclerView recyclerViewUsuarios;
    ArrayList<dto_usuarios> listaUsuarios;

    ProgressDialog progressDialog;
    JsonObjectRequest jsonObjectRequest;

    public UsuariosRecyclerview() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_usuarios_recyclerview, container, false);
        listaUsuarios = new ArrayList<>();

        recyclerViewUsuarios = (RecyclerView) vista.findViewById(R.id.rvUsuarios);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewUsuarios.setHasFixedSize(true);

        //Llamada al metodo
        cargarService();
        return vista;
    }

    private void cargarService(){
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Consultando registros, por favor espere!");
        progressDialog.show();

        String url = Setting_VAR.URL_consultarAllUsuarios;

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url, (String) null, this, this);

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "Error de conexion "+error.toString(), Toast.LENGTH_LONG).show();
        System.out.println();
        Log.d("Error",error.toString());
        progressDialog.hide();
    }

    @Override
    public void onResponse(JSONObject response) {
        dto_usuarios users = null;

        JSONArray json = response.optJSONArray("usuarios");
        try {

            for (int i = 0; i < json.length(); i++) {
                users = new dto_usuarios();
                JSONObject jsonObject = null;
                jsonObject = json.getJSONObject(i);

                users.setId(jsonObject.optInt("id"));
                users.setNombre(jsonObject.optString("nombre"));
                users.setApellido(jsonObject.optString("apellido"));
                users.setCorreo(jsonObject.optString("correo"));
                users.setUsuario(jsonObject.optString("usuario"));
                users.setClave(jsonObject.optString("clave"));
                users.setTipo(jsonObject.optInt("tipo"));
                users.setEstado_us(jsonObject.optInt("estado"));
                users.setPregunta(jsonObject.optString("pregunta"));
                users.setRespuesta(jsonObject.optString("respuesta"));

                listaUsuarios.add(users);
            }

            progressDialog.hide();
            AdaptadorUsuarios adapter = new AdaptadorUsuarios(listaUsuarios);
            recyclerViewUsuarios.setAdapter(adapter);

        }catch (JSONException e){
            e.printStackTrace();
            Toast.makeText(getContext(), "Error en la conexion " +
                    " "+response, Toast.LENGTH_LONG).show();
            progressDialog.hide();
        }
    }
 }
