
public class IsChanges {

    private boolean sideA;
    private boolean sideB;
    private boolean sideC;
    private boolean angleA;
    private boolean angleB;
    private boolean angleC;

    
    public IsChanges(){
        
    }

    public IsChanges(boolean sideA, boolean sideB, boolean sideC, boolean angleA, boolean angleB, boolean angleC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.angleA = angleA;
        this.angleB = angleB;
        this.angleC = angleC;
    }
    
    
    public boolean isSideA() {
        return sideA;
    }

    public void setSideA(boolean sideA) {
        this.sideA = sideA;
    }

    public boolean isSideB() {
        return sideB;
    }

    public void setSideB(boolean sideB) {
        this.sideB = sideB;
    }

    public boolean isSideC() {
        return sideC;
    }

    public void setSideC(boolean sideC) {
        this.sideC = sideC;
    }

    public boolean isAngleA() {
        return angleA;
    }

    public void setAngleA(boolean angleA) {
        this.angleA = angleA;
    }

    public boolean isAngleB() {
        return angleB;
    }

    public void setAngleB(boolean angleB) {
        this.angleB = angleB;
    }

    public boolean isAngleC() {
        return angleC;
    }

    public void setAngleC(boolean angleC) {
        this.angleC = angleC;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IsChanges other = (IsChanges) obj;
        if (this.sideA != other.sideA) {
            return false;
        }
        if (this.sideB != other.sideB) {
            return false;
        }
        if (this.sideC != other.sideC) {
            return false;
        }
        if (this.angleA != other.angleA) {
            return false;
        }
        if (this.angleB != other.angleB) {
            return false;
        }
        if (this.angleC != other.angleC) {
            return false;
        }
        return true;
    }
    
    
    
    
}
