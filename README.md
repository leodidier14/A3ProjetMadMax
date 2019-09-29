# A3ProjetMadMax

Contexte

Dans le contexte du projet Mad Max, vous avez eu pour objectif de construire une grue visant à ouvrir un abri anti-atomique (phase 1). A présent (phase 2), une nouvelle opportunité se présente. Un clan rival est en possession d’une clé USB contenant des informations permettant de localiser un site d’approvisionnement en ressource. Vous projetez de dérober la clé USB avec votre grue. Le clan rival, sachant qu’une possibilité réelle de vol existe, a pris soin de crypter les informations. Après avoir mené à bien une opération d’infiltration, vous avez obtenu les informations suivantes concernant le cryptage des données :

Type cryptage : symétrique
Technique d’opérateur : xOr
Longueur de clé : 12 caractères alpha
Tous caractères de l’alphabet
Minuscule uniquement
La clé USB étant un matériel fragile, vous devez prévoir un dispositif de sécurité (module de détection de distance) permettant de vous rendre compte de la distance entre le crochet de la grue et la clé USB.

Objectifs
L’objectif principal de cette activité est de voler les ressources. Pour cela vous devez récupérer la clé et ensuite, décrypter le fichier et obtenir les informations de localisation des ressources. Pour cela, vous devez réaliser les étapes suivantes :

Concevoir la solution software (décrypter) et hardware (détection de distance)
Dérober la clé USB à l’aide de la grue
Récupérer le fichier crypté
Décrypter les fichiers
Localiser le site
Dérober les ressources

Vous trouverez ci-après les spécifications fonctionnelles à mettre en œuvre.

• Fonctionnalité « Authentifier » : Doit permettre à l’utilisateur de s’accréditer auprès de la plateforme à l’aide du couple login et mot de passe.
• Fonctionnalité « Charger le fichier crypter » : Doit permettre à l’utilisateur de sélectionner un fichier dans le but de les décrypter ultérieurement.
• Fonctionnalité « Identifier le fichier de destination » : Doit permettre à l’utilisateur de sélectionner un fichier dans le but de les décrypter ultérieurement.
• Fonctionnalité « Décrypter » : Doit permettre à l’utilisateur d’obtenir un fichier en clair.
