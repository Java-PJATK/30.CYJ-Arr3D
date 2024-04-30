# CYJ-Arr3D
Listing 30 CYJ-Arr3D/Arr3D.java Page 58

In the next example, we use a three-dimensional array of ints: the first index corresponds to a student, the second to a course he/she is taking and the third to the grades of this student and this course:  

# Listing 30 CYJ-Arr3D/Arr3D.java

```java
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
```

The variable `grades` is really a reference (pointer) to an array of references to two-dimensional arrays. Each element of the array grades corresponds to one student, so, for example, `grades.length` is 7. Therefore, `grades[1]` is the reference to a two-dimensional array corresponding to the second (as indexing starts from 0) student. This array is really an array of references to arrays of ints, each of which corresponds to one course.  

For example, `grades[1][1]` is the reference to the array of grades of the second student and of the second course (the one with elements 5, 2, 3, 3, 4). Therefore, `grades[1][1].length` is 5. Finally, `grades[1][1][4]` is of type int and has value 4.  

The loop in lines 31-43 is a nested loop: we iterate over students (index s) and for each student we calculate the average of his/her grades — in num we will collect number of grades and in ave the sum of grades. If the average of all this student’s grades is grater than 4, we add his/her name to the array `pom`. 

This array is created before the loop; as we don’t know in advance what the number of ’good’ students will be, we create it with size grades.length and then, when we are done (line 45) and we know this number, we create another array, result of the correct size and copy elements from `pom` to `results`, which is then printed

```
Best students of the group: Jim Jack
```

In a similar way, having such a three-dimensional array, we could ask other questions, like

*  find the index of the student with highest average of grades;  

*  find the index of the student with highest average of grades of the course number c;  

*  find the number of all students who got at least one grade 2;  
  
*  find the number of all students who never got a 2 grade;  

*  create an array containing averages of all grades for each student;  

*  and so on...
