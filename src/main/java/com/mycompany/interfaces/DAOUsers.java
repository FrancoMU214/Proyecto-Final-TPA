package com.mycompany.interfaces;

import com.mycompany.models.Users;
import java.util.List;

public interface DAOUsers {

    public void registrar(Users user) throws Exception;

    public void modificar(Users user) throws Exception;

    public void sancionar(Users user) throws Exception;

    public void eliminar(int userId) throws Exception;

    public List<Users> listar(String name,int page, int limit) throws Exception;
    public List<Users> listarTrabajadores(String name,int page, int limit) throws Exception;

    public List<Users> listarId(String id) throws Exception;

    public Users getUserById(int userId) throws Exception;

    public List<Users> listarEmail(String email) throws Exception;
    public int contarRegistros()  throws Exception;
    public int contarRegistrosTrabajadores()  throws Exception;

}
