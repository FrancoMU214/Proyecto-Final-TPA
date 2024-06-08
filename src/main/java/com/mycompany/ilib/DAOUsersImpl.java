package com.mycompany.ilib;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOUsers;
import com.mycompany.models.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOUsersImpl extends Database implements DAOUsers {

    @Override
    public void registrar(Users user) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO users(name, last_name_p, last_name_m, domicilio, tel, password, role) VALUES(?,?,?,?,?,?,?);");
            st.setString(1, user.getName());
            st.setString(2, user.getLast_name_p());
            st.setString(3, user.getLast_name_m());
            st.setString(4, user.getDomicilio());
            st.setString(5, user.getTel());
            st.setString(6, user.getPassword());
            st.setString(7, user.getRole());
            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
    @Override
    public void modificar(Users user) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE users SET name = ?, last_name_p = ?, last_name_m = ?, domicilio = ?, tel = ?, password = ?, role = ? WHERE id = ?");
            st.setString(1, user.getName());
            st.setString(2, user.getLast_name_p());
            st.setString(3, user.getLast_name_m());
            st.setString(4, user.getDomicilio());
            st.setString(5, user.getTel());
            st.setString(6, user.getPassword());
            st.setString(7, user.getRole());
            st.setInt(8, user.getId());
            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
    @Override
    public void eliminar(int userId) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM users WHERE id = ?;");
            st.setInt(1, userId);
            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Users> listar(String name, int page, int limit) throws Exception {
        List<Users> lista = null;
        try {
            String query;
            this.Conectar();
            if (name.isEmpty() && page != 0 && limit != 0) {
                query = "SELECT * FROM users limit " + (page - 1) * limit + " ," + limit;
            } else if(name.isEmpty() && page == 0 && limit == 0){
                query = "SELECT * FROM users;";
            }
            else{
                query = "SELECT * FROM users WHERE name LIKE '%" + name + "%';";
            }
            PreparedStatement st = this.conexion.prepareStatement(query);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLast_name_p(rs.getString("last_name_p"));
                user.setLast_name_m(rs.getString("last_name_m"));
                user.setDomicilio(rs.getString("domicilio"));
                user.setTel(rs.getString("tel"));
                user.setSanctions(rs.getInt("sanctions"));
                user.setSanc_money(rs.getInt("sanc_money"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                lista.add(user);
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
    @Override
    public List<Users> listarTrabajadores(String name, int page, int limit) throws Exception {
        List<Users> lista = null;
        try {
            String query;
            this.Conectar();
            if (name.isEmpty() && page != 0 && limit != 0) {
                query = "SELECT * FROM users where role = 'work' OR role = 'admin' limit " + (page - 1) * limit + " ," + limit + ";";
            } else if(name.isEmpty() && page == 0 && limit == 0){
                query = "SELECT * FROM users where role = 'work' OR role = 'admin';";
            }
            else{
                query = "SELECT * FROM users WHERE name LIKE '%" + name + "%' where role = 'work' OR role = 'admin';";
            }
            PreparedStatement st = this.conexion.prepareStatement(query);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLast_name_p(rs.getString("last_name_p"));
                user.setLast_name_m(rs.getString("last_name_m"));
                user.setDomicilio(rs.getString("domicilio"));
                user.setTel(rs.getString("tel"));
                user.setSanctions(rs.getInt("sanctions"));
                user.setSanc_money(rs.getInt("sanc_money"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                lista.add(user);
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
    @Override
    public List<Users> listarEmail(String email) throws Exception {
        List<Users> lista = null;
        try {
            this.Conectar();
            String Query = email.isEmpty() ? "SELECT * FROM users;" : "SELECT * FROM users WHERE tel LIKE '%" + email + "%';";
            PreparedStatement st = this.conexion.prepareStatement(Query);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLast_name_p(rs.getString("last_name_p"));
                user.setLast_name_m(rs.getString("last_name_m"));
                user.setDomicilio(rs.getString("domicilio"));
                user.setTel(rs.getString("tel"));
                user.setSanctions(rs.getInt("sanctions"));
                user.setSanc_money(rs.getInt("sanc_money"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                lista.add(user);
                
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
    @Override
    public List<Users> listarId(String id) throws Exception {
        List<Users> lista = null;
        try {
            this.Conectar();
            String Query = id.isEmpty() ? "SELECT * FROM users;" : "SELECT * FROM users WHERE id LIKE '%" + id + "%';";
            PreparedStatement st = this.conexion.prepareStatement(Query);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLast_name_p(rs.getString("last_name_p"));
                user.setLast_name_m(rs.getString("last_name_m"));
                user.setDomicilio(rs.getString("domicilio"));
                user.setTel(rs.getString("tel"));
                user.setSanctions(rs.getInt("sanctions"));
                user.setSanc_money(rs.getInt("sanc_money"));
                lista.add(user);
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
    @Override
    public Users getUserById(int userId) throws Exception {
        Users user = null;
        
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM users WHERE id = ? LIMIT 1;");
            st.setInt(1, userId);
            
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                user = new Users();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLast_name_p(rs.getString("last_name_p"));
                user.setLast_name_m(rs.getString("last_name_m"));
                user.setDomicilio(rs.getString("domicilio"));
                user.setTel(rs.getString("tel"));
                user.setSanctions(rs.getInt("sanctions"));
                user.setSanc_money(rs.getInt("sanc_money"));
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return user;
    }

    @Override
    public void sancionar(Users user) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE users SET sanctions = ?, sanc_money = ? WHERE id = ?");
            st.setInt(1, user.getSanctions());
            st.setInt(2, user.getSanc_money());
            st.setInt(3, user.getId());
            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
       @Override
    public int contarRegistros() throws Exception {
        int numeroRegistros = 0;
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("select count(*) from users");
            ResultSet r = st.executeQuery();
            if (r.first()) {
                numeroRegistros = r.getInt(1);
            }
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return numeroRegistros;
    }
       @Override
    public int contarRegistrosTrabajadores() throws Exception {
        int numeroRegistros = 0;
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("select count(*) from users where role = 'work' OR role = 'admin'");
            ResultSet r = st.executeQuery();
            if (r.first()) {
                numeroRegistros = r.getInt(1);
            }
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return numeroRegistros;
    }

    
}
