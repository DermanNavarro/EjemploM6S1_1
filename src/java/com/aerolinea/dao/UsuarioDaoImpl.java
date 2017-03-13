package com.aerolinea.dao;

import com.aerolinea.entidad.Pais;
import com.aerolinea.entidad.Rol;
import com.aerolinea.entidad.Usuario;
import com.aerolinea.util.HibernateUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDaoImpl implements UsuarioDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void guardarUsuario(Usuario u) {
        Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            s.saveOrUpdate(u);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            s.close();
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        List<Usuario> lista = null;
        Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("SELECT u FROM Usuario u JOIN FETCH u.pais JOIN FETCH u.rol");
            lista = q.list();

            s.getTransaction().commit();

            return lista;
        } catch (Exception e) {
            return null;
        } finally {
            s.close();
        }
    }

    @Override
    public Usuario validarUsuario(Usuario u) {
        Usuario usuario = null;
//        Session s = HibernateUtil.getSessionFactory().openSession(); //Administrar conexiones manual mente en hybernate
        Session s = sessionFactory.openSession();

        try {
            s.beginTransaction();
            Query q = s.createQuery("SELECT u FROM Usuario u WHERE idusuario=:usuario AND clave=:clave");

            q.setParameter("usuario", u.getIdusuario());
            q.setParameter("clave", sha1(u.getClave()));

            usuario = (Usuario) q.uniqueResult();
            s.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            s.close();
        }
        return usuario;
    }

    @Override
    public List<Rol> getRoles() {
        List<Rol> lista = null;
        Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("FROM Rol");
            lista = q.list();

            s.getTransaction().commit();

            return lista;
        } catch (Exception e) {
            return null;
        } finally {
            s.close();
        }
    }

    @Override
    public List<Pais> getPaises() {
        List<Pais> lista = null;
        Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("FROM Pais");
            lista = q.list();

            s.getTransaction().commit();

            return lista;
        } catch (Exception e) {
            return null;
        } finally {
            s.close();
        }
    }

    @Override
    public Usuario getUsuario(String id) {
        Usuario u;
        Session s = sessionFactory.openSession();
        
        try {
            s.beginTransaction();
            Query q = s.createQuery("SELECT u FROM Usuario u WHERE idusuario=:id");
            q.setParameter("id", id);
            u = (Usuario) q.uniqueResult();

            s.getTransaction().commit();

            return u;
        } catch (Exception e) {
            return null;
        } finally {
            s.close();
        }
    }

    @Override
    public void EliminarUsuario(String id) {
        Usuario u = new Usuario();
        u.setIdusuario(id);
        Session s = sessionFactory.openSession();
        
        try {
            s.beginTransaction();          
            s.delete(u);
            s.getTransaction().commit();

        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            s.close();
        }
    }

    public static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}
