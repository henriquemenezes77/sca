package br.edu.iffarroupilha.sca.controle;

import java.util.Date;

import org.hibernate.Session;

import br.edu.iffarroupilha.sca.hibernate.HibernateUtil;
import br.edu.iffarroupilha.sca.modelo.Aluno;
import br.edu.iffarroupilha.sca.modelo.Turma;

public class ProgramaTeste {
	public static void main(String[] args) {
		Session sessao = HibernateUtil.getFabrica().openSession();
		Turma t = new Turma();
		Aluno a = new Aluno();
		
		a.setNome("henrique");
		a.setDataNascimento(new Date());
		a.setTurma(t);
		t.setDescricao("Turma SI 2013");
		
		sessao.beginTransaction();
		sessao.save(t);
		sessao.save(a);
		sessao.getTransaction().commit();
		HibernateUtil.getFabrica().close();
	}
}
