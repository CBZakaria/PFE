package utilisateur;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilisateur implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String user;
	protected String pass;
	public static int nbUtilisateur=0;
	protected static int nbconnected=0;
	protected Inscription insc=new Inscription(); 
	protected ArrayList<Utilisateur> utilisateurs=new ArrayList<Utilisateur>();
	
	
	public Utilisateur(String user, String pass) {
		this.user = user;
		this.pass = pass;
		Utilisateur.nbUtilisateur++;
		utilisateurs.add(this);
	}
	
	
	public Utilisateur() {}
	
	
	public void connectUser() throws FileNotFoundException, ClassNotFoundException, IOException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrer votre login : ");
		String login =sc.nextLine();
		System.out.println("Entrer votre mdp");
		String mdp=sc.nextLine();
		while(!checkUser(login,mdp)) {
			System.out.println("Entrer votre login : ");
			login =sc.nextLine();
			System.out.println("Entrer votre mdp");
			mdp=sc.nextLine();
		}
	}
	private boolean checkUser(String login, String mdp) throws FileNotFoundException, ClassNotFoundException, IOException {
		ArrayList<Utilisateur> list=this.insc.chargerUsers();
		for(Utilisateur user:list) {
			if(user.user.equals(login) && user.pass.equals(mdp)) {
				System.out.println("connected");
				Utilisateur.nbconnected++;
				System.out.println(Utilisateur.nbconnected);
				System.out.println("Bienvenue "+login);
				return true;
			}else {
				System.out.println("Login or password not correct");
				return false ;
			}
		}
		return false;
	}
}
