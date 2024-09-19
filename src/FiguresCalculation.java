import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FiguresCalculation {

    private static void readDataFromFile(FiguresInputData data, String file) {
        try(BufferedReader input = new BufferedReader(new FileReader(file))) {
            String line;
            String[] dividedLine;

            line = input.readLine();
            dividedLine = line.split(" ");
            data.aTriangle = Double.parseDouble(dividedLine[0]);
            data.bTriangle = Double.parseDouble(dividedLine[1]);
            data.cTriangle = Double.parseDouble(dividedLine[2]);

            data.aRectangle = Double.parseDouble(dividedLine[0]);
            data.bRectangle = Double.parseDouble(dividedLine[1]);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static Figure[] readFiguresDataFromFile(String file) {
        Figure[] data = null;
        try(BufferedReader input = new BufferedReader(new FileReader(file))) {
            String line;
            String[] dividedLine;

            line = input.readLine();
            data = new Figure[Integer.parseInt(line)];

            for (int i = 0; i < data.length; i++) {
                line = input.readLine();
                dividedLine = line.split(" ");
                switch (Integer.parseInt(dividedLine[0])) {
                    case 3:
                        data[i] = new Triangle(Double.parseDouble(dividedLine[1]),
                                Double.parseDouble(dividedLine[2]),
                                Double.parseDouble(dividedLine[3]));
                        break;
                    case 2:
                        data[i] = new Rectangle(Double.parseDouble(dividedLine[1]), Double.parseDouble(dividedLine[2]));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    private static void readData(FiguresInputData data) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter triangle sides:");
        data.aTriangle = input.nextDouble();
        data.bTriangle = input.nextDouble();
        data.cTriangle = input.nextDouble();
        System.out.println("Enter rectangle sides:");
        data.aRectangle = input.nextDouble();
        data.bRectangle = input.nextDouble();
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
        Figure[] figures;
        String result;

        //readDataFromFile(data, "input.txt");
        figures = readFiguresDataFromFile("input2.txt");

        //Triangle tr = new Triangle(data.aTriangle, data.bTriangle, data.cTriangle);
        //Rectangle rect = new Rectangle(data.aRectangle, data.bRectangle);
        //Figure[] toCalculate = {tr, rect};
        Figure[] toCalculate = figures;

        Arrays.sort(toCalculate);
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
    double aTriangle, bTriangle, cTriangle, aRectangle, bRectangle;
}