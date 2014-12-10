package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {
	private static final int DURACAO_MINUTOS_UMA_HORA = 60;
	private static final double ACRESCIMO_CINCO_POR_CENTO = 0.05;
	private static final double ACRESCIMO_DEZ_POR_CENTO = 0.10;
	private static final double ACRESCIMO_VINTE_POR_CENTO = 0.20;
	private static final double ACRESCIMO_CINQUENTA_POR_CENTO = 0.50;

	public static BigDecimal calcularPrecosDeEspetaculos(Sessao sessao,
			Integer quantidade) {
		BigDecimal preco;

		if (sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.CINEMA)
				|| sessao.getEspetaculo().getTipo()
						.equals(TipoDeEspetaculo.SHOW)) {
			// quando estiver acabando os ingressos...
			if ((sessao.getTotalIngressos() - sessao.getIngressosReservados())
					/ sessao.getTotalIngressos().doubleValue() <= ACRESCIMO_CINCO_POR_CENTO) {
				preco = sessao
						.getPreco()
						.add(sessao
								.getPreco()
								.multiply(
										BigDecimal
												.valueOf(ACRESCIMO_DEZ_POR_CENTO)));
			} else {
				preco = sessao.getPreco();
			}
		} else if (sessao.getEspetaculo().getTipo()
				.equals(TipoDeEspetaculo.BALLET)) {
			if ((sessao.getTotalIngressos() - sessao.getIngressosReservados())
					/ sessao.getTotalIngressos().doubleValue() <= ACRESCIMO_CINQUENTA_POR_CENTO) {
				preco = sessao
						.getPreco()
						.add(sessao
								.getPreco()
								.multiply(
										BigDecimal
												.valueOf(ACRESCIMO_VINTE_POR_CENTO)));
			} else {
				preco = sessao.getPreco();
			}

			if (sessao.getDuracaoEmMinutos() > DURACAO_MINUTOS_UMA_HORA) {
				preco = preco.add(sessao.getPreco().multiply(
						BigDecimal.valueOf(ACRESCIMO_DEZ_POR_CENTO)));
			}
		} else if (sessao.getEspetaculo().getTipo()
				.equals(TipoDeEspetaculo.ORQUESTRA)) {
			if ((sessao.getTotalIngressos() - sessao.getIngressosReservados())
					/ sessao.getTotalIngressos().doubleValue() <= ACRESCIMO_CINQUENTA_POR_CENTO) {
				preco = sessao
						.getPreco()
						.add(sessao
								.getPreco()
								.multiply(
										BigDecimal
												.valueOf(ACRESCIMO_VINTE_POR_CENTO)));
			} else {
				preco = sessao.getPreco();
			}

			if (sessao.getDuracaoEmMinutos() > DURACAO_MINUTOS_UMA_HORA) {
				preco = preco.add(sessao.getPreco().multiply(
						BigDecimal.valueOf(ACRESCIMO_DEZ_POR_CENTO)));
			}
		} else {
			preco = sessao.getPreco();
		}

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

}