import java.util.*;

class StudentManagemntSystem {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String[][] student = new String[0][2];
        int[][] marks = new int[0][2];
        while (true) {
            System.out.println("----------------------------------------------------------------------------------\n" +
                    "|                   WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                      |\n" +
                    "----------------------------------------------------------------------------------\n" +
                    "[1]Add New Student                      [2]Add New Student With Marks\n" +
                    "[3]Add Marks                            [4]Update Student Details\n" +
                    "[5]Update Marks                         [6]Delete Student\n" +
                    "[7]Print Student Details                [8]Print Student Ranks\n" +
                    "[9]Best in Programming Fundamentals     [10]Best in Database Management System");
            System.out.print("Enter an option to continue > ");
            int option = read.nextInt();
            clearConsole();
            switch (option) {
                case 1: {
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("|                   ADD NEW STUDENT                                              |");
                    System.out.println("----------------------------------------------------------------------------------");
                    String answer = "y";
                    while (answer.equals("y")) {
                        //Add student
                        student = addStudent(student);
                        marks = addMarks(student);
                        System.out.print("\nStudent has been successfully added, do you want to add another student (y/n)?");
                        answer = read.next();
                        System.out.println();
                        if (answer.equals("n")) {
                            clearConsole();
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("|                   ADD NEW STUDENT WITH MARKS                                   |");
                    System.out.println("----------------------------------------------------------------------------------");
                    String answer = "y";
                    while (answer.equals("y")) {
                        student = addStudent(student);
                        System.out.println();
                        marks = addMarks(marks, student);
                        System.out.print("\nStudent has been successfully added, do you want to add another student (y/n)?");
                        answer = read.next();
                        System.out.println();
                        if (answer.equals("n")) {
                            clearConsole();
                            break;
                        }
                    }
                    break;
                }

                case 3: {
                    String answer = "y";
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("|                   ADD MARKS                                                    |");
                    System.out.println("----------------------------------------------------------------------------------");
                    while (answer.equals("y")) {
                        System.out.print("Enter Student Id : ");
                        String id = read.next();
                        int check = 0;
                        for (int i = 0; i < student.length; i++) {
                            if (id.equals(student[i][0])) {
                                check = 1;
                                if (marks.length == 0) {
                                    marks = addMarks(marks, student, i);
                                    System.out.print("Marks have been added, Do you want to add marks for Another student? (y/n)");
                                    answer = read.next();
                                    if (answer.equals("n")) {
                                        clearConsole();
                                        break;
                                    } else if (answer.equals("y")) {
                                    }
                                } else if (marks[i][0] != 0) {
                                    System.out.println("This Student's marks have been already added");
                                    System.out.println("Do you want to their marks? Please use [4] Update Marks option. \n");
                                    System.out.print("Do you want to add marks for another student? (y/n)");
                                    answer = read.next();
                                    if (answer.equals("n")) {
                                        clearConsole();
                                        break;
                                    } else if (answer.equals("y")) {
                                    }
                                } else if (marks[i][0] == 0) {
                                    addMarks(marks, student, i);
                                    System.out.print("\nMarks have been added, Do you want to add marks for Another student? (y/n)");
                                    answer = read.next();
                                    if (answer.equals("n")) {
                                        clearConsole();
                                        break;
                                    } else if (answer.equals("y")) {
                                        clearConsole();
                                    }
                                }

                            }

                        }
                        if (check == 0) {
                            System.out.print("\nInvalid Student Id. Do you want to search again? (y/n)");
                            answer = read.next();
                            if (answer.equals("n")) {
                                clearConsole();
                                break;
                            } else if (answer.equals("y")) {
                            }

                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("|                   UPDATE STUDENT DETAILS                                       |");
                    System.out.println("----------------------------------------------------------------------------------");
                    String answer = "y";
                    while (answer.equals("y")) {
                        System.out.print("\nEnter Student Id : ");
                        String id = read.next();
                        int check = 0;
                        for (int i = 0; i < student.length; i++) {
                            if (id.equals(student[i][0])) {
                                check = 1;
                                System.out.println("\nStudent name           : " + student[i][1]);
                                System.out.print("Enter new student name : ");
                                String name = read.next();
                                updateStudent(student, name, i);
                                System.out.println("\nStudent details have been updated successfully.");
                                System.out.print("Do you want to update another student details? (y/n)");
                                answer = read.next();
                                if (answer.equals("n")) {
                                    clearConsole();
                                    break;
                                } else if (answer.equals("y")) {
                                }
                            }
                        }
                        if (check == 0) {
                            System.out.print("\nInvalid Student Id. Do you want to search again? (y/n)");
                            answer = read.next();
                            if (answer.equals("n")) {
                                clearConsole();
                                break;
                            } else if (answer.equals("y")) {
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    String answer = "y";
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("|                   UPDATE MARKS                                                 |");
                    System.out.println("----------------------------------------------------------------------------------");
                    while (answer.equals("y")) {
                        System.out.print("\nEnter Student Id : ");
                        String id = read.next();
                        int check = 0;
                        for (int i = 0; i < student.length; i++) {
                            check = 0;
                            if (id.equals(student[i][0])) {
                                check = 1;
                                if (marks.length == 0) {
                                    System.out.println("Student name : " + student[i][1] + "\n");
                                    System.out.println("This student's marks yet not added.");
                                    System.out.print("Do you want to update another student's marks? (y/n)");
                                    answer = read.next();
                                    if (answer.equals("n")) {
                                        clearConsole();
                                        break;
                                    } else if (answer.equals("y")) {
                                    }

                                } else if (marks[i][0] == 0 || marks[i][1] == 0) {
                                    System.out.println("Student name : " + student[i][1] + "\n");
                                    System.out.println("This student's marks yet not added.");
                                    System.out.print("Do you want to update another student's marks? (y/n)");
                                    answer = read.next();
                                    if (answer.equals("n")) {
                                        clearConsole();
                                        break;
                                    } else if (answer.equals("y")) {
                                    }
                                } else {
                                    System.out.println("Student name : " + student[i][1]);
                                    System.out.println("Programming Fundamentals Marks : " + marks[i][0]);
                                    System.out.println("Database Management System Marks : " + marks[i][0]);
                                    updateMarks(marks, i);
                                    System.out.print("Do you want to update another student's marks? (y/n)");
                                    answer = read.next();
                                    if (answer.equals("n")) {
                                        clearConsole();
                                        break;
                                    } else if (answer.equals("y")) {
                                        clearConsole();
                                    }
                                }
                            }
                        }
                        if (check == 0) {
                            System.out.print("Invalid Student ID. Do you want to search again?(y/n)");
                            answer = read.next();
                            if (answer.equals("n")) {
                                clearConsole();
                                break;
                            } else if (answer.equals("y")) {
                            }
                        }
                    }
                    break;
                }
                case 6: {
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("|                   DELETE STUDENT                                                 |");
                    System.out.println("----------------------------------------------------------------------------------");
                    String answer = "y";
                    while (answer.equals("y")) {
                        System.out.print("Enter Student Id : ");
                        String id = read.next();
                        int check = 0;
                        for (int i = 0; i < student.length; i++) {

                            if (id.equals(student[i][0])) {
                                check = 1;
                                student = deleteStudent(student, i);
                                if (marks.length != 0) marks = deleteMarks(marks, i);
                                System.out.println("Student has been deleted successfully");
                                System.out.print("Do you want to delete another student? (y/n)");
                                answer = read.next();
                                if (answer.equals("n")) {
                                    clearConsole();
                                    break;
                                } else if (answer.equals("y")) {
                                }
                            }
                        }
                        if (check == 0) {
                            System.out.print("Invalid student ID. Do you want to search again?(y/n)");
                            answer = read.next();
                            if (answer.equals("n")) {
                                clearConsole();
                                break;
                            } else if (answer.equals("y")) {
                            }
                        }
                    }
                    break;
                }
                case 7: {
                    String answer = "y";
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("|                   PRINT STUDENT DETAILS                                        |");
                    System.out.println("----------------------------------------------------------------------------------");
                    l1:
                    while (answer.equals("y")) {
                        System.out.print("\nEnter Student Id : ");
                        String id = read.next();
                        int check = 0;
                        for (int i = 0; i < student.length; i++) {
                            if (id.equals(student[i][0])) {
                                check = 1;
                                if (marks.length == 0 || marks[i][0] == 0) {
                                    System.out.println("Marks ye to be added");
                                    System.out.print("Do you want to search another student? (y/n)");
                                    answer = read.next();
                                    if (answer.equals("y")) {
                                    } else if (answer.equals("n")) {
                                        clearConsole();
                                        break l1;
                                    }
                                } else {
                                    System.out.println("Student name     : " + student[i][1]);
                                    printDetails(student, marks, i);
                                    System.out.print("Do you want to go back to main menu? (y/n)");
                                    answer = read.next();
                                    if (answer.equals("y")) {
                                        clearConsole();
                                        break l1;
                                    } else if (answer.equals("n")) {
                                        answer = "y";
                                    }
                                }
                            }
                        }
                        if (check == 0) {
                            System.out.print("Invalid Student ID, Do you want to search again? (y/n)");
                            answer = read.next();
                            System.out.println();
                            if (answer.equals("n")) {
                                clearConsole();
                                break;
                            } else if (answer.equals("y")) {
                            }
                        }
                    }
                    break;
                }
                case 8: {
                    String answer = "n";
                    while (answer.equals("n")) {
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("|                   PRINT STUDENT RANKS                                          |");
                        System.out.println("----------------------------------------------------------------------------------");
                        printRank(student, marks);
                        System.out.print("Do you want to go back to main menu? (y/n)");
                        answer = read.next();
                        if (answer.equals("n")) {
                        } else if (answer.equals("y")) {
                            clearConsole();
                            break;
                        }
                    }
                    break;
                }
                case 9: {
                    String answer = "n";
                    while (answer.equals("n")) {
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("|                   BEST IN PROGRAMMING FUNDAMENTALS                              |");
                        System.out.println("----------------------------------------------------------------------------------");
                        printPrf(student, marks);
                        System.out.print("Do you want to go back to main menu? (y/n)");
                        answer = read.next();
                        if (answer.equals("n")) {
                        } else if (answer.equals("y")) {
                            clearConsole();
                            break;
                        }
                    }
                    break;
                }
                case 10: {
                    String answer = "n";
                    while (answer.equals("n")) {
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("|                   BEST IN DATABASE MANAGEMENT SYSTEM                           |");
                        System.out.println("----------------------------------------------------------------------------------");
                        printDbm(student, marks);
                        System.out.print("Do you want to go back to main menu? (y/n)");
                        answer = read.next();
                        if (answer.equals("n")) {
                        } else if (answer.equals("y")) {
                            clearConsole();
                            break;
                        }
                    }
                    break;
                }
                default:
                    System.out.println("error");
            }
        }
    }

    private static int[][] addMarks(String[][] student) {
        return new int[student.length][2];
    }

    public static void printPrf(String[][] student, int[][] marks) {
        int[][] prf = new int[student.length][2];
        for (int i = 0; i < student.length; i++) {
            prf[i][0] = marks[i][0];
            prf[i][1] = i;
        }
        for (int i = 0; i < prf.length; i++) {
            for (int j = i + 1; j < prf.length; j++) {
                int tmp = 0;
                int temp = 2;
                if (prf[i][0] < prf[j][0]) {
                    tmp = prf[i][0];
                    temp = prf[i][1];
                    prf[i][0] = prf[j][0];
                    prf[i][1] = prf[j][1];
                    prf[j][0] = tmp;
                    prf[j][1] = temp;
                }
            }
        }
        System.out.println("+------+---------------+-----------+---------+");
        System.out.println("|ID    |Name           |PF Marks   |DBM Marks|");
        System.out.println("+------+---------------+-----------+---------+");
        for (int i = 0; i < student.length; i++) {
            System.out.printf("%1s %4s %1s %-13s %1s %9d %1s %7d %1s%n", "|", student[prf[i][1]][0], "|", student[prf[i][1]][1], "|", marks[prf[i][1]][0], "|", marks[prf[i][1]][1], "|");
        }
        System.out.println("+-----+-----+---------------+------+---------+");
    }

    public static void printDbm(String[][] student, int[][] marks) {
        int[][] dbm = new int[student.length][2];
        for (int i = 0; i < student.length; i++) {
            dbm[i][0] = marks[i][1];
            dbm[i][1] = i;
        }
        for (int i = 0; i < dbm.length; i++) {
            for (int j = i + 1; j < dbm.length; j++) {
                int tmp = 0;
                int temp = 2;
                if (dbm[i][0] < dbm[j][0]) {
                    tmp = dbm[i][0];
                    temp = dbm[i][1];
                    dbm[i][0] = dbm[j][0];
                    dbm[i][1] = dbm[j][1];
                    dbm[j][0] = tmp;
                    dbm[j][1] = temp;
                }
            }
        }
        System.out.println("+------+---------------+-----------+---------+");
        System.out.println("|ID    |Name           |DBM Marks  |PRF Marks|");
        System.out.println("+------+---------------+-----------+---------+");
        for (int i = 0; i < student.length; i++) {
            System.out.printf("%1s %4s %1s %-13s %1s %9d %1s %7d %1s%n", "|", student[dbm[i][1]][0], "|", student[dbm[i][1]][1], "|", marks[dbm[i][1]][1], "|", marks[dbm[i][1]][0], "|");
        }
        System.out.println("+-----+-----+----------+-----------+---------+");
    }

    public static void printRank(String[][] student, int marks[][]) {
        int rank[][] = new int[student.length][2];
        double average[][] = new double[student.length][1];
        int total[][] = new int[student.length][1];

        for (int i = 0; i < student.length; i++) {
            rank[i][0] = getRank(marks, ((marks[i][0] + marks[i][1]) / 2.0), i);
            rank[i][1] = i;
            total[i][0] = marks[i][0] + marks[i][1];
            average[i][0] = ((marks[i][0] + marks[i][1]) / 2.0);
        }
        for (int i = 0; i < rank.length; i++) {
            for (int j = i + 1; j < rank.length; j++) {
                int tmp = 0;
                int temp = 2;
                if (rank[i][0] > rank[j][0]) {
                    tmp = rank[i][0];
                    temp = rank[i][1];
                    rank[i][0] = rank[j][0];
                    rank[i][1] = rank[j][1];
                    rank[j][0] = tmp;
                    rank[j][1] = temp;
                }
            }
        }
        System.out.println("+------+------+---------------+-----------+---------+");
        System.out.println("|Rank  |ID    |Name           |Total Marks|Avg Marks|");
        System.out.println("+------+------+---------------+-----------+---------+");
        for (int i = 0; i < student.length; i++) {
            System.out.printf("%-1s %-4d %1s %4s %1s %-13s %1s %9d %1s %7.2f %1s%n", "|", rank[i][0], "|", student[rank[i][1]][0], "|", student[rank[i][1]][1], "|", total[rank[i][1]][0], "|", average[rank[i][1]][0], "|");
        }
        System.out.println("+------+------+---------------+-----------+---------+");
    }

    public static void printDetails(String[][] student, int[][] marks, int index) {
        double total = getTotal(marks[index][0], marks[index][1]);
        double avg = total / 2;
        int[] ranks = new int[student.length];
        for (int i = 0; i < student.length; i++) {
            ranks[i] = getRank(marks, (marks[i][0] + marks[i][1]) / 2.0, i);
        }
        for (int i = 0; i < ranks.length; i++) {
            for (int j = i + 1; j < ranks.length; j++) {
                int tmp = 0;
                if (ranks[i] > ranks[j]) {
                    tmp = ranks[i];
                    ranks[i] = ranks[j];
                    ranks[j] = tmp;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < student.length - 1; i++) {
            if (ranks[ranks.length - 1] == ranks[i]) count = count + 1;
        }


        int rank = getRank(marks, avg, index);
        String rankS = "";
        rankS = (rank == 1) ? "1(First)" : (rank == 2) ? "2(Second)" : (rank == 3) ? "3(Third)" : (rank == (student.length - count)) ? rank + "(Last)" : rankS + rank;
        System.out.println("+----------------------------------+--------------------+");
        System.out.print("|Programming Fundamental Marks     |");
        System.out.printf("%20d%1s%n", marks[index][0], "|");
        System.out.print("|Database Management System Marks  |");
        System.out.printf("%20d%1s%n", marks[index][1], "|");
        System.out.print("|Average Marks                     |");
        System.out.printf("%20.2f%1s%n", avg, "|");
        System.out.print("|Rank                              |");
        System.out.printf("%20s%1s%n", rankS, "|");
        System.out.println("+----------------------------------+--------------------+");
    }

    public static int getRank(int[][] marks, double average, int index) {
        double[] avg = new double[marks.length];
        double total = 0;
        int rank = 0;
        for (int i = 0; i < marks.length; i++) {
            total = getTotal(marks[i][0], marks[i][1]);
            avg[i] = total / 2;
        }

        for (int i = 0; i < avg.length; i++) {
            for (int j = i + 1; j < avg.length; j++) {
                double tmp = 0;
                if (avg[i] < avg[j]) {
                    tmp = avg[i];
                    avg[i] = avg[j];
                    avg[j] = tmp;
                }
            }
        }
        for (int i = 0; i < avg.length; i++) {
            if (avg[i] == average) {
                rank = i + 1;
                break;
            }
        }
        return rank;
    }

    public static double getTotal(int mark1, int mark2) {
        double total = 0;
        total += mark1 + mark2;
        return total;
    }

    public static String[][] deleteStudent(String[][] student, int index) {
        String[][] temp = new String[student.length - 1][2];
        int k = 0;
        for (int i = 0; i < student.length; i++) {
            if (index == i) {
                continue;
            }
            temp[k][0] = student[i][0];
            temp[k][1] = student[i][1];
            k++;
        }
        return temp;
    }

    public static int[][] deleteMarks(int[][] marks, int index) {
        int[][] temp = new int[marks.length - 1][2];
        int k = 0;
        for (int i = 0; i < marks.length; i++) {
            if (index == i) {
                continue;
            }
            temp[k][0] = marks[i][0];
            temp[k][1] = marks[i][1];
            k++;
        }
        return temp;
    }

    public static void updateMarks(int[][] marks, int index) {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter new Programming Fundamentals Marks : ");
        int prf = read.nextInt();
        System.out.print("Enter new Database Management System Marks : ");
        int dbms = read.nextInt();
        marks[index][0] = prf;
        marks[index][1] = dbms;

    }

    public static int[][] addMarks(int marks[][], String[][] student) {
        int[][] temp = new int[student.length][2];
        Scanner read = new Scanner(System.in);
        int prf = -1;
        while (prf < 0 || prf > 100) {
            System.out.print("Programming Fundamentals Marks   : ");
            prf = read.nextInt();
            if (prf < 0 || prf > 100) {
                System.out.println("Invalid marks, please enter correct marks!\n");
            }
        }
        int dbms = -1;
        while (dbms < 0 || dbms > 100) {
            System.out.print("Database Management System Marks : ");
            dbms = read.nextInt();
            if (dbms < 0 || dbms > 100) {
                System.out.println("Invalid marks, please enter correct marks!\n");
            }
        }
        for (int i = 0; i < marks.length; i++) {
            temp[i][0] = marks[i][0];
            temp[i][1] = marks[i][1];
        }
        temp[student.length - 1][0] = prf;
        temp[student.length - 1][1] = dbms;
        return temp;
    }

    public static int[][] addMarks(int marks[][], String[][] student, int index) {
        Scanner read = new Scanner(System.in);
        int prf = -1;
        System.out.println("Student name : " + student[index][1] + "\n");
        while (prf < 0 || prf > 100) {
            System.out.print("Programming Fundamentals Marks : ");
            prf = read.nextInt();
            if (prf < 0 || prf > 100) {
                System.out.println("Invalid marks, please enter correct marks!\n");
            }
        }
        int dbms = -1;
        while (dbms < 0 || dbms > 100) {
            System.out.print("Database Management System Marks : ");
            dbms = read.nextInt();
            if (dbms < 0 || dbms > 100) {
                System.out.println("Invalid marks, please enter correct marks!\n");
            }
        }
        int[][] temp = new int[student.length][2];
        for (int i = 0; i < marks.length; i++) {
            temp[i][0] = marks[i][0];
            temp[i][1] = marks[i][1];
        }
        marks = temp;
        marks[index][0] = prf;
        marks[index][1] = dbms;
        return marks;


    }

    public static String[][] addStudent(String[][] student) {
        String[][] temp = new String[student.length + 1][2];
        Scanner read = new Scanner(System.in);
        int check = 1;
        while (check == 1) {
            System.out.print("Enter student id\t");
            String id = read.next();
            read.nextLine();
            check = checkDups(student, id);
            if (check == 0) {
                System.out.print("Enter student name\t");
                String name = read.nextLine();
                for (int i = 0; i < student.length; i++) {
                    temp[i][0] = student[i][0];
                    temp[i][1] = student[i][1];
                }
                temp[student.length][0] = id;
                temp[student.length][1] = name;
            }
        }
        return temp;
    }

    public static void updateStudent(String[][] student, String name, int i) {
        student[i][1] = name;
    }

    public static int checkDups(String[][] student, String id) {
        int checkDups = 0;
        for (int i = 0; i < student.length; i++) {
            if (id.equals(student[i][0])) {
                checkDups = 1;
                System.out.println("The student id already exists!");
                break;
            }
        }
        return checkDups;
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }
}
