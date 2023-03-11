package week3;

import java.time.LocalDate;

public class Designer extends Person{
    private String designerType;

    public Designer(String name, LocalDate birthDate, String designerType){
        super(name, birthDate);
        this.designerType = designerType;
    }

    public String getDesignerType() {
        return designerType;
    }

    public void setDesignerType(String designerType) {
        this.designerType = designerType;
    }
}
