package co.essejacques.services.Transfert;

import co.essejacques.entities.Employee;

public class TransfertBank implements Transfert {

    @Override
    public void process(Employee compte, Double mnt) {
        System.out.println("TransfertBank");
        //compte.retrait(mnt);
    }
}