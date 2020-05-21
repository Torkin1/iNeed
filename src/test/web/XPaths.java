package test.web;

public enum XPaths {
	CHECKANSWERS_CONTACTINFO("//*[@id=\"contactInfo\"]"),
	LOGIN_BLOGIN("//*[@id=\"login\"]"),
	LOGIN_FUSERNAME("//*[@id=\"username\"]"),
	LOGIN_FPASSWORD("//*[@id=\"password\"]"),
	VIEWAD_BCHECKANSWERS("/html/body/div[2]/div[4]/a/button"),
	VIEWAD_LOWNER("/html/body/div[2]/div[3]/div[1]/div/div[2]/span"),
	NAVBAR_BMAKEANAD("/html/body/div[1]/nav/nav/div/ul/li[1]/a"),
	MAKEANAD_STYPE("//*[@id=\"type\"]"),
	MAKEANAD_OFFERTYPE("/html/body/div/div[3]/form/div[1]/select/option[2]"),
	MAKEANAD_REQUESTTYPE("/html/body/div/div[3]/form/div[1]/select/option[1]"),
	MAKEANAD_FTITLE("//*[@id=\"title\"]"),
	MAKEANAD_SCATEGORY("//*[@id=\"category\"]"),
	MAKEANAD_GARDERINGCATEGORY("/html/body/div/div[3]/form/div[3]/select/option[3]"),
	MAKEANAD_FBODY("//*[@id=\"body\"]"),
	MAKEANAD_BPUBLISH("//*[@id=\"publish\"]")
	;
	private final String xpath;
	private XPaths(String xpath) {
		this.xpath = xpath;
	}
	@Override
	public String toString() {
		return this.xpath;
	}
}
