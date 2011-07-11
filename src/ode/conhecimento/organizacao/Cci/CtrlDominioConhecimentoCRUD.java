package ode.conhecimento.organizacao.Cci;

import nucleo.comuns.aplicacao.NucleoAplCadastroBase;
import nucleo.comuns.crud.controlador.CtrlCRUD;
import nucleo.comuns.crud.visao.FormularioDadosCRUD;
import nucleo.comuns.crud.visao.PainelCRUD;
import ode.conhecimento.organizacao.Cdp.KDominioConhecimento;
import ode.conhecimento.organizacao.Cgt.AplCadastrarKDominioConhecimento;
import ode.conhecimento.organizacao.Cih.FormDadosDominioConhecimento;
import ode.conhecimento.organizacao.Cih.PainelCrudDominioConhecimento;

import org.zkoss.zkplus.spring.SpringUtil;

public class CtrlDominioConhecimentoCRUD extends CtrlCRUD<KDominioConhecimento> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void iniciar() {
		super.iniciar();
		
	}

	//lembrar que o controlador eh melhor injetado pelo spring
	@Override
	public NucleoAplCadastroBase definirNucleoAplCadastroBase() {
		return (AplCadastrarKDominioConhecimento) SpringUtil
				.getBean("aplCadastrarKDominioConhecimento");
	}

	@Override
	public PainelCRUD definirPainelCRUD() {
		return new PainelCrudDominioConhecimento();
		
	}


	@Override
	public KDominioConhecimento factoryObjetoDados() {
		return new KDominioConhecimento();
	}

	@Override
	public FormularioDadosCRUD definirFormularioCadastro() {
		return new FormDadosDominioConhecimento();
	}

	@Override
	public String definirTituloJanelaDados() {
		return "Dom�nio de Conhecimento";
	}
	
	@Override
	public String definirTituloJanelaPrincipal() {
		return "Cadastro de Dom�nio de Conhecimento";
	}
}
