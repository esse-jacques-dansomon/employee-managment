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
    protected int onLeaveOffDays;

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

    public void setOnLeaveOffDays(int days){
        this.onLeaveOffDays = days;
        this.status = EmployeeStatus.ON_LEAVE;
    }

    public void setPresent(){
        this.status = EmployeeStatus.PRESENT;
    }

    public void setAbsent(){
        this.status = EmployeeStatus.ABSENT;
    }

    public void setSick(){
        this.status = EmployeeStatus.SICK;
    }

    public abstract double calculerSalaire();


}