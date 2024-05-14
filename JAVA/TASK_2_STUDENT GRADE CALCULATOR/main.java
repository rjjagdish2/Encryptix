import java.util.Scanner;

class Student {
    Scanner sc = new Scanner(System.in);
    short[] subject;
    int totalMarks = 0;
    double percentage = 0;
    String result = "pass";
    short numSubjects = 0;

    Student() {
        System.out.print("Enter Total Subjects: ");
        while (!sc.hasNextShort()) sc.next();
        numSubjects = sc.nextShort();
        subject = new short[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter Marks of Subject " + (i + 1) + ": ");
            while (!sc.hasNextShort()) sc.next();
            subject[i] = sc.nextShort();
            totalMarks += subject[i];
            if (subject[i] < 40) result = "fail";
        }
        if (result.equals("pass")) {
            percentage = (totalMarks * 100.0) / (numSubjects * 100.0);
            String grade;
            if (percentage > 90) grade = "A+";
            else if (percentage > 80) grade = "A";
            else if (percentage > 70) grade = "B+";
            else if (percentage > 60) grade = "B";
            else if (percentage > 50) grade = "C";
            else if (percentage >= 40) grade = "D";
            else grade = "Fail";
            display(grade);
        } else {
            display("Fail");
        }
    }

    void display(String grade) {
        System.out.println("\nResult\n--------------------------------");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Subject " + (i + 1) + ": " + subject[i]);
        }
        System.out.println("--------------------------------");
        System.out.println("Total  : " + totalMarks + " out of " + (numSubjects * 100));
        if (!result.equals("fail")) {
            System.out.println("Avg. Percentage  : " + percentage);
            System.out.println("Grade  : " + grade);
        } else {
            System.out.println("Grade  : " + grade);
        }
    }
}

class main {
    public static void main(String[] args) {
        Student stud1 = new Student();
    }
}
