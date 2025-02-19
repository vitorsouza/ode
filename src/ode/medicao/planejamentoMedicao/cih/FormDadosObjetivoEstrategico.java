package ode.medicao.planejamentoMedicao.cih;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.Textbox;

import ode.medicao.planejamentoMedicao.cdp.ObjetivoEstrategico;
import ode.medicao.planejamentoMedicao.cdp.ObjetivoSoftware;
import ode.conhecimento.processo.cdp.KCategoriaProcesso;
import ode._infraestruturaBase.ciu.NucleoBandbox;
import ode._infraestruturaBase.ciu.NucleoTab;
import ode._infraestruturaCRUD.ciu.FormularioDadosCRUD;
import ode._infraestruturaCRUD.ciu.GridDados;
import ode._infraestruturaBase.excecao.NucleoRegraNegocioExcecao;
import ode._infraestruturaBase.util.NucleoMensagens;

public class FormDadosObjetivoEstrategico extends FormularioDadosCRUD<ObjetivoEstrategico>{
	
	private Textbox tbNome = new Textbox();
	private Textbox tbDescricao = new Textbox();
	
	@Override
	protected List<NucleoTab> definirTabs() {
		// Cria a nova lista
				List<NucleoTab> listaTabs = new ArrayList<NucleoTab>();

				// ////////////////////////////
				// Dados Cadastro
				// ////////////////////////////
				NucleoTab tabDadosCadastro = new NucleoTab();

				// Atribui o nome � tab
				tabDadosCadastro.setNomeTab(NucleoMensagens.getMensagem(NucleoMensagens.TERMO_DADOS_CADASTRO));

				// Atribui o conte�do � tab
				GridDados gridDadosCadastro = new GridDados();
				tbNome.setMaxlength(300);	
				tbNome.setHeight("35px");
				tbNome.setMultiline(true);
				gridDadosCadastro.adicionarLinhaObrigatoria(NucleoMensagens
						.getMensagem(NucleoMensagens.TERMO_NOME),tbNome);
				
				tbDescricao.setMaxlength(400);
				tbDescricao.setHeight("65px");
				tbDescricao.setMultiline(true);
				gridDadosCadastro.adicionarLinha(NucleoMensagens
						.getMensagem(NucleoMensagens.TERMO_DESCRICAO),tbDescricao);	
				
				listaTabs.add(tabDadosCadastro);
				tabDadosCadastro.setConteudoTab(gridDadosCadastro);

				return listaTabs;
	}
	
	@Override
	protected void montarTabs() {
		super.montarTabs();
	};

	@Override
	protected void preencherDadosTela(ObjetivoEstrategico objeto) throws NucleoRegraNegocioExcecao {
		tbNome.setText(objeto.getNome());
		tbDescricao.setText(objeto.getDescricao());
	}

	@Override
	protected void preencherDadosObjeto(ObjetivoEstrategico objeto) {
		objeto.setNome(tbNome.getText());
		objeto.setDescricao(tbDescricao.getText());
	}
	
	@Override
	protected void configurarConstraints() {
		tbNome.setConstraint("no empty");		
		tbDescricao.setConstraint("no empty");
	}

}
