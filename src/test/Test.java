package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import utilisateur.Inscription;
import utilisateur.Utilisateur;

public class Test {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		Inscription isc=new Inscription();
		isc.ajouter();
		Utilisateur usr=new Utilisateur();
		usr.connectUser();
	}
}