/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entidade.Conta;
import entidade.Conta_;
import entidade.Movimentacoes;
import enums.EnumTipoMovimentacao;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import repository.ContaRepository;
import repository.MovimentacoesRepository;

/**
 *
 * @author brunotrindade
 */
public class OperacoesConta extends javax.swing.JFrame {

    /**
     * Creates new form OperacoesConta
     */
    private final static String REGEX_ONLY_NUMBER = "[0-9]+";
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ControleBancoJPAPU");
    EntityManager manager = factory.createEntityManager();

    public OperacoesConta() {
        initComponents();
        this.atualizarLista();
        this.atualizarListaOperacao();
    }

    public void atualizarListaOperacao() {
        try {
            jComboOperacao.removeAllItems();
            for (EnumTipoMovimentacao tipo : EnumTipoMovimentacao.values()) {
                jComboOperacao.addItem(tipo.name());
            }

        } catch (Exception ex) {
            Logger.getLogger(ControleDeConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizarLista() {
        try {
            jComboContas.removeAllItems();
            ContaRepository persitenciaConta = new ContaRepository(manager);
            List<Conta> lista = persitenciaConta.buscarTodas();
            lista.forEach((conta) -> {
                jComboContas.addItem(conta.getId_conta().toString());
            });

        } catch (Exception ex) {
            Logger.getLogger(ControleDeConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validarCampos() {

        if (tfValor.getText().isEmpty() || !tfValor.getText().matches(REGEX_ONLY_NUMBER)) {
            JOptionPane.showMessageDialog(rootPane, "Campo valor deve ser diferente de nulo");
            return false;
        }

        if (jComboOperacao.getSelectedItem() == "SAQUE") {
            Conta conta = new Conta();
            ContaRepository contaRepo = new ContaRepository(manager);
            conta = contaRepo.consultarPorId(Long.valueOf(jComboContas.getSelectedItem().toString()));
            if (conta.getSaldo_inicial_conta() < Double.valueOf(tfValor.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Saldo insuficiente");
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCentral = new javax.swing.JPanel();
        pnInferior = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();
        pnTitulo = new javax.swing.JPanel();
        lbPrincipal = new javax.swing.JLabel();
        pnTabela = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboContas = new javax.swing.JComboBox<>();
        lbBanco = new javax.swing.JLabel();
        jComboOperacao = new javax.swing.JComboBox<>();
        lbConta = new javax.swing.JLabel();
        tfValor = new javax.swing.JTextField();
        lbDescricao = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        btCriar = new javax.swing.JButton();
        btExtrato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnCentral.setBackground(new java.awt.Color(255, 255, 255));
        pnCentral.setBorder(new javax.swing.border.MatteBorder(null));
        pnCentral.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnInferior.setBackground(new java.awt.Color(0, 0, 255));
        pnInferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnInferior.setPreferredSize(new java.awt.Dimension(360, 70));

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        pnInferior.add(btVoltar);

        pnTitulo.setBackground(new java.awt.Color(51, 51, 255));
        pnTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbPrincipal.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        lbPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        lbPrincipal.setText("Operações");
        pnTitulo.add(lbPrincipal);

        pnTabela.setBackground(new java.awt.Color(255, 255, 255));
        pnTabela.setLayout(new java.awt.GridLayout(8, 2, 25, 1));

        jLabel3.setText("Conta:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        pnTabela.add(jLabel3);

        jComboContas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboContasItemStateChanged(evt);
            }
        });
        jComboContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboContasActionPerformed(evt);
            }
        });
        pnTabela.add(jComboContas);

        lbBanco.setText("Operação:");
        lbBanco.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pnTabela.add(lbBanco);

        jComboOperacao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboOperacaoItemStateChanged(evt);
            }
        });
        jComboOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboOperacaoActionPerformed(evt);
            }
        });
        pnTabela.add(jComboOperacao);

        lbConta.setText("Valor:");
        lbConta.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        pnTabela.add(lbConta);

        tfValor.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        tfValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValorActionPerformed(evt);
            }
        });
        pnTabela.add(tfValor);

        lbDescricao.setText("Descricao:");
        lbDescricao.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        pnTabela.add(lbDescricao);

        tfDescricao.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        tfDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDescricaoActionPerformed(evt);
            }
        });
        pnTabela.add(tfDescricao);

        btCriar.setText("Realizar Op");
        btCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCriarActionPerformed(evt);
            }
        });

        btExtrato.setText("Extrato");
        btExtrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExtratoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCentralLayout = new javax.swing.GroupLayout(pnCentral);
        pnCentral.setLayout(pnCentralLayout);
        pnCentralLayout.setHorizontalGroup(
            pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnInferior, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
            .addComponent(pnTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnCentralLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCentralLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btCriar)
                        .addGap(18, 18, 18)
                        .addComponent(btExtrato))
                    .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCentralLayout.setVerticalGroup(
            pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCentralLayout.createSequentialGroup()
                .addComponent(pnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCriar)
                    .addComponent(btExtrato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed

        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void jComboContasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboContasItemStateChanged

    }//GEN-LAST:event_jComboContasItemStateChanged

    private void jComboContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboContasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboContasActionPerformed

    private void jComboOperacaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboOperacaoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboOperacaoItemStateChanged

    private void jComboOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboOperacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboOperacaoActionPerformed

    private void tfValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfValorActionPerformed

    private void tfDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDescricaoActionPerformed

    private void btCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCriarActionPerformed

        if (validarCampos()) {
            Conta conta = new Conta();
            ContaRepository contaRepo = new ContaRepository(manager);
            conta = contaRepo.consultarPorId(Long.valueOf(jComboContas.getSelectedItem().toString()));
            Double valorOperacao = Double.valueOf(tfValor.getText());
            Double novoSaldo = 0.0;
            Integer contaMov = Integer.parseInt(jComboContas.getSelectedItem().toString());
            String tipoOp = "";
            String complemento = "";
            switch (jComboOperacao.getSelectedItem().toString()) {
                case "SAQUE":
                    tipoOp = EnumTipoMovimentacao.SAQUE.getCodigo();
                    complemento = "Operacao de saque";
                    novoSaldo = conta.getSaldo_inicial_conta() - valorOperacao;
                    break;
                case "DEPOSITO":
                    tipoOp = EnumTipoMovimentacao.DEPOSITO.getCodigo();
                    complemento = "Operacao de deposito";
                    novoSaldo = conta.getSaldo_inicial_conta() + valorOperacao;
                    break;
             
            }

            String descricao = tfDescricao.getText();
            Date dataMovimentao = new Date();
            conta.setSaldo_inicial_conta(novoSaldo);
            Movimentacoes mov = new Movimentacoes(contaMov, tipoOp, descricao, dataMovimentao, valorOperacao, complemento);
            contaRepo.alterarConta(conta);
            MovimentacoesRepository movRepo = new MovimentacoesRepository(manager);
            movRepo.inserirMovimentacao(mov);
            System.out.println("Registro inserido com sucesso");
            this.limparCampos();
        }
    }//GEN-LAST:event_btCriarActionPerformed

    private void btExtratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExtratoActionPerformed
       MovimentacoesRepository movRepo = new MovimentacoesRepository(manager);
      
        List<Movimentacoes> listaMovimentacoes;
        listaMovimentacoes = movRepo.listarMovimentacaoes(Long.valueOf(jComboContas.getSelectedItem().toString()));
        for(Movimentacoes mov: listaMovimentacoes){
            System.out.print(mov);
        }
        
    }//GEN-LAST:event_btExtratoActionPerformed
    
    public void limparCampos(){
        this.tfDescricao.setText(null);
        this.tfValor.setText(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OperacoesConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OperacoesConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OperacoesConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OperacoesConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OperacoesConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCriar;
    private javax.swing.JButton btExtrato;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> jComboContas;
    private javax.swing.JComboBox<String> jComboOperacao;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbBanco;
    private javax.swing.JLabel lbConta;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbPrincipal;
    private javax.swing.JPanel pnCentral;
    private javax.swing.JPanel pnInferior;
    private javax.swing.JPanel pnTabela;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
