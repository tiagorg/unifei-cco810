package pacote_12643.visao;

import java.awt.Color;

import javax.swing.BorderFactory;

import pacote_12643.modelo.Parametrizacao;

/**
 * Panel placar das informa��es
 * @author Tiago
 */
@SuppressWarnings("serial")
public class PanelPlacar extends javax.swing.JPanel {
	/**
	 * Construtor.
	 */
	public PanelPlacar() {
		initComponents();
		
		// Escreve em branco.
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jLabelNomeValor.setText(String.format("%-10s", "          "));
		jLabelBolasValor.setText(String.format("%-1s", " "));
		jLabelNivelValor.setText(String.format("%-7s", "       "));
		jLabelPontuacaoValor.setText(String.format("%-4s", "    "));
		jLabelProximaValor.setText(String.format("%-4s", "    "));
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc=" Generated Code ">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jLabelNome = new javax.swing.JLabel();
		jLabelNomeValor = new javax.swing.JLabel();
		jLabelBolas = new javax.swing.JLabel();
		jLabelBolasValor = new javax.swing.JLabel();
		jLabelPontuacao = new javax.swing.JLabel();
		jLabelPontuacaoValor = new javax.swing.JLabel();
		jLabelNivel = new javax.swing.JLabel();
		jLabelNivelValor = new javax.swing.JLabel();
		jLabelProxima = new javax.swing.JLabel();
		jLabelProximaValor = new javax.swing.JLabel();

		setLayout(new java.awt.GridBagLayout());

		setBackground(new java.awt.Color(102, 102, 102));
		setBorder(new javax.swing.border.MatteBorder(null));
		jLabelNome.setForeground(new java.awt.Color(255, 255, 255));
		jLabelNome.setText("Nome:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		add(jLabelNome, gridBagConstraints);

		jLabelNomeValor.setForeground(new java.awt.Color(255, 255, 153));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.ipadx = 20;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		add(jLabelNomeValor, gridBagConstraints);

		jLabelBolas.setForeground(new java.awt.Color(255, 255, 255));
		jLabelBolas.setText("Bolas:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		add(jLabelBolas, gridBagConstraints);

		jLabelBolasValor.setForeground(new java.awt.Color(255, 255, 153));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		add(jLabelBolasValor, gridBagConstraints);

		jLabelPontuacao.setForeground(new java.awt.Color(255, 255, 255));
		jLabelPontuacao.setText("Pontua\u00e7\u00e3o:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		add(jLabelPontuacao, gridBagConstraints);

		jLabelPontuacaoValor.setForeground(new java.awt.Color(255, 255, 153));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 20;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		add(jLabelPontuacaoValor, gridBagConstraints);

		jLabelNivel.setForeground(new java.awt.Color(255, 255, 255));
		jLabelNivel.setText("N\u00edvel:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		add(jLabelNivel, gridBagConstraints);

		jLabelNivelValor.setForeground(new java.awt.Color(255, 255, 153));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		add(jLabelNivelValor, gridBagConstraints);

		jLabelProxima.setForeground(new java.awt.Color(255, 255, 255));
		jLabelProxima.setText("Para pr\u00f3xima fase:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		add(jLabelProxima, gridBagConstraints);

		jLabelProximaValor.setForeground(new java.awt.Color(255, 255, 153));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		add(jLabelProximaValor, gridBagConstraints);

	}// </editor-fold>//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabelBolas;
	private javax.swing.JLabel jLabelBolasValor;
	private javax.swing.JLabel jLabelNivel;
	private javax.swing.JLabel jLabelNivelValor;
	private javax.swing.JLabel jLabelNome;
	private javax.swing.JLabel jLabelNomeValor;
	private javax.swing.JLabel jLabelPontuacao;
	private javax.swing.JLabel jLabelPontuacaoValor;
	private javax.swing.JLabel jLabelProxima;
	private javax.swing.JLabel jLabelProximaValor;
	// End of variables declaration//GEN-END:variables
	
	// M�todos get
	public javax.swing.JLabel getJLabelBolasValor() {
		return jLabelBolasValor;
	}

	public javax.swing.JLabel getJLabelNivelValor() {
		return jLabelNivelValor;
	}

	public javax.swing.JLabel getJLabelNomeValor() {
		return jLabelNomeValor;
	}

	public javax.swing.JLabel getJLabelPontuacaoValor() {
		return jLabelPontuacaoValor;
	}

	public javax.swing.JLabel getJLabelProximaValor() {
		return jLabelProximaValor;
	}

	/**
	 * Preenche novo jogo.
	 * @param parametrizacao
	 */
	public void novoJogo(Parametrizacao parametrizacao) {
		jLabelNomeValor.setText(String.format("%-10s", parametrizacao.getNomeJogador()));
		jLabelBolasValor.setText(String.format("%-1d", parametrizacao.getNumeroBolas()));
		jLabelNivelValor.setText(String.format("%-7s", parametrizacao.getNivelDificuldade().toString()));
		jLabelPontuacaoValor.setText(String.format("%-4d", 0));
		jLabelProximaValor.setText(String.format("%-4d", parametrizacao.getPontuacaoNecessaria()));
	}

	/**
	 * Preenche resultados de uma fase.
	 * @param parametrizacao
	 */
	public void fimDeFase(Parametrizacao parametrizacao) {
		jLabelPontuacaoValor.setText(String.format("%-4d", parametrizacao.getPontuacao()));
		jLabelProximaValor.setText(String.format("%-4d", parametrizacao.getPontuacaoNecessaria()));
	}

}