package MyEntity;

public class Course {
    private String cno;
    private String cname;
    private String cpno;
    private int ccredit;

    public Course() {
    }

    public String getCno() {
        return cno;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", cpno='" + cpno + '\'' +
                ", ccredit=" + ccredit +
                '}';
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setCpno(String cpno) {
        this.cpno = cpno;
    }

    public void setCcredit(int ccredit) {
        this.ccredit = ccredit;
    }

    public String getCname() {
        return cname;
    }

    public String getCpno() {
        return cpno;
    }

    public int getCcredit() {
        return ccredit;
    }
}
