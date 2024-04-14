# Devoir Principe Solid (2h30)
Supposons que nous souhaitons créer une application qui permet de manipuler des employés .
Un employé est caractérisé par  son id , son matricule et son état(Conge,Absent, Malade).
Un service est caractérisé par id , son code  et son nom
Les employés sont soit des Journaliers , soit des contractuels(CDI ou CDD) et  soit des prestataires  .

Les contractuels ont des primes de fin d'année qui correspondent à 10% de la somme des salaires reçu durant l'année.
En plus des attributs des employés, un contractuel a un salaire brut, une  prime, une retenue ,un salaire net et un service.
Salaire Net =Salaire Brut + prime-retenu
Un contractuel peut prendre des jours de congés.

En plus des attributs des employés,un journalier a un coût journalier , nombre jour travailler et un salaire.
Salaire  =coût journalier*nombre jour
Les prestataires facturent un service effectué ,ils ont comme attribut supplémentaire la période du service et le coût du service.

NB: Payement des salaires peuvent se faire par Virement Bancaire, par OM ou par Wave
TAF
Enregistrer un Service dans une liste
Enregistrer un Employé dans une liste
Virer Salaire
Enregistrer un congé pour un Employé
Vous devez respecter les principes SOLID , pour que votre solution soit la plus maintenable et évolutif possible .

Livrable :
Vous me partagez le repository du Devoir
Email : douvewane85@gmail.com