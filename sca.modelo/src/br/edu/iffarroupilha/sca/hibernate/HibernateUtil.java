package br.edu.iffarroupilha.sca.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.edu.iffarroupilha.sca.modelo.Aluno;
import br.edu.iffarroupilha.sca.modelo.Turma;

/**
 * <p>
 * Classe utilit�ria para gerir objetos de conex�o com banco de dados
 * relacional. Utiliza-se como base para a infraestrutura o framework hibernate
 * aplicando-se o padr�o singleton
 * </p>
 * 
 * @author Henrique
 * @since 15/03/2016 21:32
 */
public class HibernateUtil {

	private static final SessionFactory fabrica = construirFabrica();

	/**
	 * <p>
	 * Metodo que cria uma fabrica a partir do arquivo de configura��o
	 * hibernate.properties
	 * </p>
	 * 
	 * @return
	 */
	private static SessionFactory construirFabrica() {
		Configuration cfg = new Configuration();
		// adiciona as classes (entidades) anotadas
		cfg.addAnnotatedClass(Aluno.class);
		cfg.addAnnotatedClass(Turma.class);
		cfg.configure();
		return cfg.buildSessionFactory();
	}

	/**
	 * <p>
	 * Retorna a fabrica de sess�o, atraves desta � possivel criar e gerenciar
	 * sess�es de acesso ao banco de dados
	 * </p>
	 */
	public static SessionFactory getFabrica() {
		return fabrica;
	}

	
	
	
}