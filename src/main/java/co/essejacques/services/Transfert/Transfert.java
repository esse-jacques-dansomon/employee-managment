package co.essejacques.services.Transfert;

import co.essejacques.entities.Employee;

public interface Transfert {
    void  process(Employee compte , Double mnt, String numero);
}