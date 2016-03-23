package br.edu.iffarroupilha.sca.controle;

import java.util.List;

import org.hibernate.Session;

import br.edu.iffarroupilha.sca.hibernate.HibernateUtil;

/**
 * <p>
 * Classe abstrata que concentra as opções padrões de operação para entidades.
 * </p>
 *
 * @author Henrique
 *
 */
public abstract class AControle {
	/**
	 * <p>
	 * Gravar ou atualizar uma informação no banco de dados, o que define em
	 * qual tabela os dados serão persistidos é o tipo da entidade, que por sua
	 * vez é passada como parametro nesta ação.
	 */
}

public class AControle {
	public void gravar(Object entidade) {
		Session sessao = HibernateUtil.getFabrica().openSession();
		sessao.beginTransaction();
		sessao.saveOrUptade(entidade);
		sessao.getTransaction();
		sessao.close();
	}

	public List listar(Class claseEntidade) {
		Session sessao = HibernateUtil
		return dados;
	}
}
