package com.example.app_crud_mysql.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.app_crud_mysql.R;
import com.example.app_crud_mysql.ui.dts.dto_usuarios;
import com.example.app_crud_mysql.ui.listpro.*;
import java.util.List;

public class AdaptadorUsuarios extends RecyclerView.Adapter<AdaptadorUsuarios.UsuariosHolder>{

    List<dto_usuarios> listaUsuarios;

    public AdaptadorUsuarios(List<dto_usuarios> listaUsuarios){
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public UsuariosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.usuarios_recyclerview,parent,false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        return new UsuariosHolder(vista);
    }

    @Override
    public void onBindViewHolder(UsuariosHolder holder, int position) {
        dto_usuarios dto = listaUsuarios.get(position);
        holder.tvId.setText(String.valueOf(dto.getId()));
        holder.tvNombre.setText(dto.getNombre());
        holder.tvApellido.setText(dto.getApellido());
        holder.tvCorreo.setText(dto.getCorreo());
        holder.tvUsuario.setText(dto.getUsuario());
        holder.tvClave.setText(dto.getClave());
        holder.tvTipo.setText(String.valueOf(dto.getTipo()));
        holder.tvEstado.setText(String.valueOf(dto.getEstado_us()));
        holder.tvPregunta.setText(dto.getPregunta());
        holder.tvRespuesta.setText(dto.getRespuesta());
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public class UsuariosHolder extends RecyclerView.ViewHolder{

        TextView tvId, tvNombre, tvApellido, tvCorreo, tvUsuario, tvClave, tvTipo, tvEstado, tvPregunta, tvRespuesta;

        public UsuariosHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvApellido = (TextView) itemView.findViewById(R.id.tvApellidos);
            tvCorreo = (TextView) itemView.findViewById(R.id.tvCorreo);
            tvUsuario = (TextView) itemView.findViewById(R.id.tvUsuario);
            tvClave = (TextView) itemView.findViewById(R.id.tvClave);
            tvTipo = (TextView) itemView.findViewById(R.id.tvTipo);
            tvEstado = (TextView) itemView.findViewById(R.id.tvEstado);
            tvPregunta = (TextView) itemView.findViewById(R.id.tvPregunta);
            tvRespuesta = (TextView) itemView.findViewById(R.id.tvRespuesta);
        }
    }
}

