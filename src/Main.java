import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Livre livre = new Livre("seigneur des anneaux", "Jr tolkien", 2000);
        ArrayList<Livre> bibliotheque = new ArrayList<>();
        bibliotheque.add(livre);

        int choices = 0;

        while(choices != 4){
            System.out.println("************");
            System.out.println("Librairie training");
            System.out.println("************");

            System.out.println("Ajouter un livre ? (1)");
            System.out.println("Afficher tout les livres ? (2) ");
            System.out.println("Rechercher un livre (3) ");
            System.out.println("Quitter (4) ");

            System.out.print("Votre choix ? (1-4) : ");
            choices = scanner.nextInt();
            scanner.nextLine();

            switch (choices){
                case 1 -> {
                    System.out.print("Titre du livre ? : ");
                    String titre = scanner.nextLine().toLowerCase();
                    System.out.print("Auteur du livre ? : ");
                    String auteur = scanner.nextLine();
                    System.out.print("L'année ? : ");
                    int annee = scanner.nextInt();
                    scanner.nextLine();
                    bibliotheque.add(new Livre(titre, auteur, annee));
                    System.out.println("Livre ajouté ! ");
                }

                case 2 -> {
                    if(bibliotheque.isEmpty()){
                        System.out.println("La bibliothèque vide !");
                    }else{
                        for(Livre livres : bibliotheque){
                            System.out.println(livres.getTitre() + " de " + livres.getAuteur() + " sortit en : " + livres.getAnnee());
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Quel titre de livre cherchez vous ? : ");
                    String recherche = scanner.nextLine();
                    boolean trouve = false;
                    for (Livre l : bibliotheque) {
                        if (l.getTitre().equalsIgnoreCase(recherche)) {
                            System.out.println("Voici le livre que vous cherchez : " + l.getTitre());
                            trouve = true;
                            break;
                        }
                    }
                    if (!trouve) {
                        System.out.println("Nous n'avons pas ce livre. Voulez-vous l’ajouter ?");
                    }

                }
                case 4 -> {
                    System.out.println("Au revoir !");
                    scanner.close();
                }
                default -> System.out.println("Choix invalide ! ");
            }

        }


    }

}
