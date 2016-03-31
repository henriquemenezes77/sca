package br.edu.iffarroupilha.sca.view.desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.edu.iffarroupilha.sca.controle.AlunoControle;
import br.edu.iffarroupilha.sca.modelo.Aluno;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DropMode;

/**
 * <p>
 * Interface para cadastro e edição de alunos
 * </p>
 * 
 * @author Henrique
 * @since 22/03/16 21:43
 */
public class FrmAluno extends JFrame {

	private JTable table;
	private JTextField jtfMatricula;
	private JTextField jtfTelefone;
	private JTextField jtfEmail;
	private JTextField jtfData;

	public FrmAluno() {
		setTitle("Cadastro Aluno");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		desenhaComponentes();
		populaTabela();
		setVisible(true);
	}

	private void populaTabela() {
		AlunoControle controle = new AlunoControle();
		List alunos = controle.listar(Aluno.class);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for (Object obj : alunos) {
			Aluno aux = (Aluno) obj;
			Object linha[] = new Object[5];
			linha[0] = aux.getNome();
			linha[1] = aux.getMatricula();
			linha[2] = aux.getTelefone();
			linha[3] = aux.getEmail();
			linha[4] = aux.getDataNascimento();
			modelo.addRow(linha);
		}
	}

	private void desenhaComponentes() {
		JLabel lblNome = new JLabel("Nome: ");
		final JTextField jtfNome = new JTextField("", 20);
		JButton btnGravar = new JButton("Gravar");

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblMatricula = new JLabel("Matricula:");

		jtfMatricula = new JTextField();
		jtfMatricula.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");

		JLabel lblEmail = new JLabel("Email:");

		JLabel lblDataNasc = new JLabel("Data Nasc.");

		jtfTelefone = new JTextField();
		jtfTelefone.setColumns(10);

		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);

		jtfData = new JTextField();
		jtfData.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup().addGap(90)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblDataNasc)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(btnGravar)
										.addComponent(scrollPane,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(
												Alignment.LEADING,
												groupLayout.createSequentialGroup().addComponent(lblMatricula)
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(
																jtfMatricula))
										.addGroup(Alignment.LEADING,
												groupLayout.createSequentialGroup().addComponent(lblNome).addGap(18)
														.addComponent(jtfNome, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.LEADING,
												groupLayout.createSequentialGroup()
														.addGroup(
																groupLayout.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblTelefone)
																		.addComponent(lblEmail))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(jtfEmail, GroupLayout.DEFAULT_SIZE, 168,
																		Short.MAX_VALUE)
																.addComponent(jtfTelefone)
																.addComponent(jtfData, GroupLayout.DEFAULT_SIZE, 168,
																		Short.MAX_VALUE)))))
						.addContainerGap(82, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(6)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNome).addComponent(
						jtfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblMatricula).addComponent(
						jtfMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblTelefone).addComponent(
						jtfTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblEmail).addComponent(
						jtfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblDataNasc).addComponent(
						jtfData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(36).addComponent(btnGravar).addGap(18)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(24, Short.MAX_VALUE)));

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Matricula", "Telefone", "Email", "Data Nasc." }) {
			Class[] columnTypes = new Class[] { String.class, Integer.class, String.class, String.class, Date.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		btnGravar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Aluno a = new Aluno();
				a.setNome(jtfNome.getText());
				a.setTelefone(jtfTelefone.getText());
				a.setEmail(jtfEmail.getText());
				SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
				try {
					Date data = dt.parse(jtfData.getText());
					a.setDataNascimento(data);
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Data de nascimento inválida!!");
					e1.printStackTrace();
				}
				new AlunoControle().gravar(a);
				JOptionPane.showMessageDialog(null, "Gravado com sucesso");
				populaTabela();
			}
		});

	}

	public static void main(String[] args) {
		new FrmAluno();
	}
}
