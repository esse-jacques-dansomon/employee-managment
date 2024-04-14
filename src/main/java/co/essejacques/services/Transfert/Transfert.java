package co.essejacques.services.Transfert;

import co.essejacques.entities.Employee;
import co.essejacques.enums.PaymentMethod;

public interface Transfert {
    void  process(Employee compte , Double mnt);
}