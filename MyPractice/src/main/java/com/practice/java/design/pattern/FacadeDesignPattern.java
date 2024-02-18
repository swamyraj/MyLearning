package com.practice.java.design.pattern;

public class FacadeDesignPattern {

	public static void main(String[] args) {
		DatabaseFacade.generateReport("html", "oracle");
		DatabaseFacade.generateReport("html", "mysql");
		
		DatabaseFacade.generateReport("pdf", "mysql");
		DatabaseFacade.generateReport("pdf", "mysql");
	}
}

class DatabaseFacade {

	public static void generateReport(String report, String db) {

		switch (db) {
		case "mysql":
			DataBase m = new MySqlDataBase();
			switch (report) {
			case "html":
				m.generateHTMLReport();
				break;
			case "pdf":
				m.generatePdfReport();
				break;
			default:
				break;
			}
			break;

		case "oracle":

			DataBase o = new OracleDatabse();
			switch (report) {
			case "html":
				o.generateHTMLReport();
				break;
			case "pdf":
				o.generatePdfReport();
				break;
			default:
				break;
			}
			break;

		default:
			break;
		}
	}

}

interface DataBase {
	void generateHTMLReport();

	void generatePdfReport();
}

class MySqlDataBase implements DataBase {

	@Override
	public void generateHTMLReport() {
		System.out.println("generating mysql html report");

	}

	@Override
	public void generatePdfReport() {
		System.out.println("generating mysql pdf report");

	}

}

class OracleDatabse implements DataBase {

	@Override
	public void generateHTMLReport() {
		System.out.println("generating Oracle html report");

	}

	@Override
	public void generatePdfReport() {
		System.out.println("generating Oracle pdf report");

	}

}
