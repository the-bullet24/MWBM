package pe.bn.com.mwbm.transversal.util.componentes;

import org.springframework.stereotype.Component;

@Component("parametros")
public class Parametros {

	private String urlComp;
	private String errorComp;
	private String desErrorComp;

	// PARAMETROS RENIEC
	private String consulReniec;
	private String sistemaReniec;
	private String user1Reniec;
	private String userReniec;
	private String urlReniec;

	// PARAMETROS BDUC
	private String perfil2BDUC;
	private String perfilBDUC;
	private String tipoDocBDUC;
	private String transac2BDUC;
	private String transacBDUC;
	private String userBDUC;

	// PARAMETROS MS
	private String consAfillMade;
	private String intConsToken;
	private String msListDoc;
	private String msListOpe;
	private String consSofToken;
	private String consAffilClient;
	private String consSofTokenUsed;
	private String consCsCanal;
	private String consoliOpeGroup;
	private String consoliEntity;
	private String msListMotDesafi;
	
	// PARAMETROS SISTEMA
	private String dateInitSofToken;

	// PARAMETROS SERVICES
	private String urlServidorCorreo;
	
	@Override
	public String toString() {
		return "Parametros [urlComp=" + urlComp + ", errorComp=" + errorComp
				+ ", desErrorComp=" + desErrorComp + ", consulReniec="
				+ consulReniec + ", sistemaReniec=" + sistemaReniec
				+ ", user1Reniec=" + user1Reniec + ", userReniec=" + userReniec
				+ ", urlReniec=" + urlReniec + ", perfil2BDUC=" + perfil2BDUC
				+ ", perfilBDUC=" + perfilBDUC + ", tipoDocBDUC=" + tipoDocBDUC
				+ ", transac2BDUC=" + transac2BDUC + ", transacBDUC="
				+ transacBDUC + ", userBDUC=" + userBDUC + ", consAfillMade="
				+ consAfillMade + ", intConsToken=" + intConsToken
				+ ", msListDoc=" + msListDoc + ", msListOpe=" + msListOpe
				+ ", consSofToken=" + consSofToken + ", consAffilClient="
				+ consAffilClient +", consSofTokenUsed="
				+ consSofTokenUsed +", dateInitSofToken="
				+ dateInitSofToken + ", consCsCanal="
				+consCsCanal +", consoliOpeGroup="
				+ consoliOpeGroup +", consoliEntity="
				+ consoliEntity + ", msListMotDesafi="
				+ msListMotDesafi +"]";
	}

	public String getConsulReniec() {
		return consulReniec;
	}

	public void setConsulReniec(String consulReniec) {
		this.consulReniec = consulReniec;
	}

	public String getSistemaReniec() {
		return sistemaReniec;
	}

	public void setSistemaReniec(String sistemaReniec) {
		this.sistemaReniec = sistemaReniec;
	}

	public String getUser1Reniec() {
		return user1Reniec;
	}

	public void setUser1Reniec(String user1Reniec) {
		this.user1Reniec = user1Reniec;
	}

	public String getUserReniec() {
		return userReniec;
	}

	public void setUserReniec(String userReniec) {
		this.userReniec = userReniec;
	}

	public String getErrorComp() {
		return errorComp;
	}

	public void setErrorComp(String errorComp) {
		this.errorComp = errorComp;
	}

	public String getDesErrorComp() {
		return desErrorComp;
	}

	public void setDesErrorComp(String desErrorComp) {
		this.desErrorComp = desErrorComp;
	}

	public String getUrlComp() {
		return urlComp;
	}

	public void setUrlComp(String urlComp) {
		this.urlComp = urlComp;
	}

	public String getUrlReniec() {
		return urlReniec;
	}

	public void setUrlReniec(String urlReniec) {
		this.urlReniec = urlReniec;
	}

	public String getPerfil2BDUC() {
		return perfil2BDUC;
	}

	public void setPerfil2BDUC(String perfil2bduc) {
		perfil2BDUC = perfil2bduc;
	}

	public String getPerfilBDUC() {
		return perfilBDUC;
	}

	public void setPerfilBDUC(String perfilBDUC) {
		this.perfilBDUC = perfilBDUC;
	}

	public String getTipoDocBDUC() {
		return tipoDocBDUC;
	}

	public void setTipoDocBDUC(String tipoDocBDUC) {
		this.tipoDocBDUC = tipoDocBDUC;
	}

	public String getTransac2BDUC() {
		return transac2BDUC;
	}

	public void setTransac2BDUC(String transac2bduc) {
		transac2BDUC = transac2bduc;
	}

	public String getTransacBDUC() {
		return transacBDUC;
	}

	public void setTransacBDUC(String transacBDUC) {
		this.transacBDUC = transacBDUC;
	}

	public String getUserBDUC() {
		return userBDUC;
	}

	public void setUserBDUC(String userBDUC) {
		this.userBDUC = userBDUC;
	}

	public String getConsAfillMade() {
		return consAfillMade;
	}

	public void setConsAfillMade(String consAfillMade) {
		this.consAfillMade = consAfillMade;
	}

	public String getIntConsToken() {
		return intConsToken;
	}

	public void setIntConsToken(String intConsToken) {
		this.intConsToken = intConsToken;
	}

	public String getMsListDoc() {
		return msListDoc;
	}

	public void setMsListDoc(String msListDoc) {
		this.msListDoc = msListDoc;
	}

	public String getMsListOpe() {
		return msListOpe;
	}

	public void setMsListOpe(String msListOpe) {
		this.msListOpe = msListOpe;
	}

	public String getConsSofToken() {
		return consSofToken;
	}

	public void setConsSofToken(String consSofToken) {
		this.consSofToken = consSofToken;
	}

	public String getDateInitSofToken() {
		return dateInitSofToken;
	}

	public void setDateInitSofToken(String dateInitSofToken) {
		this.dateInitSofToken = dateInitSofToken;
	}

	public String getConsAffilClient() {
		return consAffilClient;
	}

	public void setConsAffilClient(String consAffilClient) {
		this.consAffilClient = consAffilClient;
	}

	public String getConsSofTokenUsed() {
		return consSofTokenUsed;
	}

	public void setConsSofTokenUsed(String consSofTokenUsed) {
		this.consSofTokenUsed = consSofTokenUsed;
	}
	
	public String getConsCsCanal() {
		return consCsCanal;
	}

	public void setConsCsCanal(String consCsCanal) {
		this.consCsCanal = consCsCanal;
	}
	public String getConsoliOpeGroup() {
		return consoliOpeGroup;
	}

	public void setConsoliOpeGroup(String consoliOpeGroup) {
		this.consoliOpeGroup = consoliOpeGroup;
	}

	public String getConsoliEntity() {
		return consoliEntity;
	}

	public void setConsoliEntity(String consoliEntity) {
		this.consoliEntity = consoliEntity;
	}

	public String getUrlServidorCorreo() {
		return urlServidorCorreo;
	}

	public void setUrlServidorCorreo(String urlServidorCorreo) {
		this.urlServidorCorreo = urlServidorCorreo;
	}

	public String getMsListMotDesafi() {
		return msListMotDesafi;
	}

	public void setMsListMotDesafi(String msListMotDesafi) {
		this.msListMotDesafi = msListMotDesafi;
	}
	
	
}
