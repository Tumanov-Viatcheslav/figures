import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FiguresCalculation {

    private static void readDataFromFile(FiguresInputData data, String file) {
        try(BufferedReader input = new BufferedReader(new FileReader(file))) {
            String line;
            String[] dividedLine;

            line = input.readLine();
            dividedLine = line.split(" ");
            data.aTriangle = Integer.parseInt(dividedLine[0]);
            data.bTriangle = Integer.parseInt(dividedLine[1]);
            data.cTriangle = Integer.parseInt(dividedLine[2]);

            data.aRectangle = Integer.parseInt(dividedLine[0]);
            data.bRectangle = Integer.parseInt(dividedLine[1]);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void readData(FiguresInputData data) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter triangle sides:");
        data.aTriangle = input.nextInt();
        data.bTriangle = input.nextInt();
        data.cTriangle = input.nextInt();
        System.out.println("Enter rectangle sides:");
        data.aRectangle = input.nextInt();
        data.bRectangle = input.nextInt();
    }

    private static void writeResult(String result) {
        System.out.println(result);
    }

    private static void writeResultToFile(String result, String fileName) {
        try(FileWriter output = new FileWriter(fileName)) {
            output.write(String.valueOf(result));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        FiguresInputData data = new FiguresInputData();
        String result;

        readDataFromFile(data, "input.txt");

        Triangle tr = new Triangle(data.aTriangle, data.bTriangle, data.cTriangle);
        Rectangle rect = new Rectangle(data.aRectangle, data.bRectangle);
        Figure[] toCalculate = {tr, rect};

        result = "Figures' perimeters: ";
        for (Figure fig: toCalculate) {
            result += fig.perimeter() + " ";
        }
        result += "\nFigures' areas: ";
        for (Figure fig: toCalculate) {
            result += fig.area() + " ";
        }

        writeResult(result);
    }
}

class FiguresInputData {
    int aTriangle, bTriangle, cTriangle, aRectangle, bRectangle;
}