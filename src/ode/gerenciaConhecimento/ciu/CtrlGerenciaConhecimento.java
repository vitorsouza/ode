package ode.gerenciaConhecimento.ciu;

import java.util.Collection;
import java.util.List;

import ode._controleRecursoHumano.cdp.RecursoHumano;
import ode._controleRecursoHumano.cgt.AplCadastrarRecursoHumano;
import ode._infraestruturaBase.ciu.CtrlBase;
import ode._infraestruturaBase.excecao.NucleoRegraNegocioExcecao;
import ode._infraestruturaBase.util.NucleoContexto;
import ode._infraestruturaCRUD.ciu.JanelaSimples;
import ode.atuacaoRecursoHumano.cgd.AtuacaoRHDAO;
import ode.conhecimento.processo.cgt.AplCadastrarKAtividade;
import ode.controleProjeto.cdp.Projeto;
import ode.controleProjeto.cgt.AplCadastrarProjeto;
import ode.controleUsuario.cdp.Usuario;
import ode.controleUsuario.cgt.AplCadastrarUsuario;
import ode.gerenciaConhecimento.cdp.Avaliacao;
import ode.gerenciaConhecimento.cdp.ConhecimentoRelativoDiscussao;
import ode.gerenciaConhecimento.cdp.ItemConhecimento;
import ode.gerenciaConhecimento.cdp.LicaoAprendida;
import ode.gerenciaConhecimento.cdp.Valoracao;
import ode.gerenciaConhecimento.cgt.AplCadastrarConhecimentoRelativoDiscussao;
import ode.gerenciaConhecimento.cgt.AplCadastrarItemConhecimento;
import ode.gerenciaConhecimento.cgt.AplCadastrarLicaoAprendida;
import ode.gerenciaConhecimento.cgt.AplCadastrarTema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CtrlGerenciaConhecimento extends CtrlBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JanelaSimples jan;
	private JanPrincipal janP;	

	public JanTiposItemConhecimento janTiposItemConhecimento;
	public JanCriarLicaoAprendida janCriarLicaoAprendida;
	public JanCriarConhecimentoRelativoDiscussao janCriarConhecimentoRelativoDiscussao;
	public JanBuscarItensConhecimento janBuscarItensConhecimento;
	public JanAvaliarItemConhecimento janAvaliarItemConhecimento;
	public JanItensCriados janItensCriados;
	public JanListaBuscarItensConhecimento janListaBuscarItensConhecimento;
	public JanVisualizarItemConhecimentoUsuarioComum janVisualizarItemConhecimentoUsuarioComum;
	public JanItensPendentesAvaliacaoUsuarioComum janItensPendentesAvaliacaoUsuarioComum;
	public JanValorarItemConhecimento janValorarItemConhecimento;
	public JanItensPendentesAvaliacaoGerente janItensPendentesAvaliacaoGerente;
	public JanVisualizarItemConhecimentoGerente janVisualizarItemConhecimentoGerente;
	public JanMeusTemasDeInteresse janMeusTemasDeInteresse;
	public JanItensValorados janItensValorados;
	public JanItensAvaliados janItensAvaliados;
	public JanPaginasAmarelasBuscarPessoas janPaginasAmarelasBuscarPessoas;
	public JanPaginasAmarelasResultadoPesquisa janPaginasAmarelasResultadoPesquisa;


	@Autowired
	AplCadastrarConhecimentoRelativoDiscussao aplCadastrarConhecimentoRelativoDiscussao;

	@Autowired
	AplCadastrarLicaoAprendida aplCadastrarLicaoAprendida;

	@Autowired
	AplCadastrarProjeto aplCadastrarProjeto;

	@Autowired
	AplCadastrarTema aplCadastrarTema;

	@Autowired
	AplCadastrarKAtividade aplCadastrarKAtividade;

	@Autowired
	AplCadastrarItemConhecimento aplCadastrarItemConhecimento;

	@Autowired
	AplCadastrarRecursoHumano aplCadastrarRecursoHumano;

	@Autowired
	AplCadastrarUsuario aplCadastrarUsuario;

	@Autowired
	AtuacaoRHDAO atuacaoRHDAO;

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		mostrarJanelaPrincipal();
	}

	public void mostrarJanelaPrincipal(){

		jan = factoryJanelaSimples();

		janP = new JanPrincipal(this);
		janP.setParent(jan);

		jan.setTitle("Portal de Ger�ncia de Conhecimento");
		jan.setWidth("100%");
		jan.setHeight("580px");
		//jan.setHeight("100%");

		jan.doEmbedded();
	}

	public JanItensCriados exibirJanelaItensCriados_inicial(){

		janItensCriados = new JanItensCriados(this);

		return janItensCriados;

	}

	public JanItensPendentesAvaliacaoGerente exibirJanelaItensPendentesAvaliacao_inicial(){

		janItensPendentesAvaliacaoGerente = new JanItensPendentesAvaliacaoGerente(this);

		return janItensPendentesAvaliacaoGerente;
	}

	public void exibirJanelaTiposItemConhecimento(){

		janTiposItemConhecimento = new JanTiposItemConhecimento(this);

		janP.mostrarJanelaConteudo(janTiposItemConhecimento);

	}

	public void exibirJanelaBuscarItensConhecimento(){

		janBuscarItensConhecimento = new JanBuscarItensConhecimento(this);

		janP.mostrarJanelaConteudo(janBuscarItensConhecimento);

	}

	public void exibirJanelaItensValorados(Collection<ItemConhecimento> itens){

		janItensValorados = new JanItensValorados(this, itens);

		janP.mostrarJanelaConteudo(janItensValorados);
	}

	public void exibirJanelaItensAvaliados(Collection<ItemConhecimento> itens){

		janItensAvaliados = new JanItensAvaliados(this, itens);

		janP.mostrarJanelaConteudo(janItensAvaliados);
	}
	
	public void exibirJanelaPaginasAmarelasBuscarPessoas(){
		
		janPaginasAmarelasBuscarPessoas = new JanPaginasAmarelasBuscarPessoas(this);
		
		janP.mostrarJanelaConteudo(janPaginasAmarelasBuscarPessoas);
	}
	
	public void exibirJanelaPaginasAmarelasResultadoPesquisa(){
		
		janPaginasAmarelasResultadoPesquisa = new JanPaginasAmarelasResultadoPesquisa(this);
		
		janP.mostrarJanelaConteudo(janPaginasAmarelasResultadoPesquisa);
	}

	public void exibirJanelaItensPendentesAvaliacao(){

		// Recupera todos que s�o gerentes de projeto
		Collection<RecursoHumano> recursos = atuacaoRHDAO.recuperarAptosPorPapel(new Long(31));

		if (recursos.contains(NucleoContexto.recuperarUsuarioLogado().getRecursoHumano())){
			this.exibirJanelaItensPendentesAvaliacaoGerente();
		} else {
			exibirJanelaItensPendentesAvaliacaoUsuarioComum();
		}
	}

	public void exibirJanelaItensPendentesAvaliacaoUsuarioComum(){

		janItensPendentesAvaliacaoUsuarioComum = new JanItensPendentesAvaliacaoUsuarioComum(this);

		janP.mostrarJanelaConteudo(janItensPendentesAvaliacaoUsuarioComum);

	}

	public void exibirJanelaItensPendentesAvaliacaoGerente(){

		janItensPendentesAvaliacaoGerente = new JanItensPendentesAvaliacaoGerente(this);

		janP.mostrarJanelaConteudo(janItensPendentesAvaliacaoGerente);

	}

	public void exibirJanelaValorarItemConhecimento(ItemConhecimento itemConhecimento){

		janValorarItemConhecimento = new JanValorarItemConhecimento(this, itemConhecimento);

		janP.mostrarJanelaConteudo(janValorarItemConhecimento);

	}



	public void exibirJanelaAvaliarItemConhecimento(ItemConhecimento itemConhecimento){

		janAvaliarItemConhecimento = new JanAvaliarItemConhecimento(this, itemConhecimento);

		janP.mostrarJanelaConteudo(janAvaliarItemConhecimento);

	}




	public void exibirJanelaItensCriados(){

		janItensCriados = new JanItensCriados(this);

		janP.mostrarJanelaConteudo(janItensCriados);

	}

	public void exibirJanelaVisualizarItemConhecimento(ItemConhecimento itemConhecimento){

		// Recupera todos que s�o gerentes de projeto
		Collection<RecursoHumano> recursos = atuacaoRHDAO.recuperarAptosPorPapel(new Long(31));

		if (recursos.contains(NucleoContexto.recuperarUsuarioLogado().getRecursoHumano())){
			this.exibirJanelaVisualizarItemConhecimentoGerente(itemConhecimento);
		} else {
			exibirJanelaVisualizarItemConhecimentoUsuarioComum(itemConhecimento);
		}
	}

	public void exibirJanelaVisualizarItemConhecimentoUsuarioComum(ItemConhecimento item){

		janVisualizarItemConhecimentoUsuarioComum = new JanVisualizarItemConhecimentoUsuarioComum(this, item);

		janP.mostrarJanelaConteudo(janVisualizarItemConhecimentoUsuarioComum);

	}

	public void exibirJanelaVisualizarItemConhecimentoGerente(ItemConhecimento itemConhecimento){

		janVisualizarItemConhecimentoGerente = new JanVisualizarItemConhecimentoGerente(this,itemConhecimento);

		janP.mostrarJanelaConteudo(janVisualizarItemConhecimentoGerente);

	}

	public void exibirJanelaListaBuscarItensConhecimento(List<ItemConhecimento> itens){

		janListaBuscarItensConhecimento = new JanListaBuscarItensConhecimento(this,itens);

		janP.mostrarJanelaConteudo(janListaBuscarItensConhecimento);

	}

	public void exibirJanelaCriarLicaoAprendida(){

		janCriarLicaoAprendida = new JanCriarLicaoAprendida(this);

		janP.mostrarJanelaConteudo(janCriarLicaoAprendida);

	}

	public void exibirJanelaCriarConhecimentoRelativoDiscussao(){

		janCriarConhecimentoRelativoDiscussao = new JanCriarConhecimentoRelativoDiscussao(this);

		janP.mostrarJanelaConteudo(janCriarConhecimentoRelativoDiscussao);

	}

	public void exibirJanelaMeusTemasDeItenteresse(){

		janMeusTemasDeInteresse = new JanMeusTemasDeInteresse(this);

		janP.mostrarJanelaConteudo(janMeusTemasDeInteresse);

	}


	public void salvarLicaoAprendida(LicaoAprendida la) {

		try {
			aplCadastrarLicaoAprendida.salvar(la);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void salvarConhecimentoRelativoDiscussao(ConhecimentoRelativoDiscussao crd){

		try {
			aplCadastrarConhecimentoRelativoDiscussao.salvar(crd);
		} catch (Exception e) {
			e.getCause().printStackTrace();
		}

	}

	public Collection<Projeto> recuperarProjetos(){
		return aplCadastrarProjeto.recuperarTodos();
	}

	public List<LicaoAprendida> recuperarLicoesOrdenadoPorQuantidadeAcesso(){
		return aplCadastrarLicaoAprendida.recuperarOrdenadoPorQuantidadeAcesso();
	}

	public List<LicaoAprendida> recuperarLicoesOrdenadoPorDataCriacaoMaisRecente(){
		return aplCadastrarLicaoAprendida.recuperarOrdenadoPorDataCriacaoMaisRecente();
	}

	public int recuperarQuantidadeTotalLicoesAprendidas(){
		return this.aplCadastrarLicaoAprendida.recuperarQuantidadeTotal();
	}

	public List<ConhecimentoRelativoDiscussao> recuperarItensDiscussaoOrdenadoPorQuantidadeAcesso(){
		return aplCadastrarConhecimentoRelativoDiscussao.recuperarOrdenadoPorQuantidadeAcesso();
	}

	public List<ConhecimentoRelativoDiscussao> recuperarItensDiscussaoOrdenadoPorDataCriacaoMaisRecente(){
		return aplCadastrarConhecimentoRelativoDiscussao.recuperarOrdenadoPorDataCriacaoMaisRecente();
	}

	public int recuperarQuantidadeTotalItensDiscussao(){
		return this.aplCadastrarConhecimentoRelativoDiscussao.recuperarQuantidadeTotal();
	}

	public int recuperarQuantidadeTotalMembros(){
		return this.aplCadastrarRecursoHumano.recuperarQuantidadeTotal();
	}

	public void adicionarValoracao(Valoracao valoracao, ItemConhecimento itemConhecimento){
		this.aplCadastrarItemConhecimento.adicionarValoracao(valoracao, itemConhecimento);
	}

	public Collection<RecursoHumano> recuperarRecursosHumanosAtivos(){
		return aplCadastrarRecursoHumano.recuperarRecursosHumanosAtivos();
	}

	public Usuario recuperarUsuarioPorID(Long id){
		return aplCadastrarUsuario.recuperarPorId(id);
	}

	public void salvarMeusTemas(RecursoHumano recursoHumano) {
		try {
			aplCadastrarRecursoHumano.salvar(recursoHumano);
		} catch (NucleoRegraNegocioExcecao e) {
			e.printStackTrace();
		}
	}

	public void salvarAvaliacaoItemConhecimento(Avaliacao avaliacao, ItemConhecimento itemConhecimento){
		this.aplCadastrarItemConhecimento.adicionarAvaliacao(avaliacao, itemConhecimento);
	}
	
	public Collection<ItemConhecimento> recuperarItensConhecimentoPendentesPorUsuarioAtual(){
		return this.aplCadastrarItemConhecimento.recuperarTodos();
	}
}
