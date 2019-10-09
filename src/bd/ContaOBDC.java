/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Conta;

/**
 *
 * @author brunotrindade
 */
public class ContaOBDC {

    private MyJDBC pgDB = new MyJDBC();

    public void inserirConta(Conta conta) throws Exception {

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
            PreparedStatement stmt = con.prepareStatement("INSERT INTO contacorrente.contas (banco_conta, agencia_conta, numero_conta, saldo_inicial_conta, situacao_conta) VALUES( ?,  ?,  ?,  ?,  ?)");

            stmt.setInt(1, conta.getBancoConta());
            stmt.setInt(2, conta.getAgenciaConta());
            stmt.setString(3, conta.getNumeroConta());
            stmt.setFloat(4, conta.getSaldoInicialConta());
            stmt.setString(5, conta.getSituacaoConta());
            stmt.executeUpdate();
            stmt.close();
            con.commit();

            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir novo registro.");
            System.err.println(e.getMessage());
        }
    }

    public List<Conta> listarConta() throws Exception {

        pgDB = new MyJDBC();
        if (pgDB.conecta() == false) {
            throw new Exception("Falha ao conectar no banco de dados");
        }

        if (pgDB == null) {
            throw new Exception("Falha ao conectar no banco de dados");
        }

        Connection con = pgDB.getConnection();

        try {
            String sql_str = "SELECT * FROM contas";
            PreparedStatement comando = con.prepareStatement(sql_str);
            ResultSet rs = comando.executeQuery();
            List<Conta> listConta = new ArrayList<>();
            while (rs.next()) {
                Conta conta = new Conta();
                conta.setIdConta(rs.getInt("id_conta"));
                conta.setBancoConta(rs.getInt("banco_conta"));
                conta.setAgenciaConta(rs.getInt("agencia_conta"));
                conta.setNumeroConta(rs.getString("numero_conta"));
                conta.setSaldoInicialConta(rs.getFloat("saldo_inicial_conta"));
                conta.setSituacaoConta(rs.getString("situacao_conta"));
                listConta.add(conta);
            }
            comando.close();
            rs.close();
            return listConta;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir novo registro.");
            System.err.println(e.getMessage());
        }
        return null;
    }

}
