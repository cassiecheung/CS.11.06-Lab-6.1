import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challengeOneAnswer = challengeOne("inputOneTwo.txt");
        System.out.println(challengeOneAnswer);
        int challengeTwoAnswer = challengeTwo("inputOneTwo.txt");
        System.out.println(challengeTwoAnswer);
        int challengeThreeAnswer = challengeThree("inputThreeFour.txt");
        System.out.println(challengeThreeAnswer);
        int challengeFourAnswer = challengeFour("inputThreeFour.txt");
        System.out.println(challengeFourAnswer);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int count = 0;
        int[] array = readFile(fileName);
        for (int x = 0; x < array.length - 1; x++) {
            if (array[x] < array[x + 1]) {
                count++;
            }
            count = count;
        }
        return count; // ans: 1665
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int count = 0;
        int[] array = readFile(fileName);
        for (int x = 0; x < array.length - 3; x++) {
            int windowOne = array[x] + array[x + 1] + array[x + 2];
            int windowTwo = array[x + 1] + array[x + 2] + array[x + 3];
            if (windowTwo > windowOne) {
                count++;
            }
        }
        return count; // ans: 1683
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] array = readStringFile(fileName);
        int x = 0; // horizontal
        int y = 0; // vertical/depth
        for (String single: array) {
            int value = Integer.parseInt(single.substring(single.length() - 1)); // getting the int value
            if (single.contains("forward")) {
                x = x + value;
            }
            if (single.contains("down")) {
                y = y + value;
            }
            if (single.contains("up")) {
                y = y - value;
            }
        }
        return x * y; // ans: 1524750
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String[] array = readStringFile("InputThreeFour.txt");
        int x = 0; // horizontal
        int y = 0; // vertical/depth
        int aim = 0;
        for (String single: array) {
            int value = Integer.parseInt(single.substring(single.length() - 1)); // getting the int value
            if (single.contains("forward")) {
                x = x + value;
                y = y + (aim * value);
            }
            if (single.contains("down")) {
                aim = aim + value;
            }
            if (single.contains("up")) {
                aim = aim - value;
            }
        }
        return x * y; // ans: 1592426537
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

    private static String[] readStringFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

}