package com.algaworks.algamoney.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "algamoney")
public class AlgamoneyApiProperty {

	private String originPermitido = "http://localhost:8000";

	public String getOriginPermitido() {
		return originPermitido;
	}

	public void setOriginPermitido(String originPermitido) {
		this.originPermitido = originPermitido;
	}

	private final Seguranca seguranca = new Seguranca();

	public Seguranca getSeguranca() {
		return seguranca;
	}

	public static class Seguranca {

		public boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
	}

}
