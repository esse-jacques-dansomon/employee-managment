package co.essejacques.services.Transfert;

import co.essejacques.entities.Employee;

public class TransfertWave implements Transfert {
    @Override
    public void process(Employee compte, Double mnt, String numero) {
        System.out.println("TransfertWave");
    }
}