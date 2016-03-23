package br.edu.iffarroupilha.sca.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.edu.iffarroupilha.sca.modelo.Aluno;
import br.edu.iffarroupilha.sca.modelo.Turma;

/**
 * <p>
 * classe utilitaria para gerir objetos de conexão com o banco de dados
 * relacional. utiliza-se como baes para a infraestrutura o framework Hibernate,
 * aplicando-se o padrão singleton
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
		 * Metodo que cria uma fabrica a partir do arquivo de configuração
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
	 * Retorna a fabrica de sessão, atraves desta é possivel criar e gerenciar
	 * as sessoes de acesso ao banco de dados.
	 * </p>
	 * 
	 */
	public static SessionFactory getFabrica() {
		return fabrica;
	}
}
