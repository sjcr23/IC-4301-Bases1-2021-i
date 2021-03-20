package tec.bd.app.dao;

import tec.bd.app.database.set.Row;
import tec.bd.app.database.set.RowAttribute;
import tec.bd.app.database.set.SetDB;

import tec.bd.app.domain.Estudiante;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;


public class EstudianteDAOImpl extends GenericSetDAOImpl<Estudiante, Integer> implements EstudianteDAO {

    public EstudianteDAOImpl(SetDB setDB, Class<Estudiante> clazz) {
        super(setDB, clazz);
    }

    @Override
    public List<Estudiante> findByLastName(String apellido) {

        /* -> Recolectamos en "estudiantes" la lista de estudiantes que exista.
         * -> Creamos un array para almacenar la lista de los distintos estudiantes con ese Apellido
         * -> Recorremos el List para preguntar si existen coincidencias de apellido, si lo hay, rellenamos el array.
         * -> Cuando el ciclo termine, retornames el array.
         */

        var estudiantes =  this.table.stream().map(this::rowToEntity).collect(Collectors.toList());
        ArrayList<Estudiante> listaPorApellidos = new ArrayList<>();
        for (Estudiante actual : estudiantes) {
            if (actual.getApellido().equals(apellido)) {
                listaPorApellidos.add(actual);
            }
        }
        return listaPorApellidos.stream().collect(Collectors.toList());
    }
    @Override
    public List<Estudiante> findAllSortByLastName() {

        List<Estudiante> estudiantes = this.table.stream().map(this::rowToEntity).collect(Collectors.toList());
        return quicksort(estudiantes);
    }

    @Override
    public List<Estudiante> quicksort(List<Estudiante> lista) {

        ArrayList<Estudiante> menores = new ArrayList<>();
        ArrayList<Estudiante> iguales = new ArrayList<>();
        ArrayList<Estudiante> mayores = new ArrayList<>();

        Estudiante pivote = lista.get(0);

        //Condicion de Parada
        if (lista.size() <=1 ){
            //return retornable.stream().collect(Collectors.toList());
            return null;
        }

        for (Estudiante actual:lista){
            // E
            if(actual.getApellido().compareTo(pivote.getApellido()) < 0){
                menores.add(actual);
            }
            else if (actual.getApellido().compareTo(pivote.getApellido())  > 0){
                mayores.add(actual);
            }
            else{
                iguales.add(actual);
            }
        }

       //Stream.concat(quicksort(menores).stream(),iguales.stream(),quicksort(mayores).stream()).collect(Collectors.toList());

        return null;
    }

    @Override
    protected Estudiante rowToEntity(Row row) {
        // conversiones de Row a Estudiante
        var carne = row.intAttributeValue("id");
        var nombre = row.stringAttributeValue("nombre");
        var apellido = row.stringAttributeValue("apellido");
        var edad = row.intAttributeValue("edad");
        return new Estudiante(carne, nombre, apellido, edad);
    }

    @Override
    protected Row entityToRow(Estudiante e) {
        // conversiones de Estudiante a Row
        return new Row(new RowAttribute[] {
                new RowAttribute("id", e.getCarne()),
                new RowAttribute("nombre", e.getNombre()),
                new RowAttribute("apellido", e.getApellido()),
                new RowAttribute("edad", e.getEdad())
        });
    }
}