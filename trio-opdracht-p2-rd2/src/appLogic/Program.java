package appLogic;

// Abstract parent class for the child classes Movie and Episode.

public abstract class Program {

    private int programId;
    private String programName;
    private String length;

    public Program(int programId, String programName, String length) {
        this.programId = programId;
        this.programName = programName;
        this.length = length;
    }

    // Every class attribute has its own getter and setter.

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
