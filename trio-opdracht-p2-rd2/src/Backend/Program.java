package Backend;

public class Program {

    private int programId;
    private String programName;
    private String length;

    public Program(int programId, String programName, String length) {
        this.programId = programId;
        this.programName = programName;
        this.length = length;
    }

    // Ieder attribuut heeft een getter en setter.


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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Program Id: " + this.getProgramId() + "\n");
        sb.append("Program name: " + this.getProgramName() + "\n");
        sb.append("Length: " + this.getLength() + "\n");

        return sb.toString();
    }
}
