package android.itesm.edu.pokemon.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkCard implements Serializable {

    private String nombre, salario, direccion, descripcion, imageUrl;
    private ArrayList<String> dias = new ArrayList<>();

    public WorkCard() {
    }

    public WorkCard(String nombre, String salario, String direccion, String descripcion, String imageUrl, ArrayList<String> dias) {
        this.nombre = nombre;
        this.salario = salario;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.imageUrl = imageUrl;
        this.dias = dias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String id) {
        this.nombre = id;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ArrayList<String> getDias() {
        return dias;
    }

    public void setDias(ArrayList<String> dias) {
        this.dias = dias;
    }


}
