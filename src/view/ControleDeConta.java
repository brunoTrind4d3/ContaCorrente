/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import enums.EnumBanco;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import entidade.Conta;
import enums.EnumTipoMovimentacao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import repository.ContaRepository;

/**
 *
 * @author aluno
 */
public class ControleDeConta extends javax.swing.JFrame {

    private final static String REGEX_ONLY_NUMBER = "[0-9]+";
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ControleBancoJPAPU");
    EntityManager manager = factory.createEntityManager();

    public ControleDeConta() throws IOException {
        initComponents();
        this.atualizarLista();
        this.preencherComboBanco();
    }

    public void preencherComboBanco() {
        for (EnumBanco banco : EnumBanco.values()) {
            jComboBanco.addItem(banco.name());
        }
    }

    public int selecionarValorBanco(String comboSelected) {
        switch (jComboBanco.getSelectedItem().toString().trim()) {
            case "ITAU":
                return EnumBanco.ITAU.getCodigo();

            case "BRADESCO":
                return EnumBanco.BRADESCO.getCodigo();

            case "CAIXA":
                return EnumBanco.CAIXA.getCodigo();

            case "SICOOB":
                return EnumBanco.SICOOB.getCodigo();

            case "SANTANDER":
                return EnumBanco.SANTANDER.getCodigo();

        }
        return 0;
    }

