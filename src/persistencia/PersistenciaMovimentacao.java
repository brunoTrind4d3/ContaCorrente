/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import bd.MyJDBC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Movimentacao;

/**
 *
 * @author brunotrindade
 */
public class PersistenciaMovimentacao {

    private MyJDBC pgDB = new MyJDBC();

    public void inserirMovimentcao(Movimentacao movimentacao) throws Exception {

        pgDB = new MyJDBC();
        if (pgDB.conecta() == false) {
            throw new Exception("Falha ao conectar no banco de dados");
        }

        if (pgDB == null) {
            throw new Exception("Falha ao conectar no banco de dados");
        }

        Connection con = pgDB.getConnection();

        try {
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO contacorrente.movimentacao (conta_mov, tipo_mov, descricao_mov, data_mov, valor_mov, complemento_mov) VALUES( ?,  ?,  ?,  ?,  ?, ?)");

            stmt.setInt(1, movimentacao.getContaMovimentacao());
            stmt.setString(2, movimentacao.getTipoMovimentacao());
            stmt.setString(3, movimentacao.getDescricaoMovimentacao());
            stmt.setDate(4, (Date) movimentacao.getDataMovimentacao());
            stmt.setFloat(5, movimentacao.getValorMovimentacao());
            stmt.setString(6, movimentacao.getComplementoMovimentacao());
            stmt.executeUpdate();
            stmt.close();
            con.commit();

            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir novo registro.");
            System.err.println(e.getMessage());
        }
    }

    public List<Movimentacao> listarMovimentacao() throws Exception {

        pgDB = new MyJDBC();
        if (pgDB.conecta() == false) {
            throw new Exception("Falha ao conectar no banco de dados");
        }

        if (pgDB == null) {
            throw new Exception("Falha ao conectar no banco de dados");
        }

        Connection con = pgDB.getConnection();

        try {
            String sql_str = "SELECT * FROM contacorrente.movimentacoes";
            PreparedStatement comando = con.prepareStatement(sql_str);
            ResultSet rs = comando.executeQuery();
            List<Movimentacao> listaMov = new ArrayList<>();
            while (rs.next()) {
                Movimentacao movimentacao = new Movimentacao();
                movimentacao.setIdMovimentacao(rs.getInt("id_mov"));
                movimentacao.setContaMovimentacao(rs.getInt("conta_mov"));
                movimentacao.setTipoMovimentacao(rs.getString("tipo_mov"));
                movimentacao.setDescricaoMovimentacao(rs.getString("descricao_mov"));
                movimentacao.setDataMovimentacao(rs.getDate("data_mov"));
                movimentacao.setValorMovimentacao(rs.getFloat("valor_mov"));
                movimentacao.setComplementoMovimentacao(rs.getString("complemento_mov"));
                listaMov.add(movimentacao);
            }
            comando.close();
            rs.close();
            return listaMov;
        } catch (SQLException e) {
            System.err.println("Erro ao consultar registro.");
            System.err.println(e.getMessage());
        }
        return null;
    }
    public void alterarMovimentacao(Movimentacao movimentacao) throws Exception {

        pgDB = new MyJDBC();
        if (pgDB.conecta() == false) {
            throw new Exception("Falha ao conectar no banco de dados");
        }

        if (pgDB == null) {
            throw new Exception("Falha ao conectar no banco de dados");
        }

        Connection con = pgDB.getConnection();

        try {
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement("UPDATE contacorrente.movimentacoes SET (conta_mov, tipo_mov, descricao_mov, data_mov, valor_mov, complemento_mov)  = ( ?,  ?,  ?,  ?,  ?,?) where id_conta = ? ");

              stmt.setInt(1, movimentacao.getContaMovimentacao());
            stmt.setString(2, movimentacao.getTipoMovimentacao());
            stmt.setString(3, movimentacao.getDescricaoMovimentacao());
            stmt.setDate(4, (Date) movimentacao.getDataMovimentacao());
            stmt.setFloat(5, movimentacao.getValorMovimentacao());
            stmt.setString(6, movimentacao.getComplementoMovimentacao());
            stmt.executeUpdate();
            stmt.close();
            con.commit();

            System.out.println("Registro alterado com sucesso");
        } catch (SQLException e) {
            System.err.println("Erro ao alterar o registro.");
            System.err.println(e.getMessage());
        }
    }

}