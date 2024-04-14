package co.essejacques.entities;


import co.essejacques.enums.EmployeeStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class  Employee {
    private static Long numEmployee=0L;
    protected Long id;
    protected String matricule;
    protected EmployeeStatus status ;
    protected double onLeaveOffDays;

    protected Employee() {
        numEmployee++;
        this.id=numEmployee;
        this.onLeaveOffDays = 0;
    }

    protected Employee(String matricule) {
        numEmployee++;
        this.id=numEmployee;
        this.matricule = matricule;
        this.status = EmployeeStatus.PRESENT;
        this.onLeaveOffDays = 0;
    }

    protected void seOnLeaveOffDays(double days){
        this.onLeaveOffDays = days;
        this.status = EmployeeStatus.ON_LEAVE;
    }


}