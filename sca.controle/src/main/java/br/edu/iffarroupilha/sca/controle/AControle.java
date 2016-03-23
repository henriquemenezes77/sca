package br.edu.iffarroupilha.sca.controle;

import java.util.List;

import org.hibernate.Session;

import br.edu.iffarroupilha.sca.hibernate.HibernateUtil;

/**
 * <p>
 * Classe abstrata que concentra as op��es padr�es de opera��o para entidades.
 * </p>
 *
 * @author Henrique
 *
 */
public abstract class AControle {
	/**
	 * <p>
	 * Gravar ou atualizar uma informa��o no banco de dados, o que define em
	 * qual tabela os dados ser�o persistidos � o tipo da entidade, que por sua
	 * vez � passada como parametro nesta a��o.
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
