package ode.processoPadrao.Cci;

import ode.nucleo.cgt.NucleoAplCadastroBase;
import ode.nucleo.crud.cci.CtrlCRUD;
import ode.nucleo.crud.cih.FormularioDadosCRUD;
import ode.nucleo.crud.cih.PainelCRUD;
import ode.processoPadrao.Cdp.CompPP;
import ode.processoPadrao.Cgt.AplDefinirProcessoPadrao;
import ode.processoPadrao.Cih.FormDadosDefinirProcessoPadrao;
import ode.processoPadrao.Cih.PainelCrudDefinirProcessoPadrao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zkoss.zkplus.spring.SpringUtil;

@Controller
public class CtrlDefinirProcessoPadraoCRUD extends CtrlCRUD<CompPP> {

	public static String TIPO_COMPP_PROCESSO_COMPLEXO = "CompPP Processo Complexo";
	public static String TIPO_COMPP_PROCESSO_SIMPLES = "CompPP Processo Simples";
	public static String TIPO_COMPP_MACROATIVIDADE = "CompPP Macroatividade";

	/** Janela Principal do ambiente de defini��o de processo padr�o. */
	@Override
	public void iniciar() {
		super.iniciar();
		//this.setLarguraJandados("500px");
		//this.setAlturaJanDados("600px");
		System.out.print("Aqui!!!");
	}

	@Autowired
	AplDefinirProcessoPadrao aplDefinirProcessoPadrao;

	public AplDefinirProcessoPadrao getAplDefinirProcessoPadrao() {
		return aplDefinirProcessoPadrao;
	}

	public void setAplDefinirProcessoPadrao(
			AplDefinirProcessoPadrao aplDefinirProcessoPadrao) {
		this.aplDefinirProcessoPadrao = aplDefinirProcessoPadrao;
	}

	// lembrar que o controlador eh melhor injetado pelo spring
	@Override
	public NucleoAplCadastroBase<CompPP> definirNucleoAplCadastroBase() {
		return aplDefinirProcessoPadrao;
	}

	@Override
	public PainelCRUD<CompPP> definirPainelCRUD() {
		return new PainelCrudDefinirProcessoPadrao();

	}

	@Override
	public CompPP factoryObjetoDados() {
		return new CompPP();
	}

	@Override
	public FormularioDadosCRUD<CompPP> definirFormularioCadastro() {
		return new FormDadosDefinirProcessoPadrao();
	}

	@Override
	public String definirTituloJanelaDados() {
		return "CompPP";
	}

	@Override
	public String definirTituloJanelaPrincipal() {
		return "Definir CompPP";
	}

}
