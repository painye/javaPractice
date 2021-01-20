package MyEntity;

public class Student {
    private String sno;
    private String sname;
    private String ssex;
    private int sage;
    private String sddept;

    public Student(String sno, String sname, String ssex, int sage, String sddept) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
        this.sddept = sddept;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", sddept='" + sddept + '\'' +
                '}';
    }
}
