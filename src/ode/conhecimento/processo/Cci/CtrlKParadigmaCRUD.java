package ode.conhecimento.processo.Cci;

import org.zkoss.zkplus.spring.SpringUtil;
import nucleo.comuns.aplicacao.NucleoAplCadastroBase;
import nucleo.comuns.crud.controlador.CtrlCRUD;
import nucleo.comuns.crud.visao.FormularioDadosCRUD;
import nucleo.comuns.crud.visao.PainelCRUD;
import ode.conhecimento.processo.Cdp.KParadigma;
import ode.conhecimento.processo.Cgt.AplCadastrarKParadigma;
import ode.conhecimento.processo.Cih.FormDadosKParadigma;
import ode.conhecimento.processo.Cih.PainelCrudKParadigma;


public class CtrlKParadigmaCRUD extends CtrlCRUD<KParadigma> {
@Override
	public void iniciar() {
		super.iniciar();
		/*
		JanelaSimples jan = factoryJanelaSimples();				
		String titulo ="Teste Painel Selecao";
		PainelSelecaoPessoa p = new PainelSelecaoPessoa();		
		p.setParent(jan);
		jan.setTitle(titulo);
		jan.setWidth(getLarguraJandados());
		jan.setHeight(getAlturaJanDados());
		jan.mostrar();
		*/
		
	}

	//lembrar que o controlador eh melhor injetado pelo spring
	@Override
	public NucleoAplCadastroBase definirNucleoAplCadastroBase() {
		return (AplCadastrarKParadigma) SpringUtil
				.getBean("aplCadastrarKParadigma");
	}

	@SuppressWarnings("unchecked")
	@Override
	public PainelCRUD definirPainelCRUD() {
		return new PainelCrudKParadigma();
		
	}


	@Override
	public KParadigma factoryObjetoDados() {
		return new KParadigma();
	}

	@Override
	public FormularioDadosCRUD definirFormularioCadastro() {
		return new FormDadosKParadigma();
	}

	@Override
	public String definirTituloJanelaDados() {
		return "Paradigma";
	}
	
	@Override
	public String definirTituloJanelaPrincipal() {
		return "Cadastro de Paradigma com Controlador";
	}
}
