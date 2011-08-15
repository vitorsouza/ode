package ode.controleUsuario.cgt;

import ode.controleUsuario.cdp.PerfilAcesso;
import ode.controleUsuario.cgd.PerfilAcessoDAO;
import ode.nucleo.crud.cgd.DAOBase;
import ode.nucleo.crud.cgt.AplBaseImpl;
import ode.nucleo.excecao.NucleoRegraNegocioExcecao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("AplCadastrarPerfilAcesso")
@Transactional(rollbackFor = NucleoRegraNegocioExcecao.class)
public class AplCadastrarPerfilAcessoImpl extends
		AplBaseImpl<PerfilAcesso> implements AplCadastrarPerfilAcesso {
	
	@Autowired
	private PerfilAcessoDAO perfilAcessoDAO;
	
	@Override
	public PerfilAcesso salvar(PerfilAcesso objeto) throws NucleoRegraNegocioExcecao, DataAccessException {
		
		objeto = super.salvar(objeto);
		
		return objeto;
	}

	@Override
	public DAOBase<PerfilAcesso> getNucleoDaoBase() {
		return this.perfilAcessoDAO;
	}

}
