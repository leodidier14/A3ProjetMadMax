package Main;

import Model.DecryptModel;

public class Main {
    public static void main(String[] args) {
        DecryptModel model = new DecryptModel();
        String chaine = "ceci est un test";
        String key = "dgehcvb";
        System.out.println(chaine);

        chaine = model.decrypt(chaine, key);
        System.out.println(chaine);

        chaine = model.decrypt(chaine, key);
        System.out.println(chaine);

    }
}
