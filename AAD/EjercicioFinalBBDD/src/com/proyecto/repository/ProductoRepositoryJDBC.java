package com.proyecto.repository;

import com.proyecto.model.Producto;
import com.proyecto.util.DatabaseConnection;

import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryJDBC implements Repository<Producto> {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getConnection();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        // try-with-resources [cite: 30]
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM productos")) {
            while (rs.next()) {
                Producto p = crearProducto(rs);
                productos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto porId(int id) {
        Producto p = null;
        String sql = "SELECT * FROM productos WHERE id = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    p = crearProducto(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void guardar(Producto producto) {
        String sql;
        // Diferenciar entre INSERT y UPDATE (upsert básico)
        if (producto.getId() > 0) {
            sql = "UPDATE productos SET nombre=?, precio=?, categoria_id=?, imagen=? WHERE id=?";
        } else {
            sql = "INSERT INTO productos (nombre, precio, categoria_id, imagen) VALUES (?,?,?,?)";
        }

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getCategoriaId());

            // Gestión de BLOB
            if (producto.getImagen() != null) {
                stmt.setBlob(4, new ByteArrayInputStream(producto.getImagen()));
            } else {
                stmt.setNull(4, Types.BLOB);
            }

            if (producto.getId() > 0) {
                stmt.setInt(5, producto.getId());
            }

            stmt.executeUpdate(); // [cite: 39]
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Aquí saltaría error si hay restricción FK
        }
    }

    private Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getInt("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getDouble("precio"));
        p.setCategoriaId(rs.getInt("categoria_id"));
        // Leer BLOB si se requiere
        // p.setImagen(rs.getBytes("imagen"));
        return p;
    }
}