package ode.conhecimentoMedicao.cih;

import java.util.ArrayList;
import java.util.List;

import ode.conhecimentoMedicao.cdp.KMetodoAnalitico;
import ode._infraestruturaCRUD.ciu.ListagemSimples;
import ode._infraestruturaCRUD.ciu.NucleoListHeader;

public class ListagemKMetodoAnalitico extends ListagemSimples<KMetodoAnalitico> {

	@Override
	public List<NucleoListHeader> definirColunasTabela() {
		List<NucleoListHeader> colunas = new ArrayList<NucleoListHeader>();
		colunas.add(new NucleoListHeader("Nome","nome","40%"));
		colunas.add(new NucleoListHeader("Descri��o","descricao","60%"));
		return colunas;
	}

	@Override
	protected String[] recuperarDadosObjeto(KMetodoAnalitico objeto) {
		return new String[]{objeto.getNome(),objeto.getDescricao()};
	}

}
