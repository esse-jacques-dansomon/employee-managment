package co.essejacques.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmployeeStatus {
    ABSENT("Absent"),
    PRESENT("Present"),
    ON_LEAVE("On Leave"),
    SICK("Sick"),
    ACTIVE( "Active");
    private final String value;
}