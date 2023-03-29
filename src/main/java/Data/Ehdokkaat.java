package Data;

public class Ehdokkaat {

private int ehdokas_id;
private String sukunimi;
private String etunimi;
private String puolue;
private String eduskunta;
private String edistaa;



public Ehdokkaat(String ehdokas_id, String sukunimi, String etunimi, String puolue, String eduskunta, String edistaa) {
	setEhdokas_id(ehdokas_id);
	
	this.sukunimi=sukunimi;
	this.etunimi=etunimi;
	this.puolue=puolue;
	this.eduskunta = eduskunta;
	this.edistaa = edistaa;
}

public Ehdokkaat() {
	
}


public int getEhdokas_id() {
	return ehdokas_id;
}

public void setEhdokas_id(int ehdokas_id) {
	this.ehdokas_id = ehdokas_id;
}

public void setEhdokas_id(String ehdokas_id) {
	try {
		this.ehdokas_id= Integer.parseInt(ehdokas_id);
	}
	catch(NumberFormatException | NullPointerException e) {
		System.out.println(e.getMessage());
	}
}



public String getSukunimi() {
	return sukunimi;
}
public void setSukunimi(String sukunimi) {
	this.sukunimi = sukunimi;
}
public String getEtunimi() {
	return etunimi;
}
public void setEtunimi(String etunimi) {
	this.etunimi = etunimi;
}
public String getPuolue() {
	return puolue;
}
public void setPuolue(String puolue) {
	this.puolue = puolue;
}
public String getEduskunta() {
	return eduskunta;
}

public void setEduskunta(String eduskunta) {
	this.eduskunta = eduskunta;
}

public String getEdistaa() {
	return edistaa;
}

public void setEdistaa(String edistaa) {
	this.edistaa = edistaa;
}

}