    public String verificarNomeBanco(int codigoBanco) {
        switch (codigoBanco) {
            case 1:
                return EnumBanco.ITAU.name();
            case 2:
                return EnumBanco.SANTANDER.name();
            case 3:
                return EnumBanco.BRADESCO.name();
            case 4:
                return EnumBanco.CAIXA.name();
            case 5:
                return EnumBanco.SICOOB.name();
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        pnCentral = new javax.swing.JPanel();
        pnInferior = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();
        pnTitulo = new javax.swing.JPanel();
        lbPrincipal = new javax.swing.JLabel();
        pnTabela = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboContas = new javax.swing.JComboBox<>();
        lbBanco = new javax.swing.JLabel();
        jComboBanco = new javax.swing.JComboBox<>();
        lbConta = new javax.swing.JLabel();
        tfConta = new javax.swing.JTextField();
        lbAgencia = new javax.swing.JLabel();
        tfAgencia = new javax.swing.JTextField();
        rdAtiva = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        rdInativa = new javax.swing.JRadioButton();
        tfSaldoInicial = new javax.swing.JTextField();
        brCriar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

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
        lbPrincipal.setText("Cadastrar Conta");
        pnTitulo.add(lbPrincipal);

        pnTabela.setBackground(new java.awt.Color(255, 255, 255));
        pnTabela.setLayout(new java.awt.GridLayout(8, 2, 25, 1));

        jLabel3.setText("Id Contas:");
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

        lbBanco.setText("Banco:");
        lbBanco.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pnTabela.add(lbBanco);

        jComboBanco.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBancoItemStateChanged(evt);
            }
        });
        jComboBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBancoActionPerformed(evt);
            }
        });
        pnTabela.add(jComboBanco);

        lbConta.setText("Conta:");
        lbConta.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        pnTabela.add(lbConta);

        tfConta.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        pnTabela.add(tfConta);

        lbAgencia.setText("Agência:");
        lbAgencia.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        pnTabela.add(lbAgencia);

        tfAgencia.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        pnTabela.add(tfAgencia);

        rdAtiva.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdAtiva);
        rdAtiva.setText("Ativa");
        pnTabela.add(rdAtiva);

        jLabel1.setText("Saldo Inicial:");
        pnTabela.add(jLabel1);

        rdInativa.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdInativa);
        rdInativa.setText("Inativa");
        rdInativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdInativaActionPerformed(evt);
            }
        });
        pnTabela.add(rdInativa);

        tfSaldoInicial.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        pnTabela.add(tfSaldoInicial);

        brCriar.setBackground(new java.awt.Color(255, 255, 255));
        brCriar.setText("Criar");
        brCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brCriarActionPerformed(evt);
            }
        });
        pnTabela.add(brCriar);

        btAlterar.setBackground(new java.awt.Color(255, 255, 255));
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        pnTabela.add(btAlterar);

        javax.swing.GroupLayout pnCentralLayout = new javax.swing.GroupLayout(pnCentral);
        pnCentral.setLayout(pnCentralLayout);
        pnCentralLayout.setHorizontalGroup(
            pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnInferior, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
            .addComponent(pnTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnCentralLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCentralLayout.setVerticalGroup(
            pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCentralLayout.createSequentialGroup()
                .addComponent(pnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void brCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brCriarActionPerformed
        try {
            if (this.validarCampos()) {

                Integer contaBanco = selecionarValorBanco(jComboBanco.getSelectedItem().toString().trim());
                Integer agenciaBanco = Integer.parseInt(tfAgencia.getText());
                String conta = tfConta.getText();
                Float saldoInicial = Float.parseFloat(tfSaldoInicial.getText());
                String situacaoConta = "a";

                Conta contaCorrente = new Conta(contaBanco, agenciaBanco, conta, saldoInicial, situacaoConta);
                ContaRepository contaObdc = new ContaRepository(manager);
                contaObdc.inserirConta(contaCorrente);
                limparCampos();
                atualizarLista();
                System.out.println("Registro Criado");
            }
        } catch (Exception ex) {
            Logger.getLogger(ControleDeConta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_brCriarActionPerformed

    private void rdInativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdInativaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdInativaActionPerformed

    private void jComboContasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboContasItemStateChanged
        if (jComboContas.getItemCount() != 0) {

            if (!jComboContas.getSelectedItem().equals("Incluir")) {
                this.preencherDados(jComboContas.getSelectedItem().toString());
                this.brCriar.setEnabled(false);
                this.rdInativa.setEnabled(true);
                this.btAlterar.setEnabled(true);
            } else {
                this.limparCampos();
                this.rdInativa.setEnabled(false);
                this.brCriar.setEnabled(true);
                this.btAlterar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jComboContasItemStateChanged

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        try {
            if (validarCampos()) {
                Integer contaBanco = selecionarValorBanco(jComboBanco.getSelectedItem().toString().trim());
                Integer agenciaBanco = Integer.parseInt(tfAgencia.getText());
                String conta = tfConta.getText();
                Float saldoInicial = Float.parseFloat(tfSaldoInicial.getText());
                Long idConta = Long.valueOf(jComboContas.getSelectedItem().toString());
                String situacaoConta;
                if (rdAtiva.isSelected()) {
                     situacaoConta = "a";
                }else{
                     situacaoConta = "i";
                }

                Conta contaCorrente = new Conta(idConta, contaBanco, agenciaBanco, conta, saldoInicial, situacaoConta);
                ContaRepository contaObdc = new ContaRepository(manager);
                contaObdc.alterarConta(contaCorrente);
                limparCampos();
                atualizarLista();
            }
        } catch (Exception ex) {
            Logger.getLogger(ControleDeConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void jComboContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboContasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboContasActionPerformed

    private void jComboBancoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBancoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBancoItemStateChanged

    private void jComboBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBancoActionPerformed

    public void preencherDados(String conta) {
        try {
            ContaRepository pConta = new ContaRepository(manager);
            Conta contaCorrente;
            contaCorrente = pConta.consultarPorId(Long.valueOf(conta));

            tfConta.setText(contaCorrente.getNumero_conta());
            tfAgencia.setText(String.valueOf(contaCorrente.getAgencia_conta()));
            jComboBanco.setSelectedItem(verificarNomeBanco(contaCorrente.getBanco_conta()));
            tfSaldoInicial.setText(Double.toString(contaCorrente.getSaldo_inicial_conta()));
            if (contaCorrente.getSituacao_conta().equals("a")) {
                rdAtiva.setSelected(true);
                rdInativa.setSelected(false);
            } else {
                rdAtiva.setSelected(true);
                rdInativa.setSelected(true);
            }

        } catch (Exception ex) {
            Logger.getLogger(ControleDeConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparCampos() {
        this.tfAgencia.setText(null);
        this.tfAgencia.setText(null);
        this.tfSaldoInicial.setText(null);
        this.tfConta.setText(null);
        this.rdAtiva.setSelected(true);
    }

    public void atualizarLista() {
        try {
            jComboContas.removeAllItems();
            ContaRepository persitenciaConta = new ContaRepository(manager);
            List<Conta> lista = persitenciaConta.buscarTodas();
            jComboContas.addItem("Incluir");
            lista.forEach((conta) -> {
                jComboContas.addItem(conta.getId_conta().toString());
            });

        } catch (Exception ex) {
            Logger.getLogger(ControleDeConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validarCampos() {

        if (tfAgencia.getText().isEmpty() || !tfAgencia.getText().matches(REGEX_ONLY_NUMBER)) {
            JOptionPane.showMessageDialog(rootPane, "Campo agência deve ser diferente de nulo");
            return false;
        }
        if (tfConta.getText().isEmpty() || !tfConta.getText().matches(REGEX_ONLY_NUMBER)) {
            JOptionPane.showMessageDialog(rootPane, "Campo conta deve ser diferente de nulo");
            return false;
        }

        if (tfSaldoInicial.getText().isEmpty() || !tfSaldoInicial.getText().matches(REGEX_ONLY_NUMBER)) {
            JOptionPane.showMessageDialog(rootPane, "Campo saldo inicial deve ser diferente de nulo");
            return false;
        }
        return true;
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
            java.util.logging.Logger.getLogger(ControleDeConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleDeConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleDeConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleDeConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ControleDeConta().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ControleDeConta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brCriar;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBanco;
    private javax.swing.JComboBox<String> jComboContas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbAgencia;
    private javax.swing.JLabel lbBanco;
    private javax.swing.JLabel lbConta;
    private javax.swing.JLabel lbPrincipal;
    private javax.swing.JPanel pnCentral;
    private javax.swing.JPanel pnInferior;
    private javax.swing.JPanel pnTabela;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JRadioButton rdAtiva;
    private javax.swing.JRadioButton rdInativa;
    private javax.swing.JTextField tfAgencia;
    private javax.swing.JTextField tfConta;
    private javax.swing.JTextField tfSaldoInicial;
    // End of variables declaration//GEN-END:variables
}
