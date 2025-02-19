package ode.medicao.EntidadeMensuravel.cdp;

import javax.persistence.Entity;

import ode.conhecimento.processo.cdp.KRecursoHumano;

@Entity
public class RecursoHumanoMensuravel extends EntidadeMensuravel<KRecursoHumano>{

	private final TipoEntidadeMensuravel tipo = TipoEntidadeMensuravel.RECURSOHUMANO;
	
	@Override
	public TipoEntidadeMensuravel recuperaTipo() {
		return tipo;
	}

	@Override
	public KRecursoHumano getEntidade() {
		return entidade;
	}

	@Override
	public void setEntidade(KRecursoHumano entidade) {
		this.entidade = entidade;
	}

	
	

}
