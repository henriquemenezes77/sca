package br.edu.iffarroupilha.sca.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.SwingWorker.StateValue;

/**
 * <p>
 * Entidade aluno persistida em banco de dados
 * </p>
 * @author Henrique
 * @since 09/03/16
 */
@Entity
public class Aluno {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int matricula;
	@Column(nullable=false, length=50)
	private String nome;
	@Column(length=100)
	private String email;
	@Column(length=15)
	private String telefone;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	@ManyToOne
	@JoinColumn(name="idTurma")
	private Turma turma;
	
	public int getMatricula() {
		return matricula;
	}
	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}