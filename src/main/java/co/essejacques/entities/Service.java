package co.essejacques.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Service {
    private static Long numEmployee = 1L;
    private Long id;
    private String code;
    private String name;

    public Service(String code, String name) {
        this.code = code;
        this.name = name;
        this.id = Service.numEmployee++;
    }
}