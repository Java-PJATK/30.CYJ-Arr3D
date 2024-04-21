// CYJ-Arr3D/Arr3D.java
 
public class Arr3D {

    public static void main(String[] args) {
        String[] subjects = {
            "Math", "Programming", "English"
        };

        String[] students = {
            "John",  "Mark",  "Jim", "Henry",
            "Peter", "Kevin", "Jack"
        };
          // three-dimensional array of grades:
          //     first index  - student
          //     second index - subject for a given student
          //     third index  - grades for a given student
          //                    and a given subject
        int[][][] grades = {
          //   Math     Programming    English
            { {3,4,3}, {4,3,3,4,4,3}, {4,3,3} }, // stud. 0
            { {3,5},   {5,2,3,3,4},   {2,4}   }, // stud. 1
            { {5,4,4}, {5,5,5,4},     {3}     }, // stud. 2
            { {3,4,3}, {4,3,3,3,3},   {3,3,4} }, // stud. 3
            { {4,3},   {4,3,3},       {5,3}   }, // stud. 4
            { {5,3},   {4,2,3},       {3,3}   }, // stud. 5
            { {5,4},   {4,4,5},       {5,3}   }, // stud. 6
        };

        String[] pom = new String[students.length];
        int count = 0;
          // over students
        for (int s = 0; s < grades.length; ++s) {
            double ave = 0;
            int    num = 0;
              // over subjects for student s
            for (int c = 0; c < grades[s].length; ++c) {
                num += grades[s][c].length;
                  // over grades for student s, subject c
                for (int g = 0; g < grades[s][c].length;++g)
                    ave += grades[s][c][g];
            }
            ave /= num;
            if (ave > 4) pom[count++] = students[s];
        }

        String[] result = new String[count];
        for (int i = 0; i < count; ++i)
            result[i] = pom[i];

        System.out.print("Best students of the group:");
        for (String s : result)
            System.out.print(" " + s);
        System.out.println();
    }
}
