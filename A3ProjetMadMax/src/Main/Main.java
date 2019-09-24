package Main;

import Model.DecryptModel;

public class Main {
    public static void main(String[] args) {
        DecryptModel model = new DecryptModel();
        String chaine = "ceci est un test et encore un autre";
        String key = "dgehcczce";
        System.out.println(chaine);

        chaine = model.decrypt(chaine, key);
        System.out.println(chaine);

        chaine = model.decrypt(chaine, key);
        System.out.println(chaine);

    }
}
