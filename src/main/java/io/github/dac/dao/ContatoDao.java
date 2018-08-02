package io.github.dac.dao;

import io.github.dac.factories.Conexao;
import io.github.dac.models.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContatoDao implements ContatoDaoInterface {

    private final Connection conn;

    public ContatoDao() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    @Override
    public boolean salvar(Contato contato) {
        String sql = "INSERT INTO Contato(Nome, Email, Telefone, dataNascimento) VALUES (?,?,?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getTelefone());
            stmt.setObject(4, contato.getDataNascimento());

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remover(Contato contato) {
        String sql = "DELETE FROM Contato WHERE email = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contato.getEmail());

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean atualizar(Contato contato) {
        String sql = "UPDATE contato SET nome = ?, telefone = ? , dataNascimento = ? WHERE email = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getTelefone());
            stmt.setObject(4, contato.getDataNascimento());

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Contato> listar() {
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM contato order by nome asc";
            stmt = conn.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        try {
            return criarContato(stmt);
        } catch (SQLException ex1) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex1);
        }
        return Collections.emptyList();
    }

    @Override
    public List<Contato> listarPorLetra(String nome) {

        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM contato WHERE nome ILIKE ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome + "%");
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return criarContato(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Collections.emptyList();
    }

    @Override
    public List<Contato> recuperarByNome(String nome) {
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM contato WHERE nome ILIKE ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome + "%");
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return criarContato(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Collections.emptyList();
    }

    private List<Contato> criarContato(PreparedStatement stmt) throws SQLException {
        List<Contato> contatos = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            Contato c = new Contato(
                    resultSet.getString("nome"),
                    resultSet.getString("email"),
                    resultSet.getString("telefone"),
                    resultSet.getObject("dataNascimento", LocalDate.class)
            );
            contatos.add(c);
        }
        
        return contatos;
    }

}
