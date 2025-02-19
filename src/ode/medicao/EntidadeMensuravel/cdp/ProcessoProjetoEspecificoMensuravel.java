package ode.medicao.EntidadeMensuravel.cdp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import ode.conhecimento.processo.cdp.KProcesso;

@Entity
public class ProcessoProjetoEspecificoMensuravel extends EntidadeMensuravel<KProcesso>{

	private final TipoEntidadeMensuravel tipo = TipoEntidadeMensuravel.PROCESSOESPECIFICOPROJETO;
	
	private ProcessoPadraoMensuravel processoPadraoMensuravel;

	
	@Override
	public TipoEntidadeMensuravel recuperaTipo() {
		return tipo;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	public ProcessoPadraoMensuravel getProcessoPadraoMensuravel() {
		return processoPadraoMensuravel;
	}

	public void setProcessoPadraoMensuravel(ProcessoPadraoMensuravel processoPadraoMensuravel) {
		this.processoPadraoMensuravel = processoPadraoMensuravel;
	}

	@Override
	public KProcesso getEntidade() {
		return entidade;
	}

	@Override
	public void setEntidade(KProcesso entidade) {
		this.entidade = entidade;
	}

	

}
