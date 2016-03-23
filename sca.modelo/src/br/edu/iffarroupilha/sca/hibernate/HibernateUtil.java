package br.edu.iffarroupilha.sca.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.edu.iffarroupilha.sca.modelo.Aluno;
import br.edu.iffarroupilha.sca.modelo.Turma;

/**
 * <p>
 * classe utilitaria para gerir objetos de conex�o com o banco de dados
 * relacional. utiliza-se como baes para a infraestrutura o framework Hibernate,
 * aplicando-se o padr�o singleton
 * </p>
 * 
 * @author Henrique
 *
 */
public class HibernateUtil {
	private static final SessionFactory fabrica = construirFabrica();

	private static SessionFactory construirFabrica() {
		/**
		 * <p>
		 * Metodo que cria uma fabrica a partir do arquivo de configura��o
		 * hibernate.proprierties
		 * </p>
		 */
		Configuration cfg = new Configuration();
		// adiciona as classes (entidades) anotadas
		cfg.addAnnotatedClass(Aluno.class);
		cfg.addAnnotatedClass(Turma.class);
		return cfg.buildSessionFactory();
	}

	/**
	 * <p>
	 * Retorna a fabrica de sess�o, atraves desta � possivel criar e gerenciar
	 * as sessoes de acesso ao banco de dados.
	 * </p>
	 * 
	 */
	public static SessionFactory getFabrica() {
		return fabrica;
	}
}
